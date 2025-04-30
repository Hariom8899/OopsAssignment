package q14_RestaurantOrderSys;

import java.util.*;

class Order {
    String orderId;
    String customerName;
    String items;

    public Order(String orderId, String customerName, String items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Items: " + items;
    }
}

public class RestaurantOrderSystem {
    // Deque to manage current orders
    private static Deque<Order> currentOrders = new ArrayDeque<>();

    // List to store order history
    private static List<Order> orderHistory = new ArrayList<>();

    public static void main(String[] args) {
        // Add new orders
        addOrder(new Order("O001", "Alice", "Pizza, Soda"));
        addOrder(new Order("O002", "Bob", "Burger, Fries"));
        addOrder(new Order("O003", "Charlie", "Pasta, Wine"));

        // Remove an order from the front (FIFO)
        removeOrderFromFront();

        // Add another order
        addOrder(new Order("O004", "David", "Steak, Salad"));

        // Remove an order from the back (LIFO)
        removeOrderFromBack();

        // Display current orders
        displayCurrentOrders();

        // Display order history
        displayOrderHistory();
    }

    // Add an order to the current orders deque
    public static void addOrder(Order order) {
        currentOrders.addLast(order); // Add to the back (end)
        orderHistory.add(order); // Add to the history list
        System.out.println("Order added: " + order);
    }

    // Remove an order from the front (FIFO)
    public static void removeOrderFromFront() {
        if (!currentOrders.isEmpty()) {
            Order order = currentOrders.pollFirst(); // Remove from front (FIFO)
            System.out.println("Order removed from front: " + order);
        } else {
            System.out.println("No orders to remove from the front.");
        }
    }

    // Remove an order from the back (LIFO)
    public static void removeOrderFromBack() {
        if (!currentOrders.isEmpty()) {
            Order order = currentOrders.pollLast(); // Remove from back (LIFO)
            System.out.println("Order removed from back: " + order);
        } else {
            System.out.println("No orders to remove from the back.");
        }
    }

    // Display all current orders in the deque
    public static void displayCurrentOrders() {
        System.out.println("\nCurrent Orders:");
        for (Order order : currentOrders) {
            System.out.println(order);
        }
    }

    // Display the order history
    public static void displayOrderHistory() {
        System.out.println("\nOrder History:");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}

