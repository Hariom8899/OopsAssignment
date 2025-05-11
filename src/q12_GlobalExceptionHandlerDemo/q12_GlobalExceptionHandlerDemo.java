package q12_GlobalExceptionHandlerDemo;
// Custom uncaught exception handler for logging uncaught exceptions globally
class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Log the exception with the thread name and exception message
        System.err.println("Global Exception Handler: Exception caught in thread " + t.getName());
        System.err.println("Exception Message: " + e.getMessage());
        e.printStackTrace();  // Optionally, print the stack trace for detailed debugging
    }
}

// Simulate a thread that throws an uncaught exception
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Child thread started...");
        // Simulating an exception thrown in the child thread
        throw new RuntimeException("Unexpected error occurred in child thread!");
    }
}

public class q12_GlobalExceptionHandlerDemo {
    public static void main(String[] args) {
        // Set the default uncaught exception handler for all threads
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        // Simulate some threads that will throw uncaught exceptions
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();

        // Start the threads
        thread1.start();
        thread2.start();

        // Main thread continues its work (no exception in main)
        System.out.println("Main thread is continuing its execution...");
    }
}

