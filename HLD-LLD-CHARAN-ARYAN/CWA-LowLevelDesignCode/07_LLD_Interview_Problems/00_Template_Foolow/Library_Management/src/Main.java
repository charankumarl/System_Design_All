import fine.FineStrategyType;
import notification.concrete.EmailNotificationObserver;
import notification.concrete.SmsNotificationObserver;
import model.Book;
import model.Member;
import service.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        LibraryService library = new LibraryService(notificationService);

        Member alice = new Member("M1", "Alice");
        alice.addChannel(new EmailNotificationObserver());

        Member bob = new Member("M2", "Bob");
        bob.addChannel(new SmsNotificationObserver());
        bob.addChannel(new EmailNotificationObserver());

        library.addMember(alice);
        library.addMember(bob);

        Book book = new Book("ISBN-001", "Clean Code");
        library.addBook(book);

        // Alice borrows first — only Alice gets a self-confirm
        library.borrowBook("ISBN-001", "M1");
        System.out.println("Borrowed by Alice: " + book.isBorrowed());

        // Bob tries to borrow the same book — it's taken, so he joins the waitlist instead
        library.borrowBook("ISBN-001", "M2");

        // Alice returns it same day — daysLate is now computed internally from the
        // Loan's borrowedDate, so a same-day return correctly shows 0 fine.
        // Bob (on the waitlist) still gets notified the book is available again.
        double fine = library.returnBook("ISBN-001", "M1", FineStrategyType.FLAT_RATE);
        System.out.println("Returned. Fine = " + fine);
    }
}
