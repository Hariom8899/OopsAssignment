package StreamApi;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private LocalDate orderDate;
    private List<Item> items;

    public Order(LocalDate orderDate, List<Item> items) {
        this.orderDate = orderDate;
        this.items = items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}

public class q50_OrderProcessor {

    public static void main(String[] args) {
        // Sample Orders with dates and items
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.of(2023, 1, 10), Arrays.asList(new Item("Apple", 1.5), new Item("Banana", 0.8))),
                new Order(LocalDate.of(2023, 3, 15), Arrays.asList(new Item("Orange", 1.2), new Item("Date", 2.0))),
                new Order(LocalDate.of(2023, 4, 25), Arrays.asList(new Item("Grapes", 3.0), new Item("Mango", 2.5))),
                new Order(LocalDate.of(2023, 5, 30), Arrays.asList(new Item("Pineapple", 5.0), new Item("Peach", 2.0)))
        );

        // Define the date range
        LocalDate startDate = LocalDate.of(2023, 2, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 1);

        // Chain the operations: filter by date range, map to total amount, sum all totals
        double totalAmount = orders.stream()
                .filter(order -> !order.getOrderDate().isBefore(startDate) && !order.getOrderDate().isAfter(endDate)) // Filter by date range
                .mapToDouble(Order::getTotalAmount) // Map to total amount for each order
                .sum(); // Sum all the total amounts

        // Output the result
        System.out.println("Total amount for orders in the date range: $" + totalAmount);
    }
}

