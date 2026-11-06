package model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private boolean isBorrowed;
    private List<Member> waitlist;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isBorrowed = false;
        this.waitlist = new ArrayList<>();
    }

    public void addToWaitlist(Member member) {
        waitlist.add(member);
    }

    public void removeFromWaitlist(Member member) {
        waitlist.remove(member);
    }

    public List<Member> getWaitlist() {
        return waitlist;
    }

    public void clearWaitlist() {
        waitlist.clear();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
