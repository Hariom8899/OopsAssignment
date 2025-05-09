//Given a list of transactions (with amount and type), calculate the total amount for type "DEBIT" using streams.
package L6_DataProcessingTransformations;
import java.util.*;
import java.util.stream.*;

class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}


public class q31_TxnDebit {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(100.0, "DEBIT"),
                new Transaction(50.0, "CREDIT"),
                new Transaction(200.0, "DEBIT"),
                new Transaction(150.0, "CREDIT")
        );

        Optional<Double> totDebitAmountOptional = transactions.stream()
                .filter(txn -> txn.getType().equals("DEBIT"))
                .map(txn -> txn.getAmount())
                .reduce((a, b) -> a+b);
        System.out.println("Total Debit Amount (Optional): " + totDebitAmountOptional);
    }
}
