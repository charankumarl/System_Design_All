# How to Approach an Existing-Codebase Round, Step by Step

Worked walkthrough for [`02-existing-codebase-with-ai.md`](./02-existing-codebase-with-ai.md), using one running example: a **Banking System** repo (`Account`, `Customer`, `Transaction`, `TransactionService`, `AccountRepository`, `InterestCalculator`).

Assumes a 60-minute round with ~10 minutes of intro/setup, leaving **45 effective minutes**. Covers both sub-cases that can come up on the same codebase — **adding a feature** and **fixing a bug** — since they share the first half of the flow and only diverge partway through.

## Time budget (45 min effective)

| Min | Phase |
|---|---|
| 0–5 | Orient: understand repo structure |
| 5–10 | Narrow down: find the exact relevant code |
| 10–30 | Implement (diverges by task type here) |
| 30–40 | Test, run, debug, check regressions |
| 40–45 | Wrap up: explain, trade-offs, what you'd do with more time |

---

## Step 1 (0–2 min): Before you touch AI — read the task out loud

Whatever they hand you (e.g. *"Add a feature: apply monthly interest to savings accounts"* or *"Bug: transferMoney() sometimes allows negative balance under concurrent requests"*), restate it back to the interviewer in your own words and ask one clarifying question if anything's ambiguous. Don't open the AI panel yet — this two-minute pause signals you think before you prompt, which they're explicitly scoring.

## Step 2 (2–7 min): Orient yourself in the repo

Open the AI assistant and ask it to map the territory, not solve anything:

```
Analyze this existing codebase.

Explain:
- Overall project structure.
- Main entry point.
- Important classes and interfaces.
- How the main business flow works (e.g. how a money transfer happens end to end).
- Where a new feature / bug fix like this would likely live: [paste the task].

Do not modify any code yet.
```

Say out loud what comes back, condensed: *"Okay — so `TransactionService.transfer()` is the core flow, it calls `AccountRepository` for balance reads/writes, and `Customer` just holds account references."* This is you narrating comprehension, which matters more than the AI's answer itself.

**Don't** let AI dump a 10-file summary and read all of it. Skim for the 2–3 classes that matter to your specific task and move on.

## Step 3 (7–10 min): Narrow to the exact spot, and read it yourself

Open the specific file(s) AI pointed to — `TransactionService.java`, maybe `Account.java` — and actually read them with your own eyes for a minute before asking anything else. Then, if a class is still unclear:

```
Explain this class and its interactions with other classes.

I want to understand:
- Its responsibility.
- Dependencies.
- Methods and their purpose.
- Existing design patterns.
- Possible problems with the current implementation.
```

By minute 10 you should be able to say one sentence that locates the task precisely: *"The interest feature needs a new method on `InterestCalculator`, triggered from a scheduled job — nothing in `TransactionService` needs to change,"* or *"The bug is in `transferMoney()` — it reads both balances, then writes both, with no lock in between, so two concurrent transfers can both pass the sufficient-funds check."*

This is the branch point. Two paths from here.

---

### Path A — Adding a feature (e.g. monthly interest on savings accounts)

**10–15 min: design the extension point, on paper/verbally first**

Decide: does this need a new class (`InterestCalculator`), a new method on an existing one, or a new interface if multiple interest strategies are plausible (fixed-rate vs tiered)? Say your choice and why, *before* asking AI to generate anything.

**15–18 min: ask AI to validate the plan, not write the code yet**

```
I need to implement the following feature: apply monthly interest
to savings accounts.

First analyze the existing implementation of Account and
TransactionService.

Suggest:
- Which classes need modification.
- Whether a new class or interface is required.
- The simplest design that fits the existing architecture.
- Potential backward compatibility issues (e.g. does this break
  existing transaction history or account balance invariants?).

Do not modify unrelated code.
```

**18–28 min: implement incrementally, one piece at a time**

First ask for just the new class/method skeleton, review it, then fill logic yourself or with a tighter follow-up prompt. Never "generate the whole feature" in one shot — if `InterestCalculator` needs to call `AccountRepository.updateBalance()`, write that wiring yourself so you can defend it.

**28–30 min: sanity-check against existing invariants**

Does this feature respect whatever constraints the codebase already has (e.g. balance can't go negative, transactions must be logged)? Say this check out loud even if the answer is "yes, it does."

---

### Path B — Fixing a bug (e.g. race condition in transferMoney())

**10–13 min: reproduce / confirm the root cause before fixing anything**

If there's a failing test or repro steps, run it first. If not, trace the code path manually: *"Both threads call `getBalance()`, both see sufficient funds, both proceed to `debit()` — there's no synchronization around the check-then-act."*

**13–16 min: ask AI to confirm root cause, not hand you a fix yet**

```
I am getting the following issue: concurrent transfer() calls can
both pass the balance check and overdraw the account.

Analyze the root cause in TransactionService.transfer() and
Account.debit().

Explain:
- Why this happens.
- Which exact lines cause it.
- The smallest possible fix.
- Whether the fix could introduce any regression (e.g. deadlock
  risk if we add locking carelessly).

Don't rewrite the entire codebase.
```

**16–26 min: implement the smallest safe fix yourself**

Typically: synchronize on the account object, or use a lock per account ID, or move to an atomic compare-and-set balance update. Pick one, explain the trade-off (coarse lock = simpler but less concurrent; per-account lock = more complex but scales better), implement it, and don't let AI "also clean up" unrelated code while it's in there.

**26–30 min: check you didn't break anything else that depends on this method**

Grep/ask for other callers of `transfer()` or `debit()` to make sure your fix (e.g. a new lock) doesn't change behavior they rely on.

---

## Step 4 (30–40 min): Test, run, debug — same for both paths

```
Review the implementation and suggest test cases.

Include:
- Happy path.
- Invalid inputs.
- Boundary conditions (e.g. exact balance match, zero balance).
- Concurrent requests (for the bug-fix case specifically).

Generate tests using the existing testing framework and conventions.
```

Actually **run** the test suite, not just read the generated tests — Atlassian's own guide flags "working code" as the bar, not pseudocode. If something existing broke, that's a real regression — fix it before moving on, and say explicitly that you checked for regressions.

## Step 5 (40–45 min): Explain your change, unprompted

Close by stating, without being asked: what you changed, why you chose this approach over alternatives (e.g. *"I used per-account locking instead of a global lock because..."*), and one honest limitation (*"with more time I'd also add an audit log entry for failed transfer attempts"*). This closing summary is one of the highest-leverage 2 minutes of the round — it's where "communication" gets scored.

---

## The one meta-rule across all of this

At every single AI call above, the pattern is the same: **you decide the direction first (even just a sentence), AI validates/assists, you implement the risky/core part yourself, you read everything before it goes in.** The moment you ask AI an open-ended "build/fix this for me" prompt, you've handed over the exact thing they're evaluating.
