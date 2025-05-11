import java.sql.SQLException;

// Custom exception for the service layer
class ServiceLayerException extends Exception {
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Repository layer simulating database access
class UserRepository {
    public String fetchUserById(int id) throws SQLException {
        // Simulate a database failure
        throw new SQLException("Failed to connect to the database.");
    }
}

// Service layer that wraps low-level exceptions
class UserService {
    private UserRepository repository = new UserRepository();

    public String getUserInfo(int userId) throws ServiceLayerException {
        try {
            return repository.fetchUserById(userId);
        } catch (SQLException e) {
            // Wrap and rethrow
            throw new ServiceLayerException("Service failed to fetch user info.", e);
        }
    }
}

// Controller layer that handles requests and logs exceptions
class UserController {
    private UserService service = new UserService();

    public void handleRequest(int userId) {
        try {
            String user = service.getUserInfo(userId);
            System.out.println("User Info: " + user);
        } catch (ServiceLayerException e) {
            // Log the error with full stack info
            System.err.println("Controller caught exception: " + e.getMessage());
            Throwable cause = e.getCause();
            if (cause != null) {
                System.err.println("Caused by: " + cause.getClass().getSimpleName() + " - " + cause.getMessage());
            }
        }
    }
}

// Main class to run the simulation
public class q9_LayeredAppDemo {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.handleRequest(42);  // Simulate a request
    }
}

