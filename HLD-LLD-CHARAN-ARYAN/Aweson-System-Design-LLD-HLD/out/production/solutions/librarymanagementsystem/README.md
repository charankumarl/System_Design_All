# Library Management System (LLD)

## Problem Statement

Design and implement a Library Management System that allows members to borrow and return books, manages book inventory, tracks loans, and supports catalog search.

---

## Requirements

- **mdel.Book Management:** The system manages a catalog of books, each with multiple copies.
- **mdel.Member Management:** The system manages library members who can borrow and return books.
- **Loan Management:** The system tracks which member has borrowed which book copy and when.
- **Borrowing and Returning:** Members can borrow available book copies and return them.
- **Catalog Search:** Members can search for books by title, author, or ISBN.
- **Extensibility:** Easy to add new features such as reservations, fines, or notifications.

---

## Core Entities

- **LibraryManagementSystem:** Main class that manages books, members, loans, and the catalog.
- **mdel.Book:** Represents a book with title, author, ISBN, and other metadata.
- **BookCopy:** Represents a physical copy of a book, with a unique copy ID and availability status.
- **mdel.Member:** Represents a library member with a unique ID and name.
- **Loan:** Represents a loan record for a book copy borrowed by a member.
- **Catalog:** Manages the collection of books and supports search functionality.

---

## Class Design

## UML Class Diagram

![](../../../../uml-diagrams/class-diagrams/LibraryManagementSystem-class-diagram.png)

### 1. LibraryManagementSystem
- **Fields:** List<mdel.Book> books, List<mdel.Member> members, List<Loan> loans, Catalog catalog
- **Methods:** addBook(mdel.Book), addMember(mdel.Member), borrowBook(mdel.Member, mdel.Book), returnBook(mdel.Member, BookCopy), getLoans(mdel.Member), searchBooks(String query), etc.

### 2. mdel.Book
- **Fields:** String title, String author, String isbn, List<BookCopy> copies

### 3. BookCopy
- **Fields:** int copyId, mdel.Book book, boolean isAvailable

### 4. mdel.Member
- **Fields:** int id, String name, List<Loan> loans

### 5. Loan
- **Fields:** int id, mdel.Member member, BookCopy bookCopy, Date loanDate, Date returnDate

### 6. Catalog
- **Fields:** List<mdel.Book> books
- **Methods:** searchByTitle(String), searchByAuthor(String), searchByISBN(String)

---

## Example Usage

```java
LibraryManagementSystem system = new LibraryManagementSystem();
mdel.Book book = new mdel.Book("Effective Java", "Joshua Bloch", "978-0134685991");
system.addBook(book);

mdel.Member alice = new mdel.Member(1, "Alice");
system.addMember(alice);

system.borrowBook(alice, book);
system.returnBook(alice, book.getCopies().get(0));
```

---

## Demo

See `LibraryManagementSystemDemo.java` for a sample usage and simulation of the library management system.

---

## Extending the Framework

- **Add reservations:** Allow members to reserve books that are currently checked out.
- **Add fines:** Track overdue books and calculate fines.
- **Add notifications:** Notify members about due dates, reservations, or new arrivals.

---