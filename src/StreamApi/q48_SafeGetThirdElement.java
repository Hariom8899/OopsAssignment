package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class q48_SafeGetThirdElement {

    public static <T> Optional<T> getThirdElement(List<T> list) {
        return list.stream()
                .skip(2) // Skip the first two elements
                .findFirst(); // Get the next (third) element, if present
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Safely get the third element
        Optional<String> thirdElement = getThirdElement(list);

        // Print the third element if present, otherwise print a message
        thirdElement.ifPresentOrElse(
                element -> System.out.println("Third element: " + element),
                () -> System.out.println("There is no third element.")
        );
    }
}

