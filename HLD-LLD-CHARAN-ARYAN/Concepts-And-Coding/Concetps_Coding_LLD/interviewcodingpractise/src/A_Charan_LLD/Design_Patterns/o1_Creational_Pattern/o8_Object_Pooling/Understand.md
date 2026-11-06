# Object Pool Pattern

## 1. Problem

Creating certain objects is **expensive** (DB connections, threads, network sockets), and you need many of them repeatedly. Creating a new one every time, then throwing it away, wastes time and resources.

---

## 2. Solution

Create a **fixed set of reusable objects upfront** (the "pool"). When someone needs one, **borrow** it from the pool instead of creating new. When done, **return it** to the pool instead of destroying it. Next borrower reuses the same object.

---

## 3. Scenario: Database Connection Pool

Opening a DB connection takes time (TCP handshake, auth, etc.). If every request to your server opened a brand-new connection and closed it after, your app would be painfully slow. Instead: keep a few connections open in a pool. Each request **borrows** one, uses it, **returns** it. Next request reuses it — no new connection created.

---

## 4. Code Mapped

```
DBConnection      — the expensive, reusable object
ConnectionPool    — creates a fixed set upfront, hands out via borrow/return
  ├── available   — list of connections free to use
  └── inUse       — list of connections currently borrowed
```

**Pool creates everything once, upfront:**
```java
ConnectionPool(int size) {
    for (int i = 1; i <= size; i++) {
        available.add(new DBConnection("Conn-" + i)); // created ONCE, upfront
    }
}
```

**Borrow — move from `available` to `inUse`:**
```java
DBConnection getConnection() {
    if (available.isEmpty()) {
        throw new RuntimeException("No connections available");
    }
    DBConnection conn = available.removeLast();
    inUse.add(conn);
    return conn;
}
```

**Return — move back from `inUse` to `available`, ready for reuse:**
```java
void releaseConnection(DBConnection conn) {
    inUse.remove(conn);
    available.add(conn); // back to pool, ready for reuse
}
```

---

## 5. Trace Through `Main.java`

```java
ConnectionPool pool = new ConnectionPool(2); // only 2 connections ever created

DBConnection c1 = pool.getConnection();
c1.connect(); // Conn-2 connected...

DBConnection c2 = pool.getConnection();
c2.connect(); // Conn-1 connected...

pool.releaseConnection(c1); // Conn-2 back in pool

DBConnection c3 = pool.getConnection(); // reuses Conn-2, no new object created
c3.connect();
```

Only 2 `DBConnection` objects exist for the whole program — `c3` reuses the same object `c1` had, instead of a 3rd one being created.

---

## 6. Why It's a Creational Pattern

It controls **how objects get created and handed out** — just like Factory/Builder — but the twist is: objects are created **once, in bulk, upfront**, and handed out via borrow/return instead of `new` every time.

---

## 7. One-Line Takeaway

Object Pool = pre-create a fixed set of expensive, reusable objects; clients borrow and return them instead of creating/destroying repeatedly — classic use: DB connection pools, thread pools.



## 8. Object Pool vs Flyweight

They both "avoid creating too many objects," but solve different problems.

| | Object Pool | Flyweight |
|---|---|---|
| **Goal** | Avoid the cost of creating/destroying an expensive object repeatedly | Avoid memory bloat from having too many similar objects at once |
| **Sharing** | One object used by one borrower at a time (exclusive) | One object shared by many users simultaneously |
| **State** | Object is mutable, fully reused as-is | Object splits into intrinsic (shared, same for all) + extrinsic (unique per use, passed in from outside) |
| **Lifecycle** | Borrow → use → return to pool | Never "returned" — just reused as a shared reference forever |
| **Classic example** | DB connection pool, thread pool | Character glyphs in a text editor, tree/bullet icons in a game |

### Why Object Pool doesn't fit "many simultaneous users"

In `ConnectionPool`, only **one person uses `Conn-1` at a time**. If 2 people need a connection, you need **2 separate connection objects** — pooling just avoids recreating them from scratch each time.

### Why Flyweight is about massive quantities, not reuse-over-time

**Scenario:** A game renders 1 million trees. Each tree needs `type, color, texture` (same for every "Oak Tree") + `x, y` position (different per tree). If each tree object stores all of this, `type/color/texture` gets duplicated a million times → huge memory waste.

**Flyweight fix:** store `type/color/texture` (**intrinsic**, shared) in **one** shared object. Store `x, y` (**extrinsic**, unique) separately, passed in when drawing.

```java
class TreeType { // the "flyweight" — shared, heavy data
    String name, color, texture;
}

class TreeFactory {
    static Map<String, TreeType> cache = new HashMap<>();
    static TreeType getTreeType(String name) {
        return cache.computeIfAbsent(name, k -> new TreeType(k, "green", "oak.png"));
    }
}

class Tree {
    int x, y;       // extrinsic — unique per tree
    TreeType type;  // intrinsic — shared reference, not duplicated

    Tree(int x, int y, TreeType type) {
        this.x = x; this.y = y; this.type = type;
    }
}
```

1 million `Tree` objects, but only **1** `TreeType` object in memory (if all oak trees) — all 1 million share the **same reference**.

### One-line takeaway

Object Pool = reuse one object **over time**, one borrower at a time (saves creation cost). Flyweight = share one object **across many simultaneous users** by splitting shared data from per-instance data (saves memory for huge counts of similar objects).
