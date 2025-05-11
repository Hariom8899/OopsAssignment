// Custom uncaught exception handler for detecting exceptions in child threads
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception caught in thread " + t.getName() + ": " + e.getMessage());
    }
}

// Child thread that throws an exception
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Child thread started...");
        // Simulate an exception in the child thread
        throw new RuntimeException("Something went wrong in the child thread!");
    }
}

public class q11_ThreadExceptionHandlingDemo {
    public static void main(String[] args) {
        // Set the uncaught exception handler for all threads
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        // Create and start the child thread
        MyThread thread = new MyThread();
        thread.start();

        // Main thread can continue to work normally, without being affected
        System.out.println("Main thread is continuing its execution...");
    }
}
