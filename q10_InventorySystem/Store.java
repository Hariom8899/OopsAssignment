package q10_InventorySystem;

public class Store {
    private Product[] products;  // Array to hold products

    // Constructor to initialize store with an array of products
    public Store(Product[] products) {
        this.products = products;
    }

    // Method to display all products in the store
    public void displayAllProducts() {
        System.out.println("Products in Store:");
        for (Product product : products) {
            product.displayProduct();
        }
    }

    // Method to find the product with the highest price
    public Product findHighestPriceProduct() {
        Product highestPriceProduct = products[0];
        for (Product product : products) {
            if (product.getPrice() > highestPriceProduct.getPrice()) {
                highestPriceProduct = product;
            }
        }
        return highestPriceProduct;
    }

    // Method to search for a product by name
    public Product searchProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;  // Return null if no product is found
    }
}

