package L1_basics;

public class q7_lamdaRunnableThread {
    public static void main(String[] args) {
        // Creating a Runnable using lambda expression
        Runnable myRunnable = () -> System.out.println("Hello Functional Java");


        // Creating a new thread and passing the Runnable to it
        Thread myThread = new Thread(myRunnable);
        myThread.start();  // Starting the thread
    }
}
