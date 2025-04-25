package q3_EncapValidn;

public class Main {
    public static void main(String[] args) {
        // Create a new BankAccount object
        BankAccount account = new BankAccount("John Doe", 500, "123456789");

        // Display account details
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: " + account.getBalance());

        // Deposit money
        account.deposit(200);

        // Attempt to set a negative balance (which should be prevented)
        account.setBalance(-100);

        // Withdraw money
        account.withdraw(300);

        // Withdraw more than available balance (should show error)
        account.withdraw(500);
    }
}
