package q8_BankAccount_This;

public class BankAccount {
    private String name;  // Instance variable for name
    private double balance;  // Instance variable for balance
    private String type;  // Instance variable for account type

    // Constructor that uses 'this' to differentiate between parameters and instance variables
    public BankAccount(String name, double balance, String type) {
        this.name = name;       // 'this.name' refers to the instance variable, 'name' refers to the constructor parameter
        this.balance = balance; // 'this.balance' refers to the instance variable, 'balance' refers to the constructor parameter
        this.type = type;       // 'this.type' refers to the instance variable, 'type' refers to the constructor parameter
    }

    // Method to update balance, where 'this' is used to refer to the instance variable
    public void updateBalance(double balance) {
        this.balance = balance; // 'this.balance' refers to the instance variable, 'balance' refers to the method parameter
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Holder: " + this.name);
        System.out.println("Account Type: " + this.type);
        System.out.println("Current Balance: $" + this.balance);
    }
}

