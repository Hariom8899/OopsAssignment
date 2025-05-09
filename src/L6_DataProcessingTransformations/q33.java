//Create a stream pipeline to flatten a list of lists of integers and return the distinct even numbers.
package L6_DataProcessingTransformations;

import java.util.*;
import java.util.stream.*;

public class q33 {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> distinctEvenNumbers = listOfLists.stream()
                .flatMap(Collection::stream)  // Flatten the list of lists
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(distinctEvenNumbers);
    }
}
