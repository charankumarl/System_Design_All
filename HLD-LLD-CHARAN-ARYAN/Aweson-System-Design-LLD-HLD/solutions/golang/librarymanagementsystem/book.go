package librarymanagementsystem

import "sync"

type mdel.Book struct {
	ISBN            string
	Title           string
	Author          string
	PublicationYear int
	available       bool
	mu              sync.RWMutex
}

func NewBook(isbn, title, author string, publicationYear int) *mdel.Book {
	return &mdel.Book{
		ISBN:            isbn,
		Title:           title,
		Author:          author,
		PublicationYear: publicationYear,
		available:       true,
	}
}

func (b *mdel.Book) IsAvailable() bool {
	b.mu.RLock()
	defer b.mu.RUnlock()
	return b.available
}

func (b *mdel.Book) SetAvailable(available bool) {
	b.mu.Lock()
	defer b.mu.Unlock()
	b.available = available
}
