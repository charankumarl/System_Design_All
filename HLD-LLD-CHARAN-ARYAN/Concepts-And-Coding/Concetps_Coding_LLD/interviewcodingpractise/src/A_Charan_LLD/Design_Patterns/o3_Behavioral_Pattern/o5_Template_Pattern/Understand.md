# Template Method Pattern

## 1. Problem

Several classes follow the **same overall sequence of steps**, but one or two steps differ per class. If each class implements the whole sequence itself, you duplicate the shared steps everywhere, and the order can accidentally differ between classes.

---

## 2. Solution

Base class defines the **fixed skeleton** (the order of steps) in one `final` method. Subclasses only override the **specific steps** that vary. The skeleton itself can never be changed or reordered by a subclass.

---

## 3. Scenario: Making Tea vs Coffee

Both drinks follow the exact same 4 steps: boil water → brew → pour in cup → add condiments. Only **brew** and **add condiments** differ (tea = steep + lemon, coffee = brew grounds + sugar/milk). Everything else is identical.

---

## 4. Code Mapped

```
Beverage (abstract)
  prepareBeverage()  ← TEMPLATE METHOD, final, fixed order of steps
    1. boilWater()       — same for everyone, implemented here
    2. brew()            — ABSTRACT, subclass fills in
    3. pourInCup()        — same for everyone, implemented here
    4. addCondiments()    — ABSTRACT, subclass fills in

  ├── Tea     → brew() = "steeping", addCondiments() = "lemon"
  └── Coffee  → brew() = "brewing coffee", addCondiments() = "sugar and milk"
```

The skeleton — locked with `final` so no subclass can rearrange or skip steps:
```java
public final void prepareBeverage() {
    boilWater();
    brew();          // varies
    pourInCup();
    addCondiments(); // varies
}
```

Subclass only fills the 2 steps that differ:
```java
public class Tea extends Beverage {
    protected void brew() { System.out.println("Steeping tea..."); }
    protected void addCondiments() { System.out.println("Adding lemon..."); }
}
```

---

## 5. Trace Through `Main.java`

```java
Beverage coffee = new Coffee();
coffee.prepareBeverage();
// Boiling water... → Brewing coffee... → Pouring into cup... → Adding sugar and milk...

Beverage tea = new Tea();
tea.prepareBeverage();
// Boiling water... → Steeping tea... → Pouring into cup... → Adding lemon...
```

Same method call, same step order, different output only where the subclass customized it.

---

## 6. Why `final` on `prepareBeverage()` Matters

It's the whole point of the pattern — subclasses are **not allowed** to change the sequence or skip a step, only plug in their version of the variable steps. That's what separates Template Method from just "any abstract class with abstract methods."

---

## 7. Does Every Shared Step Need `final`?

No — only **the template method itself** (the one defining the order) needs `final`.

| Method | Needs `final`? |
|---|---|
| The template method (defines order) — `prepareBeverage()` | **Yes** — this is the critical one |
| Shared/common steps, if `private` — `boilWater()`, `pourInCup()` | No — already un-overridable (subclasses can't even see `private` methods) |
| Shared/common steps, if `protected`/`public` with a default impl you don't want changed | Optional `final`, only if you specifically want to block override |
| Abstract steps (`brew()`, `addCondiments()`) | Never — they must be overridden |

---

## 8. Why This Works: Runtime Polymorphism

```java
Parent p = new Child();
p.show(); // Child's overridden version runs, not Parent's
```

Reference type (`Parent`) only decides **which methods are visible/callable** at compile time. Which version actually **runs** is decided at runtime, based on the **actual object type** (`Child`) — this is called **dynamic method dispatch**.

This is exactly why Template Method works:
```java
Beverage coffee = new Coffee();
coffee.prepareBeverage();
```
Even though `brew()` is called from inside `Beverage`'s `prepareBeverage()`, at runtime it calls **`Coffee`'s** `brew()` — because the actual object is a `Coffee`. That's the mechanism that makes the whole pattern work.
