package L1_basics;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class q3_upperCase {
    public static void main(String[] args) {
        Consumer<String> toUpperCase = str -> System.out.println(str.toUpperCase());

        String test1 = "Apple";
        String test2 = "Banana";

        toUpperCase.accept(test1);
        toUpperCase.accept(test1);

    }
}
