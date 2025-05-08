package L3_CollectorsAdvanStream;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class q16_groupByFirstLetter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grape", "kiwi", "cherry", "blueberry");

        // Grouping words by their length
        Map<String, List<String>> groupedByFirstChar = words.stream()
                .collect(Collectors.groupingBy(s -> String.valueOf(s.charAt(0))));

        groupedByFirstChar.forEach((key, value) ->
                System.out.println("First Character " + key + ": " + value));
    }
}
