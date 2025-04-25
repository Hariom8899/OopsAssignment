package q10_InventorySystem;

public class Product {
    private int id;         // Unique ID for each product
    private String name;    // Name of the product
    private double price;   // Price of the product

    // Constructor to initialize product details
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters for the product fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Method to display product details
    public void displayProduct() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price);
    }
}

