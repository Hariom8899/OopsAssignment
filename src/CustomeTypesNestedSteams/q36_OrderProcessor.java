package CustomeTypesNestedSteams;

import java.util.List;
import java.util.stream.Collectors;

// Class representing an Item with a name
class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing an Order that contains a list of Items
class Order {
    private List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}

// Main class that processes the Orders and extracts all item names
public class q36_OrderProcessor {

    // Method that flattens the list of orders and extracts item names
    public static List<String> getAllItemNames(List<Order> orders) {
        return orders.stream()                          // Stream of Orders
                .flatMap(order -> order.getItems().stream())  // Flatten each Order's Items into a Stream of Items
                .map(Item::getName)                     // Map to Item names
                .collect(Collectors.toList());           // Collect to a List of strings
    }

    public static void main(String[] args) {
        // Sample Orders and Items
        Item item1 = new Item("Apple");
        Item item2 = new Item("Banana");
        Item item3 = new Item("Carrot");
        Item item4 = new Item("Date");

        // Creating two orders with items
        Order order1 = new Order(List.of(item1, item2));
        Order order2 = new Order(List.of(item3, item4));

        // Adding the orders to a list
        List<Order> orders = List.of(order1, order2);

        // Get all item names from all orders
        List<String> allItemNames = getAllItemNames(orders);

        // Print the result
        System.out.println(allItemNames);  // Output: [Apple, Banana, Carrot, Date]
    }
}

