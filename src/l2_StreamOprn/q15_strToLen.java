package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class q15_strToLen {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grape", "kiwi");

        List<Integer> lengths = words.stream()
                .map(String::length)  // Convert each word to its length
                .collect(Collectors.toList());  // Collect the results into a list

        System.out.println("Lengths of words: " + lengths);
    }
}
