package CustomeTypesNestedSteams;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double rating;

    public Product(String name, String category, double rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class q38_ProductProcessor {

    public static Map<String, String> getHighestRatedProducts(List<Product> products) {
        // Group products by category and get the product with the highest rating in each category
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,  // Group by category
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Product::getRating)),  // Get the max rated product
                                optionalProduct -> optionalProduct.map(Product::getName).orElse(null)  // Extract the product name
                        )
                ));
    }

    public static void main(String[] args) {
        // Sample product list
        List<Product> products = List.of(
                new Product("ProductA", "Electronics", 4.5),
                new Product("ProductB", "Electronics", 4.8),
                new Product("ProductC", "Home", 3.5),
                new Product("ProductD", "Home", 4.0),
                new Product("ProductE", "Electronics", 4.2),
                new Product("ProductF", "Furniture", 5.0)
        );

        // Get the highest-rated product in each category
        Map<String, String> highestRatedProducts = getHighestRatedProducts(products);

        // Output the result
        highestRatedProducts.forEach((category, productName) ->
                System.out.println(category + " → " + productName)
        );
    }
}
