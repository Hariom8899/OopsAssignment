//Ques From a list of words, remove duplicates and return sorted result.
package L4_ComplexOprComposition;
import java.util.*;
import java.util.stream.Collectors;

public class q26_RemoveDuplString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        // Remove duplicates and sort the list
        List<String> uniqueSortedWords = words.stream()
                .distinct() // Remove duplicates
                .sorted()   // Sort the words
                .collect(Collectors.toList());

        System.out.println("Unique and Sorted Words: " + uniqueSortedWords);
    }
}

