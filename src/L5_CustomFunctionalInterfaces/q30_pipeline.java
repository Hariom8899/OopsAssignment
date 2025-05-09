//Ques -> Implement a function pipeline to process orders (e.g., filter by status, sort by amount, map to customer name).
package L5_CustomFunctionalInterfaces;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Objects;

class Order {
    private String id;
    private double amount;
    private String status;
    private String customerName;

    public Order(String id, double amount, String status, String customerName) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCompleted() {
        return "COMPLETED".equalsIgnoreCase(status);
    }

    public boolean isPending() {
        return "PENDING".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return String.format("Order{id='%s', amount=%.2f, status='%s', customerName='%s'}",
                id, amount, status, customerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Double.compare(order.amount, amount) == 0 &&
                Objects.equals(id, order.id) &&
                Objects.equals(status, order.status) &&
                Objects.equals(customerName, order.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, status, customerName);
    }
}


public class q30_pipeline {

    public static List<String> processOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> "COMPLETED".equals(order.getStatus())) // Step 1: Filter by status
                .sorted(Comparator.comparingDouble(Order::getAmount)) // Step 2: Sort by amount
                .map(Order::getCustomerName) // Step 3: Map to customer names
                .collect(Collectors.toList()); // Collect results into a list
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("1", 250.0, "COMPLETED", "Alice"),
                new Order("2", 150.0, "PENDING", "Bob"),
                new Order("3", 300.0, "COMPLETED", "Charlie"),
                new Order("4", 200.0, "COMPLETED", "David")
        );

        List<String> customerNames = processOrders(orders);
        customerNames.forEach(System.out::println);
    }
}
