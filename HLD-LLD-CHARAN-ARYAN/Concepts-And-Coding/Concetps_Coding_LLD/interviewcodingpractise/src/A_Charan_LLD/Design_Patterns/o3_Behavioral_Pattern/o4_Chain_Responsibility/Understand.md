# Chain of Responsibility Pattern

## 1. Problem

A request needs to be handled by one of several possible handlers, but the sender shouldn't need to know **which one** — and you don't want one giant `if/else`/`switch` deciding it.

---

## 2. Solution

Line up handlers in a **chain**. Each handler either:
- (a) handles the request, or
- (b) passes it to the **next** handler in line.

Sender just hands the request to the **first** handler and forgets about it.

---

## 3. Scenario: Request Approval

Think of a leave-approval system: `TeamLead` → `Manager` → `Director`.
- A 2-day leave is approved by `TeamLead`.
- A 10-day leave gets passed up to `Manager`.
- A 30-day leave gets passed all the way to `Director`.

Each handler only cares about "can I handle this? If not, pass it on."

Your code does exactly this, but for **log levels** instead of leave-days.

---

## 4. Code Mapped

```
LogProcess (abstract)   — base: holds "next" handler, default behavior = pass to next
  ├── Info_Log            — handles INFO, else passes on
  ├── Warning_Log         — handles WARNING, else passes on
  └── Error_Log           — handles ERROR, else passes on (end of chain, next = null)
```

The chain is built in `Main.java`:
```java
LogProcess log = new Info_Log(new Warning_Log(new Error_Log(null)));
```
```
Info_Log → Warning_Log → Error_Log → null
```

Each handler's logic follows the same shape:
```java
public void logMessage(String message, int level) {
    if (level == INFO) {
        System.out.println("Info Log: " + message); // handle it here
    } else {
        super.logMessage(message, level); // not mine — pass to next in chain
    }
}
```

---

## 5. Trace Through `Main.java`

```java
log.logMessage("this is message", LogProcess.INFO);
```
→ hits `Info_Log` → level matches `INFO` → handled right there. Chain stops.

```java
log.logMessage("this is warning message", LogProcess.WARNING);
```
→ hits `Info_Log` → doesn't match → passes to `Warning_Log` → matches → handled.

```java
log.logMessage("this is error message", LogProcess.ERROR);
```
→ `Info_Log` → no match → `Warning_Log` → no match → `Error_Log` → match → handled.

Caller (`Main`) never decided which log handler runs — just called `log.logMessage(...)` once on the front of the chain, and the right one activated.

---

## 6. One-Line Takeaway

Chain of Responsibility = link handlers in a sequence; each either handles the request or forwards it to the next, so the sender just fires one call at the head of the chain without knowing or caring which handler actually processes it.
