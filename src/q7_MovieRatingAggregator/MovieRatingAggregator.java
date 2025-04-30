package q7_MovieRatingAggregator;

import java.util.*;

public class MovieRatingAggregator {
    public static void main(String[] args) {
        // Map: Movie name -> list of ratings
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        // Add sample ratings
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "Inception", 4);
        addRating(movieRatings, "The Matrix", 5);
        addRating(movieRatings, "The Matrix", 5);
        addRating(movieRatings, "The Matrix", 4);
        addRating(movieRatings, "Interstellar", 3);
        addRating(movieRatings, "Interstellar", 4);

        // Compute and display average ratings sorted by descending average
        displayAverageRatings(movieRatings);
    }

    // Add rating to a movie
    public static void addRating(Map<String, List<Integer>> ratings, String movie, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating: " + rating);
            return;
        }
        ratings.computeIfAbsent(movie, k -> new ArrayList<>()).add(rating);
    }

    // Compute and display average rating per movie
    public static void displayAverageRatings(Map<String, List<Integer>> ratings) {
        // Map entry: movie -> average rating
        List<Map.Entry<String, Double>> averageRatings = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : ratings.entrySet()) {
            String movie = entry.getKey();
            List<Integer> ratingList = entry.getValue();
            double average = ratingList.stream().mapToInt(Integer::intValue).average().orElse(0);
            averageRatings.add(new AbstractMap.SimpleEntry<>(movie, average));
        }

        // Sort by descending average rating
        averageRatings.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Display results
        System.out.println("Average Ratings (sorted):");
        for (Map.Entry<String, Double> entry : averageRatings) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}

