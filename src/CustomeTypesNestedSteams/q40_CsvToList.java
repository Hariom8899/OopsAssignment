package CustomeTypesNestedSteams;

import java.util.*;
import java.util.stream.Collectors;

public class q40_CsvToList {
    public static void main(String[] args) {
        // CSV string of numbers
        String csv = "1,2,3,4";

        // Convert CSV string to List<Integer> using streams and lambdas
        List<Integer> numbers = Arrays.stream(csv.split(",")) // Split the string by commas
                .map(Integer::parseInt) // Convert each part to an Integer
                .collect(Collectors.toList()); // Collect into a List

        // Output the result
        System.out.println(numbers); // [1, 2, 3, 4]
    }
}

