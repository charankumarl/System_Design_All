package model;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }
}
