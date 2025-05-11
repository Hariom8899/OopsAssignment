package RealLifeMiniChallenge;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class q51_TextAnalyzer {

    public static Map<String, Long> analyzeText(String text) {
        // Split the text into words, normalize them to lowercase and remove punctuation
        return Arrays.stream(text.split("\\W+")) // Split by non-word characters
                .map(String::toLowerCase) // Convert to lowercase to ensure case insensitivity
                .filter(word -> !word.isEmpty()) // Filter out empty strings (in case of multiple spaces)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count frequencies
    }

    public static void main(String[] args) {
        // Sample paragraph
        String paragraph = "Java is a programming language. Java is widely used. Java can be used in many applications.";

        // Analyze the text and get the word frequencies
        Map<String, Long> wordFrequencies = analyzeText(paragraph);

        // Output the result
        System.out.println("Word Frequencies:");
        wordFrequencies.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}

