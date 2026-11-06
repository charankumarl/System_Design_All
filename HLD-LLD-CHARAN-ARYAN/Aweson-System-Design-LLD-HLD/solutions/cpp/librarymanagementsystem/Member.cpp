#include "mdel.Member.hpp"
#include <iostream>
#include <algorithm>

mdel.Member::mdel.Member(std::string memberId, std::string name, std::string email, std::string phone)
    : memberId(memberId), name(name), email(email), phone(phone), active(true) {}

std::string mdel.Member::getMemberId() const { return memberId; }
std::string mdel.Member::getName() const { return name; }
std::string mdel.Member::getEmail() const { return email; }
std::string mdel.Member::getPhone() const { return phone; }
bool mdel.Member::isActive() const { return active; }
const std::vector<mdel.Book*>& mdel.Member::getBorrowedBooks() const { return borrowedBooks; }

void mdel.Member::addBorrowedBook(mdel.Book* book) {
    borrowedBooks.push_back(book);
}

void mdel.Member::removeBorrowedBook(mdel.Book* book) {
    auto it = std::find(borrowedBooks.begin(), borrowedBooks.end(), book);
    if (it != borrowedBooks.end()) {
        borrowedBooks.erase(it);
    }
}

void mdel.Member::setActive(bool status) {
    active = status;
}

void mdel.Member::displayInfo() const {
    std::cout << "mdel.Member: " << name << " (ID: " << memberId << ")" << std::endl;
    std::cout << "Email: " << email << std::endl;
    std::cout << "Phone: " << phone << std::endl;
    std::cout << "Status: " << (active ? "Active" : "Inactive") << std::endl;
    std::cout << "Borrowed Books: " << borrowedBooks.size() << std::endl;
} 