# Type 2 — Existing Codebase: Bug Fix / Add Feature (with AI assistance)

Atlassian SDE-2 Code Design round, format B — per Atlassian's own Backend Engineer interview guide:

- You work inside a HackerRank IDE.
- AI coding assistants are provided.
- You get access to an **existing code repository**.
- You may be asked to **add features**, **fix bugs**, or **refactor existing code**.
- You aren't expected to already be an expert in the repo's language — you can ask AI to explain syntax and patterns.
- You share your screen with the interviewer.

This is a meaningfully different skill from greenfield LLD: the core task is **navigating and safely modifying code you didn't write**, not designing from a blank page.

## Golden rule

> **Never submit code you cannot explain line by line.** Same rule as Type 1 — it doesn't relax just because AI wrote more of this one.

## Workflow

Example scenario: interviewer hands you an e-commerce repo and says *"implement a discount feature for customers."*

1. **Explore the existing codebase** — ask AI to explain project structure, key classes, execution flow.
2. **Understand the existing implementation** — find where orders, customers, and pricing are currently handled.
3. **Identify the change required** — decide where the discount feature fits without breaking existing behavior.
4. **Discuss the implementation with AI** — ask for possible approaches and their trade-offs.
5. **Implement incrementally** — small changes, review each one before moving on.
6. **Run tests and debug** — normal cases, edge cases, and existing functionality (regression check).
7. **Explain your solution** — changed classes, design decisions, limitations.

## Practical prompts to rehearse

### A. Understanding an unfamiliar codebase

```
Analyze this existing codebase.

Explain:
- Overall project structure.
- Main entry point.
- Important classes and interfaces.
- How the main business flow works.
- Where a new feature should be implemented.

Do not modify any code yet.
```

### B. Understanding one existing class

```
Explain this class and its interactions with other classes.

I want to understand:
- Its responsibility.
- Dependencies.
- Methods and their purpose.
- Existing design patterns.
- Possible problems with the current implementation.

Explain it in simple terms.
```

### C. Implementing a new feature

```
I need to implement the following feature: [describe feature].

First analyze the existing implementation.

Suggest:
- Which classes need modification.
- Whether a new class or interface is required.
- The simplest design that fits the existing architecture.
- Potential backward compatibility issues.

Do not modify unrelated code.
```

### D. Debugging

```
I am getting the following error: [paste error].

Analyze the root cause.

Explain:
- Why this error occurs.
- Which part of the code causes it.
- The smallest possible fix.
- Whether the fix can introduce any regression.

Don't rewrite the entire codebase.
```

### E. Testing

```
Review the implementation and suggest test cases.

Include:
- Happy path.
- Invalid inputs.
- Boundary conditions.
- Null and empty values.
- Duplicate requests.
- Concurrent requests, if relevant.

Generate tests using the existing testing framework and conventions.
```

## What NOT to ask AI

| Avoid asking | Ask instead |
|---|---|
| Build the entire feature | Help me identify the required changes |
| Fix everything | Identify the root cause |
| Generate all test cases and code | Suggest missing edge cases |
| Rewrite this entire class | Suggest the smallest safe modification |
| Make this production-ready | Identify specific production risks |

Same failure mode as Type 1, amplified: an unfamiliar codebase makes it easy to let AI rewrite more than it should, and then you can't defend code you never actually read.

## What the interviewer is actually evaluating

Per Atlassian's own guide: problem-solving, testing, communication, code quality, and adaptability — plus explicitly rewarding candidates who explain alternative solutions and trade-offs.

| Skill | What to demonstrate |
|---|---|
| Problem-solving | Understand the requirement before coding |
| Code navigation | Understand an existing repository quickly |
| OOP | Appropriate classes, interfaces, responsibilities |
| Design | Maintainable, extensible change — not a rewrite |
| Testing | Happy paths and edge cases, including regressions |
| Debugging | Identify root causes independently |
| AI usage | Clear prompts, and validating what comes back |
| Communication | Explain what you're doing and why, continuously |

## Suggested 60-minute allocation

| Time | Duration | Focus |
|---|---|---|
| 0–8 min | 8 min | Understand requirements + explore the codebase |
| 8–18 min | 10 min | Identify existing flow, design your change |
| 18–38 min | 20 min | Implement the main functionality, with AI assistance |
| 38–50 min | 12 min | Run tests, debug, handle edge cases |
| 50–60 min | 10 min | Refactor, explain decisions, discuss trade-offs |

Don't spend 15 minutes having AI explain every file — explore only what's relevant to the task.

## Practice checklist before the interview

- [ ] Drop yourself into an unfamiliar GitHub project and trace its execution flow using AI
- [ ] Add a new feature to an existing project
- [ ] Find and fix a planted bug with AI assistance
- [ ] Refactor an existing implementation without changing behavior
- [ ] Write unit tests and identify missing edge cases on code you didn't write

See also:
- [`01-standard-lld-problem-with-ai.md`](./01-standard-lld-problem-with-ai.md) for the other interview format (greenfield LLD design).
- [`o2a_How_To_Approach_and_Use_AI.md`](./o2a_How_To_Approach_and_Use_AI.md) for a full worked, minute-by-minute walkthrough of this round using a Banking System example (both feature-add and bug-fix paths).
