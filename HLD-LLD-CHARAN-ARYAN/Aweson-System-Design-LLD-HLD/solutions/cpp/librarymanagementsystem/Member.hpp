#ifndef MEMBER_HPP
#define MEMBER_HPP

#include <string>
#include <vector>
#include "mdel.Book.hpp"

class mdel.Member {
private:
    std::string memberId;
    std::string name;
    std::string email;
    std::string phone;
    std::vector<mdel.Book*> borrowedBooks;
    bool active;

public:
    mdel.Member(std::string memberId, std::string name, std::string email, std::string phone);
    
    std::string getMemberId() const;
    std::string getName() const;
    std::string getEmail() const;
    std::string getPhone() const;
    bool isActive() const;
    const std::vector<mdel.Book*>& getBorrowedBooks() const;
    
    void addBorrowedBook(mdel.Book* book);
    void removeBorrowedBook(mdel.Book* book);
    void setActive(bool status);
    void displayInfo() const;
};

#endif 