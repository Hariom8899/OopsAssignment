package q1_Library;
class Book {
    private  String title;
    private  String author;
    private  String isbn;

    // Constructor to initialize the book details
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to print book details
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    // Getter method for the title
    public String getTitle() {
        return title;
    }
}
