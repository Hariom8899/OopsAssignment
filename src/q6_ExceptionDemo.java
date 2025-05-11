// Checked Exception: For expected recoverable problems
class FileValidationException extends Exception {
    public FileValidationException(String message) {
        super(message);
    }
}

// Unchecked Exception: For unrecoverable or critical problems
class CriticalSystemException extends RuntimeException {
    public CriticalSystemException(String message) {
        super(message);
    }
}

public class q6_ExceptionDemo {

    // Method that validates a file path, may throw checked exception
    public static void validateFile(String filename) throws FileValidationException {
        if (filename == null || filename.trim().isEmpty()) {
            throw new FileValidationException("File name is invalid or missing.");
        }
        System.out.println("File validated: " + filename);
    }

    // Method that simulates a fatal internal failure
    public static void performCriticalOperation() {
        boolean corrupted = true; // Simulate a corrupted system state
        if (corrupted) {
            throw new CriticalSystemException("Critical system failure: memory corruption detected.");
        }
        System.out.println("Critical operation completed.");
    }

    public static void main(String[] args) {
        // Example with checked exception
        try {
            validateFile("");  // Triggers FileValidationException
        } catch (FileValidationException e) {
            System.err.println("Handled checked exception: " + e.getMessage());
        }

        // Example with unchecked exception
        try {
            performCriticalOperation();  // Triggers CriticalSystemException
        } catch (CriticalSystemException e) {
            System.err.println("Caught runtime exception: " + e.getMessage());
        }

        System.out.println("Program continues after handling exceptions.");
    }
}

