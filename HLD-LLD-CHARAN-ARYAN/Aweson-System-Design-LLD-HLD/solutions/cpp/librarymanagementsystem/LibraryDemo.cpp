#include "LibraryManager.hpp"
#include <iostream>

int main() {
    LibraryManager library;
    
    // Add books
    mdel.Book* book1 = new mdel.Book("B001", "The Great Gatsby", "F. Scott Fitzgerald",
                          "Scribner", "978-0743273565", 1925);
    mdel.Book* book2 = new mdel.Book("B002", "To Kill a Mockingbird", "Harper Lee",
                          "HarperCollins", "978-0446310789", 1960);
    
    library.addBook(book1);
    library.addBook(book2);
    
    // Add members
    mdel.Member* member1 = new mdel.Member("M001", "John Doe", "john@example.com",
                               "+1-555-0123");
    library.addMember(member1);
    
    // Display available books
    library.displayAvailableBooks();
    
    // Borrow a book
    if (library.borrowBook("M001", "B001", "2024-01-01", "2024-01-15")) {
        std::cout << "\nBook borrowed successfully!" << std::endl;
    }
    
    // Display member's books
    library.displayMemberBooks("M001");
    
    // Return the book
    if (library.returnBook("M001", "B001", "2024-01-10")) {
        std::cout << "\nBook returned successfully!" << std::endl;
    }
    
    // Display transaction history
    library.displayTransactionHistory();
    
    return 0;
} 