import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final int accountId;
    private final ReentrantLock lock = new ReentrantLock();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public BankAccount(int accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            logTransaction("DEPOSIT", amount);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (amount > balance) {
                logTransaction("FAILED WITHDRAW", amount);
                return false; // Reject overdraw
            }
            balance -= amount;
            logTransaction("WITHDRAW", amount);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    private void logTransaction(String type, double amount) {
        String timestamp = dateFormat.format(new Date());
        System.out.printf("[%s] Account %d - %s: $%.2f, Balance: $%.2f\n",
                timestamp, accountId, type, amount, balance);
    }

    // Testing method
    public static void main(String[] args) throws InterruptedException {
        final BankAccount account = new BankAccount(101, 1000.00);
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                account.deposit(100);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(10));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            executor.execute(() -> {
                account.withdraw(50);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(10));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.printf("Final Balance in Account %d: $%.2f\n", account.accountId, account.getBalance());
    }
}
