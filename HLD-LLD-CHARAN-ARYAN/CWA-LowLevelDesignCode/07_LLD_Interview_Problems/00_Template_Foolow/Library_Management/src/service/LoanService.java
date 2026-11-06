package service;

import fine.FineStrategy;
import fine.FineStrategyFactory;
import fine.FineStrategyType;
import model.Book;
import model.Loan;
import model.Member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private static final int ALLOWED_DAYS = 14;

    private BookService bookService;
    private MemberService memberService;
    private NotificationService notificationService;
    private List<Loan> activeLoans;

    public LoanService(BookService bookService, MemberService memberService, NotificationService notificationService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.notificationService = notificationService;
        this.activeLoans = new ArrayList<>();
    }

    public void issueBook(String isbn, String memberId) {
        Book book = bookService.findBook(isbn);
        Member member = memberService.findMember(memberId);
        if (book == null || member == null) {
            return;
        }

        if (book.isBorrowed()) {
            book.addToWaitlist(member);
            return;
        }

        book.setBorrowed(true);
        activeLoans.add(new Loan(book, member, LocalDate.now()));
        notificationService.send(member, "Book borrowed: " + book.getTitle());
    }

    public double returnBook(String isbn, String memberId, FineStrategyType strategyType) {
        Book book = bookService.findBook(isbn);
        Member member = memberService.findMember(memberId);
        if (book == null || member == null) {
            return 0;
        }

        Loan loan = findActiveLoan(book, member);
        book.setBorrowed(false);
        notificationService.send(member, "Book returned: " + book.getTitle());
        notificationService.send(book, "Book now available: " + book.getTitle());

        if (loan == null) {
            return 0;
        }
        activeLoans.remove(loan);

        int daysLate = calculateDaysLate(loan.getBorrowedDate());
        return calculateFine(strategyType, daysLate);
    }

    private Loan findActiveLoan(Book book, Member member) {
        for (Loan loan : activeLoans) {
            if (loan.getBook() == book && loan.getMember() == member) {
                return loan;
            }
        }
        return null;
    }

    private int calculateDaysLate(LocalDate borrowedDate) {
        long daysBorrowed = ChronoUnit.DAYS.between(borrowedDate, LocalDate.now());
        return (int) Math.max(0, daysBorrowed - ALLOWED_DAYS);
    }

    private double calculateFine(FineStrategyType strategyType, int daysLate) {
        FineStrategy fineStrategy = FineStrategyFactory.getStrategy(strategyType);
        return fineStrategy.calculateFine(daysLate);
    }
}
