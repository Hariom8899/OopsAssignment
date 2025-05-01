package q6_LibraryCatlog;

import java.util.*;

class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Override equals to avoid duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    // Override hashCode to match equals
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, publicationYear);
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

public class LibraryCatalog {
    public static void main(String[] args) {
        // Map of genre to set of books
        Map<String, Set<Book>> catalog = new HashMap<>();

        // Add books to genres
        addBook(catalog, "Science Fiction", new Book("Dune", "Frank Herbert", 1965));
        addBook(catalog, "Science Fiction", new Book("Neuromancer", "William Gibson", 1984));
        addBook(catalog, "Science Fiction", new Book("Dune", "Frank Herbert", 1965)); // Duplicate
        addBook(catalog, "Fantasy", new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        addBook(catalog, "Fantasy", new Book("The Name of the Wind", "Patrick Rothfuss", 2007));

        for (String key : catalog.keySet()) {
            printBooksByGenreSorted(catalog, key);
        }
    }

    // Adds a book to the genre set
    public static void addBook(Map<String, Set<Book>> catalog, String genre, Book book) {
        catalog.computeIfAbsent(genre, k -> new HashSet<>()).add(book);
    }

    // Prints sorted books in a genre
    public static void printBooksByGenreSorted(Map<String, Set<Book>> catalog, String genre) {
        Set<Book> books = catalog.get(genre);
        if (books == null) {
            System.out.println("Genre not found.");
            return;
        }

        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparingInt(Book::getPublicationYear));

        System.out.println("Books in genre: " + genre);
        for (Book book : sortedBooks) {
            System.out.println(book);
        }
    }
}

