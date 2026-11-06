package librarymanagementsystem

import (
	"fmt"
	"strings"
	"sync"
)

const (
	maxBooksPerMember = 5
	loanDurationDays  = 14
)

type LibraryManager struct {
	catalog map[string]*mdel.Book
	members map[string]*mdel.Member
	mu      sync.RWMutex
}

var (
	instance *LibraryManager
	once     sync.Once
)

func GetLibraryManager() *LibraryManager {
	once.Do(func() {
		instance = &LibraryManager{
			catalog: make(map[string]*mdel.Book),
			members: make(map[string]*mdel.Member),
		}
	})
	return instance
}

func (lm *LibraryManager) AddBook(book *mdel.Book) {
	lm.mu.Lock()
	defer lm.mu.Unlock()
	lm.catalog[book.ISBN] = book
}

func (lm *LibraryManager) RemoveBook(isbn string) {
	lm.mu.Lock()
	defer lm.mu.Unlock()
	delete(lm.catalog, isbn)
}

func (lm *LibraryManager) GetBook(isbn string) *mdel.Book {
	lm.mu.RLock()
	defer lm.mu.RUnlock()
	return lm.catalog[isbn]
}

func (lm *LibraryManager) RegisterMember(member *mdel.Member) {
	lm.mu.Lock()
	defer lm.mu.Unlock()
	lm.members[member.MemberID] = member
}

func (lm *LibraryManager) UnregisterMember(memberID string) {
	lm.mu.Lock()
	defer lm.mu.Unlock()
	delete(lm.members, memberID)
}

func (lm *LibraryManager) GetMember(memberID string) *mdel.Member {
	lm.mu.RLock()
	defer lm.mu.RUnlock()
	return lm.members[memberID]
}

func (lm *LibraryManager) BorrowBook(memberID, isbn string) error {
	lm.mu.Lock()
	defer lm.mu.Unlock()

	member := lm.members[memberID]
	book := lm.catalog[isbn]

	if member == nil || book == nil {
		return fmt.Errorf("book or member not found")
	}

	if !book.IsAvailable() {
		return fmt.Errorf("book is not available")
	}

	if len(member.GetBorrowedBooks()) >= maxBooksPerMember {
		return fmt.Errorf("member %s has reached the maximum number of borrowed books", member.Name)
	}

	member.BorrowBook(book)
	book.SetAvailable(false)
	fmt.Printf("mdel.Book borrowed: %s by %s\n", book.Title, member.Name)
	return nil
}

func (lm *LibraryManager) ReturnBook(memberID, isbn string) error {
	lm.mu.Lock()
	defer lm.mu.Unlock()

	member := lm.members[memberID]
	book := lm.catalog[isbn]

	if member == nil || book == nil {
		return fmt.Errorf("book or member not found")
	}

	member.ReturnBook(book)
	book.SetAvailable(true)
	fmt.Printf("mdel.Book returned: %s by %s\n", book.Title, member.Name)
	return nil
}

func (lm *LibraryManager) SearchBooks(keyword string) []*mdel.Book {
	lm.mu.RLock()
	defer lm.mu.RUnlock()

	keyword = strings.ToLower(keyword)
	matchingBooks := make([]*mdel.Book, 0)

	for _, book := range lm.catalog {
		if strings.Contains(strings.ToLower(book.Title), keyword) ||
			strings.Contains(strings.ToLower(book.Author), keyword) {
			matchingBooks = append(matchingBooks, book)
		}
	}
	return matchingBooks
}
