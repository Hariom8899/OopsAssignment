// Custom checked exception for final failure after retries
class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}

// Simulated flaky service that randomly fails
class FlakyService {
    public String readData() throws RuntimeException {
        if (Math.random() < 0.7) {  // 70% chance to fail
            throw new RuntimeException("Service failure");
        }
        return "Successful response!";
    }
}

// Retry handler with 3-attempt policy
class RetryHandler {
    private static final int MAX_RETRIES = 3;

    public String fetchWithRetry(FlakyService service) throws ServiceUnavailableException {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Attempt " + attempt);
                return service.readData();
            } catch (RuntimeException e) {
                System.err.println("Failed attempt " + attempt + ": " + e.getMessage());

                if (attempt == MAX_RETRIES) {
                    throw new ServiceUnavailableException("Service failed after " + MAX_RETRIES + " attempts.");
                }

                // Optional: short delay before retry
                try {
                    Thread.sleep(500); // 0.5 second
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Best practice for handling interrupts
                }
            }
        }
        return null; // Unreachable, but required
    }
}

// Main class to test retry mechanism
public class q8_RetryDemo {
    public static void main(String[] args) {
        FlakyService service = new FlakyService();
        RetryHandler retryHandler = new RetryHandler();

        try {
            String result = retryHandler.fetchWithRetry(service);
            System.out.println("Service returned: " + result);
        } catch (ServiceUnavailableException e) {
            System.err.println("Final error: " + e.getMessage());
        }
    }
}

