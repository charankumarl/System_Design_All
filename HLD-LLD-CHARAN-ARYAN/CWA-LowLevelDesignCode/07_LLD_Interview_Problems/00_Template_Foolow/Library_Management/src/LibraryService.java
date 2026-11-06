import fine.FineStrategyType;
import model.Book;
import model.Member;
import service.BookService;
import service.LoanService;
import service.MemberService;
import service.NotificationService;

public class LibraryService {

    private BookService bookService;
    private MemberService memberService;
    private LoanService loanService;

    public LibraryService(NotificationService notificationService) {
        this.bookService = new BookService();
        this.memberService = new MemberService();
        this.loanService = new LoanService(bookService, memberService, notificationService);
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public void addMember(Member member) {
        memberService.registerMember(member);
    }

    public void borrowBook(String isbn, String memberId) {
        loanService.issueBook(isbn, memberId);
    }

    public double returnBook(String isbn, String memberId, FineStrategyType strategyType) {
        return loanService.returnBook(isbn, memberId, strategyType);
    }
}
