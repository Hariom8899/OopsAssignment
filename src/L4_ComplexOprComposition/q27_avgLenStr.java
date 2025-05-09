//Compute the average length of strings in a list.
package L4_ComplexOprComposition;

import java.util.Arrays;
import java.util.List;

public class q27_avgLenStr {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        double averageLength = words.stream()
                .mapToInt(String::length)  // Convert each string to its length
                .average()                 // Calculate the average
                .orElse(0.0);              // Return 0.0 if the list is empty

        System.out.println("Average length: " + averageLength);
    }
}

