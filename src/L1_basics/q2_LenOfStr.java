package L1_basics;
import java.util.function.Function;

public class q2_LenOfStr {

        public static void main(String[] args) {
            // Function that takes a String and returns its length
            Function<String, Integer> getLength = str -> str.length();

            String input = "Hello";
//            how you run the function on a value.
            Integer length = getLength.apply(input);
            System.out.println("Length of '" + input + "' is: " + length);
        }
}

