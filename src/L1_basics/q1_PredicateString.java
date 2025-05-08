package L1_basics;
import java.util.function.Predicate;

public class q1_PredicateString {
    public static void main(String[] args) {
        Predicate<String> startsWithA = str -> str.startsWith("A");

        String test1 = "Apple";
        String test2 = "Banana";

        System.out.println("Does '" + test1 + "' start with A? " + startsWithA.test(test1));
        System.out.println("Does '" + test2 + "' start with A? " + startsWithA.test(test2));
    }
}
