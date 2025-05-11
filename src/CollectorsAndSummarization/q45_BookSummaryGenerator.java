package CollectorsAndSummarization;

import java.util.List;
import java.util.OptionalDouble;

class Book {
    private String title;
    private double rating;
    private double price;

    public Book(String title, double rating, double price) {
        this.title = title;
        this.rating = rating;
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }
}

class Summary {
    private int totalCount;
    private double averageRating;
    private double totalPrice;

    public Summary(int totalCount, double averageRating, double totalPrice) {
        this.totalCount = totalCount;
        this.averageRating = averageRating;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "totalCount=" + totalCount +
                ", averageRating=" + averageRating +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class q45_BookSummaryGenerator {

    public static Summary generateSummary(List<Book> books) {
        int totalCount = books.size();

        // Calculate the average rating (Handle case where no books are present)
        OptionalDouble avgRating = books.stream()
                .mapToDouble(Book::getRating)
                .average();
        double averageRating = avgRating.isPresent() ? avgRating.getAsDouble() : 0;

        // Calculate the total price
        double totalPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        // Create and return a Summary object
        return new Summary(totalCount, averageRating, totalPrice);
    }

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Book A", 4.5, 29.99),
                new Book("Book B", 3.8, 19.99),
                new Book("Book C", 5.0, 39.99)
        );

        Summary summary = generateSummary(books);

        System.out.println(summary);
    }
}

