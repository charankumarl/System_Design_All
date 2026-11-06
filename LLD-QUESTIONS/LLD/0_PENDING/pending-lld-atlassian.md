# Pending LLD — Atlassian SDE-2 Prep

Source: `Companies-Questions/atlassian-sde2-prep.html`. Cross-checked against what's already coded in `HLD-LLD-CHARAN-ARYAN/CWA-LowLevelDesignCode`.

## P0 — already coded, revise for these specific follow-ups

- [ ] **Snake Game** (`07_LLD_Interview_Problems/03_Design_Snake_and_Food_Game`)
  - Wrap-around-instead-of-game-over as a live requirement change (don't hardcode game-over-on-wall)
  - Deque-based optimization for the snake body
  - Concurrent/simultaneous key-press handling — be ready to discuss synchronization
  - Deliverable expected: working code + unit tests, not just design

- [ ] **API Rate Limiter** (`10_LLD_Concurrency_Interview_Problems/04_Design_Rate_Limiter`)
  - Compare Token Bucket vs Fixed Window vs Sliding Window out loud
  - Per-user AND per-API limiting
  - Thread safety under concurrent requests
  - Redis-backed distributed version (sketch)
  - Stretch: Trie-based route matching for a "Middleware Router" variant

## P1 — new builds required

- [ ] **File Storage System** (extend existing `09_Design File System`)
  - Recursive directory size calculation
  - Top-N largest directories
  - Be ready to justify List vs Set for storing file references
  - Storage vs retrieval speed trade-off discussion

- [ ] **Feature Flag Library** (nothing exists yet)
  - Create/update flags, enable/disable
  - User-based targeting, percentage rollout
  - Environment-specific configuration
  - Cache + refresh config, thread-safe evaluation path

## P2 — extension bench, do if time allows

- [ ] **Meeting Room Booking** (new — ties to Tennis Court Booking DSA interval pattern, do together)
- [ ] **Notification Service** (diagram exists in `LLD-QUESTIONS/LLD/NOTITCATION SERVICE`, not coded — Observer + Factory)
- [ ] **TTL eviction for Cache** (extend existing `03_Design_Cache_System` — `EvictionAlgorithm` interface already supports this, just add `TTLEvictionAlgorithm`)

## P2 — insurance only, build last if everything above is done

- [ ] **Ticket Management System (Jira-flavored, LLD version)**
  - Not corroborated as an actual Atlassian LLD prompt — only shows up as an **HLD** prompt (`hld-ticketing`) in the prep sheet
  - Low probability (~15%) as a standalone LLD round, since Atlassian's LLD round draws from a small recurring neutral-problem pool, not product-mirroring prompts
  - But cheap to build after Feature Flag Library + Meeting Room Booking, since state-transition + permission logic overlaps heavily with both
  - Core scope if built: Ticket entity with status transitions (Open → InProgress → Done), assignment, comments, permission checks on transitions — State + Observer pattern
  - Existing diagram: `LLD-QUESTIONS/LLD/TASK MANAGEMENT JIRA` (diagram only, no code)

## Build order

1. File Storage System extension (smallest lift, reuses ~80% of existing code)
2. Meeting Room Booking
3. Feature Flag Library
4. Notification Service
5. TTL eviction addition to Cache (quick extensibility flex)
6. Snake Game — revision pass
7. Rate Limiter — revision pass
8. Ticket Management System — insurance only, last







┌─────┬────────────────────────────┬──────────────────────────────────────────────────────────────────────────────┐
│  #  │       Missing topic        │                                    Notes                                     │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 2   │ APPLY COUPON               │ no coupon/discount-engine folder                                             │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 12  │ NETFLIX                    │ video streaming — closest is Music_Streaming_Service, but that's audio, not  │
│     │                            │ video                                                                        │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 13  │ NOTITCATION SERVICE        │ no dedicated notification-service folder (Pub_Sub_System exists, different   │
│     │                            │ problem)                                                                     │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 16  │ PAYMENT GATEWAY            │ Digital_Wallet_Service exists but that's wallet balance, not an external     │
│     │                            │ payment gateway                                                              │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 18  │ RATE LIMITER               │ not part of the moved set at all                                             │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 21  │ SNAKE LADDER               │ explicitly skipped earlier (you chose to skip it as a near-duplicate of      │
│     │                            │ Snake_and_Food_Game)                                                         │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 29  │ TINY URL                   │ no URL-shortener folder                                                      │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 32  │ UNDO READO FEATURE         │ undo/redo (Command pattern) — no folder                                      │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 34  │ VISITOR SINGLE DOUBLE      │ Visitor pattern / single-double dispatch — no folder                         │
│     │ DISTPATCH                  │                                                                              │
├─────┼────────────────────────────┼──────────────────────────────────────────────────────────────────────────────┤
│ 35  │ WORD PROCESSOR             │ no folder                                                                    │
└─────┴────────────────────────────┴──────────────────────────────────────────────────────────────────────────────┘
