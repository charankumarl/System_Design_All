# Task Management (Jira-style) — Clarification Questions

Ask these first, before touching the diagram. ~2-3 min.

## Core scope
- Is this single-project task tracking, or multi-project (boards)?
- Who are the actors — just users creating/assigning tasks, or also admins/roles?

## Task lifecycle
- What are the valid statuses? (diagram assumes Todo → InProgress → Done, plus Cancelled)
- Can a task move backward (Done → Todo, i.e. re-open)?
- Any status transition restrictions (e.g. only assignee can mark Done)?

## Task attributes
- Does a task need: due date, priority, tags, comments, subtasks — all of these, or a subset?
- Can a task have multiple assignees, or exactly one?
- Do subtasks affect parent task status (e.g. parent auto-blocks until children done)?

## Search / sort / filter
- What search is needed — by keyword (title/desc), by status, by assignee, or all?
- What sort orders matter — priority, due date, created date?

## Notifications / activity
- Does changing a task need to notify anyone (assignee, watchers)?
- Is an activity log / audit trail required, or just current state?

## Scale (keep brief, don't over-invest here)
- Single server, in-memory is fine for this round — any specific scale number given?
- Concurrent updates to the same task — need thread safety, or out of scope?

## AI prompt — after drawing the class diagram

Once requirements are clarified and the diagram is drawn (your own design,
not AI-generated), use this to get a review, not a rewrite:

```
I'm designing a Task Management (Jira-style) system in Java for an LLD interview.

My classes: Task, TaskList, User, Tag, Comment, ActivityLog,
TaskManagementSys (Singleton).

Patterns I've applied:
- State pattern for Task status (TodoState, InProgressState, DoneState)
- Strategy pattern for sorting (SortByPriority, SortByDueDate)
- Observer pattern for activity logging (ActivityLogger observes Task)
- Builder pattern for Task construction

Requirements: create/assign tasks, track status transitions, comments,
tags, subtasks, search by keyword, sort by priority/due date, activity log.

Review my class design. Please:
- Identify missing classes or responsibilities.
- Identify incorrect relationships.
- Point out any pattern I'm misusing or over-applying.
- Flag anything that looks like a single class doing too much.
- Do not generate the implementation yet.
- Explain the reasoning behind your suggestions.
```

Treat the response as a second opinion to argue with, not an answer to accept.
For each suggestion: does it map to a stated requirement, is it fixing a real
gap vs. adding speculative flexibility, and can you explain it in your own
words? If not, say so out loud and reject it — don't silently accept or
silently ignore what AI returns.
