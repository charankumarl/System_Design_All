# Command Pattern

## 1. Problem

A "trigger" (button, remote, menu item) needs to perform an action on some object, but you don't want the trigger to know the details of **how** that action works, or have to change every time a new action is added.

**Without Command pattern** (`Without_Command/Main.java`):
```java
AC ac = new AC();
ac.plugIn();
ac.pressStart();
ac.trunOn();
```
Client (`Main`) must know **all 3 steps** of the AC's internal API, in the right order. Add a new feature (Fan speed, Timer) → client code must change too, and client needs to know the new method names. Tightly coupled.

---

## 2. Solution

Wrap "an action" as its **own object** with one standard method, usually `execute()`. The trigger just calls `execute()` — doesn't know or care what's inside.

---

## 3. Scenario: TV/AC Remote

A remote control button shouldn't need to know "turning on the AC means plug in → press start → turn on." It should just say: "press button → run whatever command is assigned to it."

---

## 4. Code Mapped

```
Command (interface)       — contract: execute()
  ├── AC_TURN_ON             — wraps: plugIn() + pressStart() + trunOn()
  └── AC_TURN_OFF             — wraps: pressStop() + turnOff()

AC (receiver)              — the real object that does the actual work
Command_Control (invoker)  — holds a Command, just calls execute() when button pressed
```

**The command encapsulates the steps:**
```java
public class AC_TURN_ON implements Command {
    private AC ac;
    public AC_TURN_ON(AC ac) { this.ac = ac; }

    public void execute() {
        ac.plugIn();
        ac.pressStart();
        ac.trunOn();
    }
}
```

**The invoker doesn't know any AC details at all:**
```java
public class Command_Control {
    Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); } // just this — no AC knowledge needed
}
```

**Client** (`With_Command/Main.java`):
```java
Command_Control turnOn = new Command_Control();
turnOn.setCommand(new AC_TURN_ON(ac));
turnOn.pressButton(); // "press button" — doesn't know it's 3 steps internally
```

---

## 5. The 3 Roles, In Plain Terms

| Role | Who | Job |
|---|---|---|
| **Command** | `AC_TURN_ON`, `AC_TURN_OFF` | Knows *what* to do and *how* (wraps the steps) |
| **Receiver** | `AC` | The real object the work happens on |
| **Invoker** | `Command_Control` | Just triggers `execute()` — doesn't know *how* |

---

## 6. Why This Matters (The Payoff)

Add a new feature — e.g. `AC_SET_TEMPERATURE` — just write **one new Command class**. `Command_Control` (the remote) and `Main` (the client) **never change**. That's exactly the problem the `Without_Command/Main.java` comment calls out: "client should not know all this method, just pass command as TURN ON."

---

## 7. Bonus: Undo/Redo

Since each command object is self-contained, you can also give it an `undo()` method and keep a history stack of executed commands — that's what the `UNDO_REDO` folder demonstrates.
