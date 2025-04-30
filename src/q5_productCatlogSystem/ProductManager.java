package q5_productCatlogSystem;
import java.util.*;

// Product class definition
class Product {
    int id;
    String name;
    double price;
    double rating;
    int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public double getRating() {
        return rating;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, rating=%.1f, stock=%d}",
                id, name, price, rating, stock);
    }
}

public class ProductManager {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        // Adding products to the TreeMap
        productMap.put(101, new Product(101, "Laptop", 1500.00, 4.5, 10));
        productMap.put(102, new Product(102, "Phone", 800.00, 4.7, 25));
        productMap.put(103, new Product(103, "Tablet", 300.00, 4.5, 15));
        productMap.put(104, new Product(104, "Monitor", 200.00, 4.2, 5));
        productMap.put(105, new Product(105, "Keyboard", 50.00, 4.7, 30));

        // Convert values to a list for custom sorting
        List<Product> productList = new ArrayList<>(productMap.values());

        // Sort by descending rating, then by name
        productList.sort(Comparator
                .comparingDouble(Product::getRating).reversed()
                .thenComparing(Product::getName));

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
