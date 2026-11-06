# Abstract Class vs Interface

## 1. Core Idea

| | One-liner |
|---|---|
| **Abstract class** | Same family, shared code + some blanks to fill in. |
| **Interface** | Unrelated things that must follow the same contract/capability. |

---

## 2. When to use Abstract Class

**Scenario:** All `Vehicle`s share common code (e.g. `startEngine()` logic is identical), but `move()` differs per vehicle.

```java
abstract class Vehicle {
    void startEngine() { System.out.println("Engine started"); } // shared, same for all
    abstract void move(); // each subclass fills differently
}

class Car extends Vehicle {
    void move() { System.out.println("Car drives on road"); }
}

class Boat extends Vehicle {
    void move() { System.out.println("Boat sails on water"); }
}
```

**Use when:** subclasses are related, share some common implementation, and you only extend ONE class anyway (single inheritance).

---

## 3. When to use Interface

**Scenario:** `Bird` and `Airplane` are completely unrelated classes, but both can "fly." No shared code, just a shared capability/contract.

```java
interface Flyable {
    void fly(); // no body, just a promise
}

class Bird implements Flyable {
    public void fly() { System.out.println("Bird flaps wings"); }
}

class Airplane implements Flyable {
    public void fly() { System.out.println("Airplane uses engines"); }
}
```

**Use when:** unrelated classes need to guarantee the same capability, and a class may need multiple such capabilities (`implements Flyable, Swimmable, Chargeable...`).

---

## 4. Quick Decision Table

| Question | Answer |
|---|---|
| Classes are related (same family) + share some common code? | Abstract class |
| Classes are unrelated but need same capability/behavior contract? | Interface |
| Need multiple inheritance of behavior? | Interface (class can implement many) |
| Need shared state/fields + partial implementation? | Abstract class |

---

## 5. Abstract Methods — The Body Rule

In an abstract class:

- Method **without** a body (no `{}`) → must be marked `abstract`.
  ```java
  abstract void move(); // no body → must say abstract
  ```
- Method **with** a body → normal method, no `abstract` keyword, works fine as shared/concrete code.
  ```java
  void startEngine() { System.out.println("started"); } // has body → not abstract
  ```

**Rule:** body missing → keyword `abstract` required (compiler forces it). Body present → don't write `abstract` (compiler error if you do, since `abstract` means "no implementation").

---

## 6. Is Overriding Mandatory?

Yes, both — with one exception each.

### Interface → implementing class
Mandatory to override all abstract methods (methods without body).
**Exception:** `default` methods (with body) — don't need to override, can use as-is.

```java
interface Flyable {
    void fly();                // must override
    default void land() {...} // optional, has body
}
```

### Abstract class → extending class
Mandatory to override all abstract methods.
**Exception:** if the subclass itself is declared `abstract`, it can skip overriding — the obligation passes down to whichever concrete subclass eventually extends it.

```java
abstract class Vehicle {
    abstract void move();
}

class Car extends Vehicle {
    void move() {...} // mandatory here, since Car is concrete
}
```

**Rule in one line:** any concrete (non-abstract) class — whether implementing an interface or extending an abstract class — must override every abstract method it inherits, or it won't compile.

---

## 7. Why Reference a Parent Type? (`Vehicle v = new Car();`)

That's called **polymorphism** — a choice, not a forced rule. Both work:

```java
Car c1 = new Car();          // concrete type
Vehicle c2 = new Car();      // parent/interface type
```

### Reason 1: Handle many subclasses the same way

**Scenario:** `Car`, `Bike`, `Truck` all extend `Vehicle`. One list, one loop, no caring which exact type.

```java
List<Vehicle> vehicles = new ArrayList<>();
vehicles.add(new Car());
vehicles.add(new Bike());
vehicles.add(new Truck());

for (Vehicle v : vehicles) {
    v.move(); // calls Car's move(), Bike's move(), etc. — correct one runs automatically
}
```

If you'd written `Car c = new Car();` everywhere, you couldn't put a `Car` and `Bike` in the same `List<Vehicle>`, and you couldn't write one generic function that accepts "any vehicle."

### Reason 2: Flexibility to swap implementation

```java
Vehicle v = new Car();
// later, change requirements:
Vehicle v = new Bike();   // only this line changes, rest of code using v.move() stays same
```

---

## 8. Parent-Type Reference — What You Can and Can't Access

```java
Vehicle c2 = new Car();
```

You can only call methods that exist in `Vehicle` (the reference type). Even though the actual object is a `Car`, the compiler only lets you access what `Vehicle` declares.

```java
class Vehicle {
    void move() {...}
}

class Car extends Vehicle {
    void move() {...}
    void openSunroof() {...} // extra method, only in Car
}

Vehicle c2 = new Car();
c2.move();          // ✅ works — Vehicle has move()
c2.openSunroof();   // ❌ compile error — Vehicle doesn't know about openSunroof()
```

**To access the extra method, cast back to `Car`:**

```java
Car realCar = (Car) c2;
realCar.openSunroof(); // ✅ works now
```

**Rule:** reference type (left side) decides what methods you can call at **compile time**. Actual object type (right side) decides which version of an overridden method actually **runs** at **runtime**. Extra methods only on the subclass need a cast to be reachable.
