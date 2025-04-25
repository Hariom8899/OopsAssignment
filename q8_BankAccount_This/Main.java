package q8_BankAccount_This;

public class Main {
    public static void main(String[] args) {
        // Create a new BankAccount object
        BankAccount account = new BankAccount("Alice", 1000.00, "Savings");

        // Display account details
        account.displayDetails();

        // Update the balance
        account.updateBalance(1500.00);

        // Display account details after updating balance
        System.out.println("\nAfter updating balance:");
        account.displayDetails();
    }
}

