package FunctionCompositionPipelines;

import java.util.function.Function;

public class q42_FunctionComposition {

    public static void main(String[] args) {
        // Function to parse a string into an Integer
        Function<String, Integer> parseStringToInt = str -> Integer.parseInt(str);

        // Function to double the integer
        Function<Integer, Integer> doubleNumber = num -> num * 2;

        // Compose the functions: first parse the string to Integer, then double it
        Function<String, Integer> parseAndDouble = parseStringToInt.andThen(doubleNumber);

        // Test input string
        String input = "5";

        // Apply the composed function to the input string
        Integer result = parseAndDouble.apply(input);

        // Output the result
        System.out.println("The doubled number is: " + result);  // Output: 10
    }
}

