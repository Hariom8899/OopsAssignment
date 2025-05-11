package q5_partialTxnRollbackFailure;

// Account class to represent a bank account
class Account {
    private String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account " + accountId + " - Balance: $" + balance;
    }
}

// Bank class to handle money transfer and rollback
class Bank {
    public void transferFunds(Account fromAccount, Account toAccount, double amount) {
        double originalFromBalance = fromAccount.getBalance();  // Save original balance of fromAccount
        double originalToBalance = toAccount.getBalance();      // Save original balance of toAccount

        try {
            // Step 1: Withdraw from the sender account
            fromAccount.withdraw(amount);
            System.out.println("Withdrew $" + amount + " from " + fromAccount.getAccountId());

            // Step 2: Deposit into the receiver account
            toAccount.deposit(amount);
            System.out.println("Deposited $" + amount + " to " + toAccount.getAccountId());

            System.out.println("Transfer successful.");
        } catch (IllegalArgumentException e) {
            // Step 3: Rollback if there is an error (e.g., insufficient funds)
            fromAccount.deposit(originalFromBalance - fromAccount.getBalance());  // Restore original balance
            toAccount.deposit(originalToBalance - toAccount.getBalance());      // Restore original balance
            System.err.println("Transaction failed. Rolling back changes: " + e.getMessage());
        }
    }
}

public class BankTransferDemo {
    public static void main(String[] args) {
        // Create two accounts
        Account aliceAccount = new Account("Alice", 1000);
        Account bobAccount = new Account("Bob", 500);

        System.out.println("Before transfer:");
        System.out.println(aliceAccount);
        System.out.println(bobAccount);

        // Create a Bank instance and attempt to transfer funds
        Bank bank = new Bank();
        bank.transferFunds(aliceAccount, bobAccount, 1200);  // This will fail (insufficient funds)

        System.out.println("\nAfter transfer attempt:");
        System.out.println(aliceAccount);
        System.out.println(bobAccount);
    }
}

