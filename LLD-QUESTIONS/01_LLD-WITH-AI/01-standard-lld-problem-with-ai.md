# Type 1 — Standard LLD Problem (with AI assistance)

Atlassian SDE-2 Code Design round, format A: a classic LLD prompt (e.g. Parking Lot, Rate Limiter) designed from scratch, with an AI coding assistant available in the IDE.

## Golden rule

> **Never submit code you cannot explain line by line.**

Target: use AI for **30–40% of the work**, but retain ownership of **100% of the design and implementation decisions**.

## How much AI, per activity

| Activity | AI usage | Guidance |
|---|---|---|
| Understanding requirements | Low | Do this yourself |
| Identifying classes and relationships | Medium | Discuss alternatives with AI |
| Writing boilerplate code | High | Good use of AI |
| Core business logic | Medium | Think first, then ask AI |
| Debugging | High | Very useful |
| Design patterns | Medium | Ask AI to review your choice |
| Final explanation | Low | Explain in your own words |

## Workflow (Parking Lot used as the running example)

### Step 1 — Understand requirements yourself

Clarify with the interviewer before touching AI or code:

- Can a parking lot have multiple floors?
- Can different vehicle types occupy different spot types?
- Should we support multiple pricing strategies?
- Should the system auto-assign the nearest available spot?

This shows you can handle ambiguity on your own.

### Step 2 — Ask AI to review *your* design (not generate one)

Don't do this:

> ❌ "Design a complete parking lot system and give me Java code."

Come up with your own classes first — e.g. `ParkingLot`, `ParkingFloor`, `ParkingSpot`, `Vehicle`, `ParkingTicket`, `ParkingManager`, `FeeCalculator` — then ask AI to critique it:

```
I'm designing a Parking Lot System in Java for an LLD interview.

My proposed classes are:
ParkingLot, ParkingFloor, ParkingSpot, Vehicle, ParkingTicket,
ParkingManager, FeeCalculator

Requirements: multiple floors, different vehicle types, different
parking spot types, vehicle entry/exit, ticket generation, fee
calculation.

Review my class design. Please:
- Identify missing classes or responsibilities.
- Identify incorrect relationships.
- Suggest where interfaces or abstract classes are useful.
- Point out unnecessary design patterns.
- Do not generate the implementation yet.
- Explain the reasoning behind your suggestions.
```

Why this works: AI challenges your design, it doesn't replace your thinking.

### Step 3 — Ask AI about a design pattern you're considering

Example — you're thinking Strategy for fee calculation:

```
For my Parking Lot System, I am considering the Strategy Design
Pattern for parking fee calculation.

Explain:
- Why Strategy Pattern is suitable here.
- Whether it is actually necessary for these requirements.
- How the classes should interact.
- Give a small Java example.

Keep the implementation simple and avoid unnecessary abstractions.
```

You must be able to explain *why* you picked the pattern, unprompted.

### Step 4 — Use AI for implementation, one component at a time

```
Generate the Java implementation for ParkingSpot.

Requirements:
- Each spot has an ID.
- Each spot has a SpotType.
- Each spot can hold one vehicle.
- A spot should validate whether a given vehicle can park there.
- Provide parkVehicle() and removeVehicle() methods.

Use clean OOP principles. Avoid streams and lambdas. Do not
introduce unnecessary design patterns. Explain the important
implementation decisions.
```

Don't generate the whole application in one shot — implement one logical component at a time.

### Step 5 — Use AI as a code reviewer

After implementing core logic yourself:

```
Review my ParkingManager implementation. Check for:
- Incorrect object relationships.
- Null pointer possibilities.
- Incorrect parking spot allocation.
- Duplicate vehicle parking.
- Concurrency issues.
- Violations of SOLID principles.

Do not rewrite the complete implementation. Identify issues and
explain how I can fix them.
```

This is one of the highest-value ways to use AI in the interview.

## What NOT to ask AI

| Avoid asking | Ask instead |
|---|---|
| Build the entire feature | Help me identify the required changes |
| Fix everything | Identify the root cause |
| Apply all SOLID principles | Review whether my design needs changes |
| Generate all test cases and code | Suggest missing edge cases |
| Rewrite this entire class | Suggest the smallest safe modification |
| Make this production-ready | Identify specific production risks |

Why it matters: AI can produce unnecessarily complex implementations — you can burn 10 minutes understanding code you never needed.

## What the interviewer is actually evaluating

| Skill | What to demonstrate |
|---|---|
| Problem-solving | Understand the requirement before coding |
| OOP | Appropriate classes, interfaces, responsibilities |
| Design | Maintainable, extensible implementation |
| Testing | Happy paths and edge cases |
| AI usage | Clear prompts, and validating what comes back |
| Communication | Explain what you're doing and why, continuously |

## Suggested 60-minute allocation

| Time | Duration | Focus |
|---|---|---|
| 0–8 min | 8 min | Clarify requirements |
| 8–18 min | 10 min | Design classes/relationships, get AI review |
| 18–38 min | 20 min | Implement main functionality, with AI assistance |
| 38–50 min | 12 min | Tests, debugging, edge cases |
| 50–60 min | 10 min | Refactor, explain decisions, discuss trade-offs |

(Not an official Atlassian timing — a reasonable default to rehearse against.)

## Practice checklist before the interview

- [ ] SOLID principles — able to name violations on sight
- [ ] Strategy, Factory, Observer patterns — know when each actually applies
- [ ] Interface vs abstract class — crisp answer ready
- [ ] Composition vs inheritance
- [ ] Dependency injection
- [ ] Exception handling conventions
- [ ] Collections and basic concurrency (thread safety in shared state)
- [ ] Unit testing and mocking basics

See also: [`02-existing-codebase-with-ai.md`](./02-existing-codebase-with-ai.md) for the other interview format (existing repo, bug-fix/feature-add).
