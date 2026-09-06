# SingleFlight Implementation Design for im-cds

## Overview

SingleFlight is a request deduplication mechanism that ensures only ONE backend call is made for concurrent requests to the same key. Other goroutines wait and share the result.

## Problem Statement

### Current Behavior (Without SingleFlight)

When multiple concurrent requests come for the same entity (e.g., `GROUP#123`):

```
Time 0ms: Request 1 for GROUP#123 → DDB call starts
Time 1ms: Request 2 for GROUP#123 → DDB call starts (DUPLICATE!)
Time 2ms: Request 3 for GROUP#123 → DDB call starts (DUPLICATE!)
Time 50ms: All 3 DDB calls complete

Result: 3 DDB calls, 3x DDB throughput consumed
```

### With SingleFlight

```
Time 0ms: Request 1 for GROUP#123 → DDB call starts
Time 1ms: Request 2 for GROUP#123 → waits for Request 1
Time 2ms: Request 3 for GROUP#123 → waits for Request 1
Time 50ms: DDB call completes, all 3 requests get result

Result: 1 DDB call, ~66% throughput saved
```

## Architecture

### Current Data Flow

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Request   │────▶│ Local Cache │────▶│   Valkey    │────▶│     DDB     │
│             │     │    (L0)     │     │    (L1)     │     │  (Source)   │
└─────────────┘     └─────────────┘     └─────────────┘     └─────────────┘
                            │                   │                   │
                            ▼                   ▼                   ▼
                        Cache Hit           Cache Hit           Fetch Data
                        (return)            (return)            (return)
```

### Proposed Data Flow with SingleFlight

```
┌─────────────┐   ┌─────────────┐   ┌─────────────┐   ┌──────────────┐   ┌─────────────┐
│   Request   │──▶│ Local Cache │──▶│   Valkey    │──▶│ SingleFlight │──▶│     DDB     │
│             │   │    (L0)     │   │    (L1)     │   │   (Dedup)    │   │  (Source)   │
└─────────────┘   └─────────────┘   └─────────────┘   └──────────────┘   └─────────────┘
                          │                 │                  │                  │
                          ▼                 ▼                  ▼                  ▼
                      Cache Hit         Cache Hit          Wait/Share         Fetch Data
                      (return)          (return)          (if in-flight)      (return)
```

**Key Point**: SingleFlight is added ONLY at the DDB layer, NOT at cache layers.

## Why Only at DDB Layer?

| Layer | Deduplication Needed? | Reason |
|---|---|---|
| Local Cache | No | In-memory, microsecond latency, no benefit |
| Valkey | No | Already handles concurrent reads efficiently |
| DDB | Yes | High latency (50-100ms), throughput costs money |

### Why we NEED this — the actual production problem

This is the **cache stampede / thundering herd** problem — the same one that shows up for celebrity/whale hot-key cases: when Valkey's entry for `GROUP#123` is missing (cold key, TTL expiry, eviction under memory pressure), **every concurrent request for that key misses cache at the same moment** and independently falls through to DDB.

```
Without SingleFlight:
50 concurrent requests for GROUP#123, Valkey just expired it
→ ALL 50 miss cache → ALL 50 hit DDB independently
→ 50 RCU consumed for data that's IDENTICAL 50 times over
→ risk: if GROUP#123's partition is already near its 3000 RCU ceiling, this tips it into throttling

With SingleFlight:
Same 50 concurrent requests
→ 1st request triggers the DDB call
→ other 49 wait on that SAME in-flight call, share its result when it returns
→ 1 RCU consumed instead of 50
```

This is the production implementation of the "cache + single-flight" hot-key fix.

### Interview questions & follow-ups

**Q: Why not apply singleflight everywhere for consistency/simplicity?**

A: Coordination isn't free — mutex/channel synchronization overhead. Applying it where the underlying op is already sub-microsecond (local cache) means paying coordination cost for zero benefit, and at high concurrency the singleflight's own internal lock could become a new bottleneck.

**Q: Doesn't singleflight add latency for the waiting requests?**

A: No — without singleflight, requests 2-49 would each make their OWN ~50-100ms DDB call anyway, arriving at roughly the same wall-clock time. With singleflight they wait on the SAME call and get the result at essentially the same time, just without wasting RCU. The benefit is throughput/cost reduction, not latency reduction (though at scale it indirectly protects latency by avoiding throttling).

**Q: What if the in-flight request's context gets cancelled (e.g., client 1 disconnects)?**

A: Real production gotcha — if the shared DDB call is tied to request 1's context and request 1 cancels, the shared call could get killed, failing requests 2-49 too, even though THEIR contexts are still valid. Production code should use a detached/background context for the actual DDB fetch inside singleflight, not the triggering request's context.

**Q: How is this different from caching?**

A: Caching persists a result for FUTURE requests. Singleflight only shares a result among requests that are **concurrently in-flight** at that exact moment — once the call completes, the deduplication window closes. The next request (even 1ms later) triggers a fresh call unless the cache layers already have it. Singleflight complements caching — it patches the race-condition gap during cache population, it doesn't replace caching.

**Q: What's the risk in key granularity?**

A: The singleflight group is keyed by a string (e.g., `entityId`). Too broad a key → unrelated requests incorrectly merged (wrong data returned to someone). Too narrow → real duplicates don't get deduplicated. Getting the key derivation exactly right matters.

**Q: How do you prove this actually helped in production?**

A: The doc's `SingleFlightGrouperTotal` / `SingleFlightGrouperShared` metrics — the ratio of `Shared`/`Total` tells you what % of requests were saved from hitting DDB. That's the ROI evidence.

**Q: Why the gradual rollout with per-DAL feature flags instead of enabling everywhere at once?**

A: Safety — singleflight changes failure semantics (see the FAQ: "all waiters get the same error"). Rolling out per-component (`SINGLEFLIGHT_GROUPER_ENABLED`, `SINGLEFLIGHT_MARGIN_ENABLED`, etc.) with a master kill switch (`SINGLEFLIGHT_ENABLED`) lets safety be verified incrementally, with rollback possible for one component without affecting others.

**Q: If the first (leader) request fails — e.g. DDB throttling — do all follower requests get the error, and does that mean nothing gets sent upstream?**

A: All followers get the SAME error — confirmed by the doc's own FAQ. But "nothing sent upstream" isn't quite right: every one of the N original callers still completes its own response cycle back to its own caller, just with an error response instead of a success response. Nothing disappears — N callers still get N replies, all failures.

```
Request 1 (leader) → calls DDB → DDB throttles → returns ProvisionedThroughputExceededException
   ↓
singleflight.Do() returns that SAME error to Request 1, 2, 3, ... N (all waiters)
   ↓
Each request still completes ITS OWN response back to ITS OWN caller — just with an error.
```

**No automatic retry inside singleflight** — `golang.org/x/sync/singleflight` doesn't retry. Once the leader's function errors, that error goes to all waiters and the key is immediately cleared from tracking. The very next request for that key (even 1ms later) starts a fresh round — it doesn't inherit the failure. Retry logic, if needed, must live in whatever calls this DAL function, outside singleflight's scope.

**The real trade-off:** without singleflight, 50 concurrent requests = 50 independent DDB calls — under throttling, some fraction might get through (partial success, e.g. 30 succeed/20 fail). With singleflight, those 50 become 1 call — if THAT call throttles, all 50 fail together (correlated failure instead of partial failure). The counterpoint: singleflight also makes throttling less likely in the first place, since it sends 1 RCU-consuming request instead of 50 — so overall fewer failures happen, but when one does occur, it's now all-or-nothing per key.

> **Interview soundbite:** *"SingleFlight doesn't retry — a failed leader call fails all waiters, but the key is cleared immediately so the next request gets a clean attempt. The trade-off is it converts 'partial failure under load' into 'correlated failure' — but since it also reduces the actual request volume hitting DDB, it lowers the odds of hitting throttling in the first place. Retry logic, if needed, has to live in the caller, not in singleflight itself."*

**Q: Does this SingleFlight actually dedupe requests across the whole fleet (multiple pods), or just within one instance?**

A: `golang.org/x/sync/singleflight` is **per-process only** — it's just an in-memory map + mutex inside one running instance. It does NOT coordinate across pods.

```
Scenario: im-cds runs 20 pods behind a load balancer
50 concurrent requests for GROUP#123 arrive, spread across those 20 pods

Within EACH pod: singleflight collapses its share of requests into 1 DDB call
Across ALL pods: up to 20 DDB calls still happen (1 per pod that got at least 1 request)

So singleflight here reduces "N duplicate calls per pod" → "1 call per pod,"
NOT "1 call across the entire fleet."
```

This is the most likely follow-up an interviewer asks: *"does this solve the stampede at scale, with multiple instances?"* — honest answer: **partially.** It reduces the fan-out multiplier by roughly the number of pods, not down to exactly 1 call fleet-wide. True cluster-wide dedup would need coordination through a shared point — e.g. a distributed lock per key in Valkey, so only one pod across the fleet fetches from DDB while others wait/poll Valkey — a distributed singleflight, more complex, only worth it if per-pod dedup isn't sufficient.

> **Interview soundbite:** *"This SingleFlight implementation is per-process, not cluster-wide — it dedupes concurrent requests within one pod's memory, not across the fleet. With N pods, a stampede still generates up to N DDB calls instead of 1. It's still a big win (N-per-pod → 1-per-pod), but a true global dedup would need a shared coordination point like a distributed lock in Valkey."*

## Components Affected

### 1. Grouper DAL (`im-cds/internal/pipeline/external/grouper/instamart/dal.go`)

Functions to wrap with SingleFlight: (2-3 more func)
- `batchGetGroupsFromDDB()` - fetches groups after Valkey miss
- `fetchGroupDetailsFromDDB()` - fetches group details after Valkey miss
- `batchGetGroupInfoFromDDB()` - fetches group info after Valkey miss

### 2. Margin DAL (`im-cds/internal/pipeline/external/marginer/dal.go`)

Functions to wrap with SingleFlight:
- `getMarginFromDDB()` - fetches margins after Valkey miss

### 3. Anchor Price DAL (`im-cds/internal/pipeline/external/anchor/dal.go`)

Functions to wrap with SingleFlight:
- `getAnchorPriceFromDDB()` - fetches anchor prices after Valkey miss

## Implementation Plan

### Phase 1: Core SingleFlight Package

**Location**: `im-cds/internal/utils/singleflight/`

```go
// singleflight.go - Core wrapper around golang.org/x/sync/singleflight
type SingleFlightGroup struct {
    group   singleflight.Group
    name    string // for metrics
    enabled bool
}

func (g *SingleFlightGroup) Do(ctx context.Context, key string, fn func() (interface{}, error)) Result
```

### Phase 2: Configuration

**Location**: `im-cds/config/config.go`

```go
// Add to Config struct
SingleFlightEnabled        bool `env:"SINGLEFLIGHT_ENABLED" envDefault:"false"`
SingleFlightGrouperEnabled bool `env:"SINGLEFLIGHT_GROUPER_ENABLED" envDefault:"false"`
SingleFlightMarginEnabled  bool `env:"SINGLEFLIGHT_MARGIN_ENABLED" envDefault:"false"`
SingleFlightAnchorEnabled  bool `env:"SINGLEFLIGHT_ANCHOR_ENABLED" envDefault:"false"`
```

**Location**: `im-cds/cmd/cdsserver/conf/integ.conf` and `prod.conf`

```
# SingleFlight Configuration
SINGLEFLIGHT_ENABLED=false
SINGLEFLIGHT_GROUPER_ENABLED=false
SINGLEFLIGHT_MARGIN_ENABLED=false
SINGLEFLIGHT_ANCHOR_ENABLED=false
```

### Phase 3: Metrics

**Location**: `im-cds/internal/cds/constants/constants.go`

```go
// SingleFlight metrics
SingleFlightGrouperTotal  = "singleflight_grouper_total"
SingleFlightGrouperShared = "singleflight_grouper_shared"
SingleFlightMarginTotal   = "singleflight_margin_total"
SingleFlightMarginShared  = "singleflight_margin_shared"
SingleFlightAnchorTotal   = "singleflight_anchor_total"
SingleFlightAnchorShared  = "singleflight_anchor_shared"
```

### Phase 4: DAL Integration

#### Grouper DAL Changes example

```go
// Add to Dao struct
type Dao struct {
    Config         *config.Config
    Provider       store.Provider
    ProviderNonDAX store.Provider
    CacheService   CacheServiceInterface
    singleFlight   *singleflight.SingleFlightGroup // NEW
}

// Modified batchGetGroupsFromDDB
func (d *Dao) batchGetGroupsFromDDB(ctx context.Context, entityIds []string) ([]*store.BatchGetOutput, error) {
    if d.singleFlight == nil || !d.singleFlight.IsEnabled() {
        return d.batchGetGroupsFromDDBDirect(ctx, entityIds)
    }

    // Use singleflight for each key
    results := make([]*store.BatchGetOutput, 0, len(entityIds))
    var wg sync.WaitGroup
    var mu sync.Mutex

    for _, entityId := range entityIds {
        wg.Add(1)
        go func(id string) {
            defer wg.Done()

            result := d.singleFlight.Do(ctx, id, func() (interface{}, error) {
                return d.fetchSingleEntityFromDDB(ctx, id)
            })

            mu.Lock()
            if result.Val != nil {
                results = append(results, result.Val.(*store.BatchGetOutput))
            }
            if result.Shared {
                metrics.IncrementCounterWithBlLabels(ctx, constants.SingleFlightGrouperShared)
            }
            mu.Unlock()
        }(entityId)
    }

    wg.Wait()
    return results, nil
}
```

## FAQ

**Q: Why not use singleflight at Valkey layer?**

A: Valkey is already fast (1-5ms) and handles concurrent reads efficiently. The overhead of singleflight coordination would negate any benefits.

**Q: What if the first request fails?**

A: All waiting requests will receive the same error. This is correct behavior - if DDB is down, all requests should fail.

**Q: Does this affect cache invalidation?**

A: No. SingleFlight only affects in-flight requests. Once a request completes, the key is removed from singleflight tracking.

**Q: What about different request contexts?**

A: All requests share the same result regardless of context. This is safe because we're only deduplicating DDB reads, which return the same data for the same key.
