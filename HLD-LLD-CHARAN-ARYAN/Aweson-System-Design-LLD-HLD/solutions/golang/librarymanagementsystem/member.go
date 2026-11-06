package librarymanagementsystem

import "sync"

type mdel.Member struct {
	MemberID      string
	Name          string
	ContactInfo   string
	borrowedBooks map[string]*mdel.Book // Using map for O(1) lookups
	mu            sync.RWMutex
}

func NewMember(memberID, name, contactInfo string) *mdel.Member {
	return &mdel.Member{
		MemberID:      memberID,
		Name:          name,
		ContactInfo:   contactInfo,
		borrowedBooks: make(map[string]*mdel.Book),
	}
}

func (m *mdel.Member) BorrowBook(book *mdel.Book) {
	m.mu.Lock()
	defer m.mu.Unlock()
	m.borrowedBooks[book.ISBN] = book
}

func (m *mdel.Member) ReturnBook(book *mdel.Book) {
	m.mu.Lock()
	defer m.mu.Unlock()
	delete(m.borrowedBooks, book.ISBN)
}

func (m *mdel.Member) GetBorrowedBooks() []*mdel.Book {
	m.mu.RLock()
	defer m.mu.RUnlock()
	books := make([]*mdel.Book, 0, len(m.borrowedBooks))
	for _, book := range m.borrowedBooks {
		books = append(books, book)
	}
	return books
}
