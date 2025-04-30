package q10_bankTransactionLog;

import java.time.LocalDateTime;
import java.util.*;

// Transaction class
class Transaction {
    LocalDateTime timestamp;
    double amount;
    String description;

    public Transaction(LocalDateTime timestamp, double amount, String description) {
        this.timestamp = timestamp;
        this.amount = amount;
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] $%.2f - %s", timestamp, amount, description);
    }
}

public class BankTransactionLog {
    public static void main(String[] args) {
        // Map: account number -> list of transactions
        Map<String, List<Transaction>> transactionLog = new HashMap<>();

        // Add transactions
        addTransaction(transactionLog, "ACC123", new Transaction(LocalDateTime.of(2025, 5, 1, 9, 0), 200.0, "Deposit"));
        addTransaction(transactionLog, "ACC123", new Transaction(LocalDateTime.of(2025, 5, 1, 12, 0), -50.0, "Withdrawal"));
        addTransaction(transactionLog, "ACC456", new Transaction(LocalDateTime.of(2025, 4, 30, 15, 30), 500.0, "Initial Deposit"));
        addTransaction(transactionLog, "ACC123", new Transaction(LocalDateTime.of(2025, 5, 1, 10, 0), -20.0, "Grocery"));

        // Generate statements
        generateStatement(transactionLog, "ACC123");
        generateStatement(transactionLog, "ACC456");
    }

    // Add a transaction to an account
    public static void addTransaction(Map<String, List<Transaction>> log, String accountNumber, Transaction transaction) {
        log.computeIfAbsent(accountNumber, k -> new ArrayList<>()).add(transaction);
    }

    // Generate a statement for an account
    public static void generateStatement(Map<String, List<Transaction>> log, String accountNumber) {
        List<Transaction> transactions = log.get(accountNumber);
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions for account: " + accountNumber);
            return;
        }

        // Sort by transaction time
        transactions.sort(Comparator.comparing(Transaction::getTimestamp));

        System.out.println("Statement for account: " + accountNumber);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        System.out.println();
    }
}
