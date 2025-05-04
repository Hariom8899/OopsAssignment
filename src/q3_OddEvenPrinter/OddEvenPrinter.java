package q3_OddEvenPrinter;

public class OddEvenPrinter {

    private static final int MAX = 100;
    private int number = 1;
    private final Object lock = new Object();

    public void printOdd() {
        while (number <= MAX) {
            synchronized (lock) {
                while (number % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= MAX) {
                    System.out.print(number + " ");
                    number++;
                    lock.notify();
                }
            }
        }
    }

    public void printEven() {
        while (number <= MAX) {
            synchronized (lock) {
                while (number % 2 == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= MAX) {
                    System.out.print(number + " ");
                    number++;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}

