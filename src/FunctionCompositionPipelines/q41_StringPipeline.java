package FunctionCompositionPipelines;

import java.util.function.Function;
import java.util.regex.Pattern;

public class q41_StringPipeline {

    public static void main(String[] args) {
        // Define the pipeline functions
        Function<String, String> trim = str -> str.trim(); // Trim leading and trailing spaces
        Function<String, String> lowercase = str -> str.toLowerCase(); // Convert to lowercase
        Function<String, String> removePunctuation = str -> str.replaceAll("[\\p{Punct}]", ""); // Remove punctuation

        // Combine the functions into a single pipeline
        Function<String, String> pipeline = trim.andThen(lowercase).andThen(removePunctuation);

        // Sample input string
        String input = "  Hello, World! This is a test.  ";

        // Apply the pipeline to the input string
        String result = pipeline.apply(input);

        // Output the result
        System.out.println(result); // "hello world this is a test"
    }
}

