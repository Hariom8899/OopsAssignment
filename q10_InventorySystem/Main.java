package q10_InventorySystem;

public class Main {
    public static void main(String[] args) {
        // Create some Product objects
        Product p1 = new Product(1, "Laptop", 999.99);
        Product p2 = new Product(2, "Smartphone", 499.99);
        Product p3 = new Product(3, "Tablet", 299.99);

        // Create an array of products
        Product[] productArray = { p1, p2, p3 };

        // Create a Store object
        Store store = new Store(productArray);

        // Display all products in the store
        store.displayAllProducts();

        // Find and display the product with the highest price
        Product highestPriceProduct = store.findHighestPriceProduct();
        System.out.println("\nProduct with highest price:");
        highestPriceProduct.displayProduct();

        // Search for a product by name
        String searchName = "Smartphone";
        Product searchedProduct = store.searchProductByName(searchName);
        if (searchedProduct != null) {
            System.out.println("\nProduct found: ");
            searchedProduct.displayProduct();
        } else {
            System.out.println("\nProduct with name \"" + searchName + "\" not found.");
        }
    }
}

