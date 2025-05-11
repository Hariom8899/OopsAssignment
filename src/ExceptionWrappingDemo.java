
// Define a custom exception
class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);  // Preserve the original exception
    }
}

public class ExceptionWrappingDemo {

    // Method that performs an operation and catches exceptions
    public static void riskyOperation() throws CustomException {
        try {
            // Simulate original exception (divide by zero)
            int result = 10 / 0;  // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            // Wrap and rethrow the exception with a custom message
            throw new CustomException("Custom error occurred during risky operation.", e);
        }
    }

    public static void main(String[] args) {
        try {
            riskyOperation();  // Call the method that may throw a CustomException
        } catch (CustomException e) {
            // Catch and print the exception stack trace
            e.printStackTrace();  // Will show both custom and original exception
        }
    }
}
