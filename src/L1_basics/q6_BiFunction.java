package L1_basics;

import java.util.function.BiFunction;

public class q6_BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder = (a ,b) -> a + b;

        // Use apply() to apply the BiFunction
        int result = adder.apply(15, 30);
        System.out.println("Result of addition: " + result);
    }
}
