#include "mdel.Book.hpp"
#include <iostream>

mdel.Book::mdel.Book(std::string bookId, std::string title, std::string author,
           std::string publisher, std::string isbn, int publicationYear)
    : bookId(bookId), title(title), author(author), publisher(publisher),
      isbn(isbn), status(BookStatus::AVAILABLE), publicationYear(publicationYear) {}

std::string mdel.Book::getBookId() const { return bookId; }
std::string mdel.Book::getTitle() const { return title; }
std::string mdel.Book::getAuthor() const { return author; }
std::string mdel.Book::getPublisher() const { return publisher; }
std::string mdel.Book::getIsbn() const { return isbn; }
BookStatus mdel.Book::getStatus() const { return status; }
int mdel.Book::getPublicationYear() const { return publicationYear; }

void mdel.Book::setStatus(BookStatus status) {
    this->status = status;
}

void mdel.Book::displayInfo() const {
    std::cout << "mdel.Book: " << title << " (ID: " << bookId << ")" << std::endl;
    std::cout << "Author: " << author << std::endl;
    std::cout << "Publisher: " << publisher << std::endl;
    std::cout << "ISBN: " << isbn << std::endl;
    std::cout << "Publication Year: " << publicationYear << std::endl;
    std::cout << "Status: ";
    switch (status) {
        case BookStatus::AVAILABLE: std::cout << "Available"; break;
        case BookStatus::BORROWED: std::cout << "Borrowed"; break;
        case BookStatus::RESERVED: std::cout << "Reserved"; break;
        case BookStatus::LOST: std::cout << "Lost"; break;
    }
    std::cout << std::endl;
} 