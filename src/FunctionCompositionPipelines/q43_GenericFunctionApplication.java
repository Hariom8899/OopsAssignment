package FunctionCompositionPipelines;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class q43_GenericFunctionApplication {

    // Generic method to apply a function to all elements of a List<T>
    public static <T, R> List<R> applyFunctionToList(List<T> list, Function<T, R> function) {
        // Apply the function to each element in the list and collect the results into a new list
        return list.stream()
                .map(function)  // Apply the function to each element
                .collect(Collectors.toList());  // Collect results into a new List<R>
    }

    public static void main(String[] args) {
        // Example 1: List of Integers, function that doubles each number
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Function<Integer, Integer> doubleNumber = n -> n * 2;

        List<Integer> doubledNumbers = applyFunctionToList(numbers, doubleNumber);
        System.out.println("Doubled numbers: " + doubledNumbers);  // [2, 4, 6, 8]

        // Example 2: List of Strings, function that converts each string to uppercase
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Function<String, String> toUpperCase = s -> s.toUpperCase();

        List<String> uppercasedWords = applyFunctionToList(words, toUpperCase);
        System.out.println("Uppercased words: " + uppercasedWords);  // [APPLE, BANANA, CHERRY]
    }
}

