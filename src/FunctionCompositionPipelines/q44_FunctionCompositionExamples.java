package FunctionCompositionPipelines;

import java.util.function.Function;

public class q44_FunctionCompositionExamples {

    public static void main(String[] args) {

        // Function 1: Converts a string to uppercase
        Function<String, String> toUpperCase = str -> str.toUpperCase();

        // Function 2: Returns the length of the string
        Function<String, Integer> length = str -> str.length();

        // Using andThen: First, convert to uppercase, then calculate the length of the string
        Function<String, Integer> upperCaseAndLength = toUpperCase.andThen(length);

        // Using compose: First, calculate the length of the string, then convert the length to uppercase
        Function<String, String> lengthAndUpperCase = length.andThen(len -> String.valueOf(len).toUpperCase());

        // Test string
        String input = "hello world";

        // Applying the andThen() composed function
        Integer resultAndThen = upperCaseAndLength.apply(input);
        System.out.println("Result using andThen: " + resultAndThen);  // Output: 11

        // Applying the compose() composed function
        String resultCompose = lengthAndUpperCase.apply(input);
        System.out.println("Result using compose: " + resultCompose);  // Output: 11
    }
}

