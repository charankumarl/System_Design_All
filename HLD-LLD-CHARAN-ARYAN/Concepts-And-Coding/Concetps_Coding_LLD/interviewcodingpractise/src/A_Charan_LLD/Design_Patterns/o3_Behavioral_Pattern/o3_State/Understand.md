# State Pattern

## 1. Problem

An object's behavior changes depending on its **current state**, and without this pattern you end up with messy `if/else` or `switch` blocks everywhere checking "what state am I in?" before deciding what to do.

```java
// WITHOUT state pattern — the bad way
void insertCoin() {
    if (state == IDLE) {
        System.out.println("Coin inserted");
        state = WORKING;
    } else if (state == WORKING) {
        System.out.println("Please wait");
    }
}

void dispenseItem() {
    if (state == IDLE) {
        System.out.println("Please insert coin");
    } else if (state == WORKING) {
        System.out.println("Dispensed");
        state = IDLE;
    }
}
```

Every method needs to check every state. Add a new state → edit every method. Messy, error-prone.

---

## 2. Solution

Make **each state its own class**. Each class knows how to behave for *that* state, and knows which state comes next. The main object just **delegates** to whatever its "current state object" is.

---

## 3. Scenario: Vending Machine

A vending machine behaves differently depending on whether it's **idle** (waiting for a coin) or **working** (already processing one).

```
Vending_State (interface)        — the contract: insertCoin(), dispenceItem()
  ├── Idle_State                 — behavior while idle
  └── Working_State               — behavior while working

Vending_Machine                   — holds "current state" reference, delegates to it
```

---

## 4. Code Walkthrough

`Vending_Machine` doesn't contain any state-checking logic itself — it just delegates:

```java
public void insertCoin() {
    vendingState.insertCoin(this);  // just delegates to whatever state it's currently in
}
```

`Idle_State` — on coin insert, do the "idle" behavior AND switch to `Working_State`:

```java
public void insertCoin(Vending_Machine product){
    System.out.println("Coin inserted");
    product.setVendingState(new Working_State()); // transition
}
```

`Working_State` — on dispense, do the "working" behavior AND switch back to `Idle_State`:

```java
public void dispenceItem(Vending_Machine product){
    System.out.println("product is dispensed. Thanks");
    product.setVendingState(new Idle_State()); // transition back
}
```

---

## 5. Trace Through `Main.java`

```java
vendingMachine.insertCoin();    // state = Idle    → prints "Coin inserted" → state becomes Working
vendingMachine.dispenseItem();  // state = Working  → prints "dispensed"    → state becomes Idle

vendingMachine1.dispenseItem(); // state = Idle (never got a coin) → prints "Please insert coin"
```

Same method call (`dispenseItem()`), but different output depending on current state — without a single `if/else` in `Vending_Machine`.

---

## 6. One-Line Takeaway

State pattern = give each state its own class implementing a common interface; the main object just holds a reference to "current state" and delegates every call to it. Adding a new state later = add one new class, don't touch existing ones.
