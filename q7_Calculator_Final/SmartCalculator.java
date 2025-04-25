package q7_Calculator_Final;

public class SmartCalculator extends BasicCalculator {

    // Attempting to override the final method 'add' will cause a compile-time error
    // public int add(int a, int b) {  // This will give an error
    //     return a + b + 1;  // This is just an example of what would cause the error
    // }

    // New method 'subtract' added in the subclass
    public int subtract(int a, int b) {
        return a - b;
    }
}

