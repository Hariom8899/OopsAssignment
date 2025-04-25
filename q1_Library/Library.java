package q1_Library;
import java.util.ArrayList;
import java.util.List;

    public class Library {
        private List<Book> books;

        // Constructor to initialize the library's book list
        public Library() {
            books = new ArrayList<>();
        }

        // Method to add a book to the library
        public void addBook(Book book) {
            books.add(book);
        }

        // Method to search for books by title
        public List<Book> searchByTitle(String title) {
            List<Book> foundBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    foundBooks.add(book);
                }
            }
            return foundBooks;
        }

}

