package RealLifeMiniChallenge;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class q52_ListFilterLogger {

    // Reusable method that filters a list based on a Predicate and logs each filtered item
    public static <T> List<T> filterAndLog(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate) // Apply the filter based on the predicate
                .peek(item -> System.out.println("Filtered item: " + item)) // Log each filtered item
                .collect(Collectors.toList()); // Collect the result into a new list
    }

    public static void main(String[] args) {
        // Sample list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Define a Predicate that filters even numbers
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Call the reusable method to filter and log the even numbers
        List<Integer> evenNumbers = filterAndLog(numbers, isEven);

        // Output the filtered list
        System.out.println("Filtered List (Even Numbers): " + evenNumbers);
    }
}

