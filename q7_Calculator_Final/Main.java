package q7_Calculator_Final;

public class Main {
    public static void main(String[] args) {
        // Create a BasicCalculator object
        BasicCalculator basicCalc = new BasicCalculator();
        System.out.println("BasicCalculator Add: " + basicCalc.add(10, 5));

        // Create a SmartCalculator object
        SmartCalculator smartCalc = new SmartCalculator();
        System.out.println("SmartCalculator Add: " + smartCalc.add(10, 5));  // Inherited from BasicCalculator
        System.out.println("SmartCalculator Subtract: " + smartCalc.subtract(10, 5));
    }
}

