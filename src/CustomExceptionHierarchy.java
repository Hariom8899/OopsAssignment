
// Base custom exception
class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// Subclass for insufficient funds
class InsufficientFundsException extends BankingException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Subclass for invalid account
class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

class Bank {
    public void transferFunds(String fromAccount, String toAccount, double amount)
            throws InsufficientFundsException, InvalidAccountException {

        if (fromAccount == null || toAccount == null) {
            throw new InvalidAccountException("Account cannot be null.");
        }

        if (amount > 1000) {  // Suppose max transferable amount is 1000 for demo
            throw new InsufficientFundsException("Insufficient funds in account: " + fromAccount);
        }

        System.out.println("Transferred $" + amount + " from " + fromAccount + " to " + toAccount);
    }
}

public class CustomExceptionHierarchy {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // --- Catching exceptions separately ---
        try {
            bank.transferFunds("12345", "67890", 2000); // Too much -> throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Caught specific exception: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Caught specific exception: " + e.getMessage());
        }

        // --- Catching using parent exception ---
        try {
            bank.transferFunds(null, "67890", 500); // Invalid account
        } catch (BankingException e) {
            System.out.println("Caught general banking exception: " + e.getMessage());
        }
    }
}

