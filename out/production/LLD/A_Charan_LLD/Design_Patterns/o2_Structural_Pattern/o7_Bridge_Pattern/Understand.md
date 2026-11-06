# Bridge Pattern

## 1. Problem

You have **two things that both vary independently** — e.g. shapes (Circle, Square, Triangle) AND colors (Red, Blue, Green). Handling this with plain inheritance causes a **class explosion**:

```
RedCircle, BlueCircle, GreenCircle,
RedSquare, BlueSquare, GreenSquare,
RedTriangle, BlueTriangle, GreenTriangle...
```

3 shapes × 3 colors = 9 classes. Add one more color → +3 more classes. Add one more shape → +3 more classes. Grows out of control.

---

## 2. Solution

Split the two dimensions into **two separate hierarchies**, and connect them with a **reference** (the "bridge") instead of inheritance.

```
Shape (has-a Color)        Color
├── Circle                 ├── RedColor
├── Square                 ├── BlueColor
└── Triangle                └── GreenColor
```

Now: 3 shape classes + 3 color classes = 6 total (not 9), and any shape can combine with any color at runtime — no new class needed for each combination.

---

## 3. Scenario

You're building a drawing app. Shapes: `Circle`, `Square`. Colors: `Red`, `Blue`. You want any shape in any color, without writing `RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare` as 4 separate classes.

```java
interface Color {
    void applyColor();
}

class RedColor implements Color {
    public void applyColor() { System.out.println("Color: Red"); }
}

class BlueColor implements Color {
    public void applyColor() { System.out.println("Color: Blue"); }
}

abstract class Shape {
    Color color; // <-- the "bridge" — a reference, not inheritance

    Shape(Color color) { this.color = color; }
    abstract void draw();
}

class Circle extends Shape {
    Circle(Color color) { super(color); }
    void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

class Square extends Shape {
    Square(Color color) { super(color); }
    void draw() {
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}
```

```java
Shape redCircle = new Circle(new RedColor());
redCircle.draw(); // Drawing Circle with Color: Red

Shape blueSquare = new Square(new BlueColor());
blueSquare.draw(); // Drawing Square with Color: Blue
```

Mix and match any shape with any color — no new class for each pairing.

---

## 4. About the Existing Code in This Folder

The `Shape` / `Color` / `Circcle` / `RedColor` / `BlueColor` classes here are **exactly this pattern, correctly done** — not complex at all. It's the textbook minimal example:

- `Shape` **has-a** `Color` (the bridge/reference).
- `Shape` hierarchy (`Circle`, `Triangle`) varies **independently** from `Color` hierarchy (`Red`, `Blue`).
- `Main.java`: `new Circcle(new RedColor())` — combining them at runtime.

If something felt complex, it's likely just the abstract-class + interface + constructor-injection combo looking unfamiliar, not the logic itself. The code here is a good reference example — no changes needed.

---

## 5. One-Line Takeaway

Bridge = separate "what it is" (`Shape`) from "how it behaves/looks" (`Color`) into two independent hierarchies, connected by a reference field instead of inheritance — avoids class explosion when two things vary independently.
