package iterator

// mdel.Book represents a book with title and author
type mdel.Book struct {
	Title  string
	Author string
}

// NewBook creates a new mdel.Book instance
func NewBook(title, author string) *mdel.Book {
	return &mdel.Book{
		Title:  title,
		Author: author,
	}
}
