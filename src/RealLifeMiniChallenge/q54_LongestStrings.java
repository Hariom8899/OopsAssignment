package RealLifeMiniChallenge;

import java.util.*;
import java.util.stream.Collectors;

public class q54_LongestStrings {

    // Method to return the top 3 longest strings from a list
    public static List<String> getTop3LongestStrings(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))  // Sort by length in descending order
                .limit(3)  // Limit the result to top 3 strings
                .collect(Collectors.toList());  // Collect the result into a List
    }

    public static void main(String[] args) {
        // Sample list of strings
        List<String> strings = Arrays.asList(
                "apple",
                "banana",
                "cherry",
                "watermelon",
                "kiwi",
                "blueberry",
                "grapefruit"
        );

        // Get the top 3 longest strings
        List<String> top3LongestStrings = getTop3LongestStrings(strings);

        // Output the result
        System.out.println("Top 3 Longest Strings: " + top3LongestStrings);
    }
}

