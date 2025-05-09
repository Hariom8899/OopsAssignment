//Ques -> Compose two functions: one that converts string to uppercase and one that appends “!”.
package L4_ComplexOprComposition;
import java.util.function.*;

public class q23 {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = str -> str.toUpperCase();

        Function<String, String> appendExclamation = str -> str + "!";

        Function<String, String> upperCaseAndExclaim = toUpperCase.andThen(appendExclamation);

        String result = upperCaseAndExclaim.apply("hello");
        System.out.println(result);
    }
}
