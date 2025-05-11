class CustomResource implements AutoCloseable {
    private String name;

    public CustomResource(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource: " + name);
        throw new Exception("Exception from " + name);
    }
}

public class q7_SuppressedExceptionDemo {
    public static void main(String[] args) {
        try (
                CustomResource res1 = new CustomResource("Resource1");
                CustomResource res2 = new CustomResource("Resource2")
        ) {
            System.out.println("Using resources...");
            // No exception in try block; exceptions only occur in close()
        } catch (Exception e) {
            System.err.println("Primary exception: " + e.getMessage());

            // Display suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.err.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}

