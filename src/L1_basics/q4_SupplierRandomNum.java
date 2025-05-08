package L1_basics;

import java.util.function.Supplier;

public class q4_SupplierRandomNum {
    public static void main(String[] args) {
        // Supplier that provides a random number
        Supplier<Double> randomNum = () -> Math.random()*10;
        System.out.println("Random Number1: " + randomNum.get());
        System.out.println("Random Number2: " + randomNum.get());

    }
}
