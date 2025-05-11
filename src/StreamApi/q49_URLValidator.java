package StreamApi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class q49_URLValidator {

    // Predicate to check if a URL is valid
    public static Predicate<String> isValidURL() {
        return url -> {
            try {
                // Try to create a URL object from the string. If it fails, it's not valid.
                new URL(url);
                return true;
            } catch (MalformedURLException e) {
                return false;
            }
        };
    }

    public static void main(String[] args) {
        // Sample list of URLs
        List<String> urls = Arrays.asList(
                "https://www.google.com",
                "htp://invalid-url",
                "http://example.com",
                "ftp://ftp.example.com",
                "://invalid-url"
        );

        // Use streams to filter valid URLs
        List<String> validURLs = urls.stream()
                .filter(isValidURL())  // Apply the URL validation predicate
                .collect(Collectors.toList()); // Collect the valid URLs into a new list

        // Output the valid URLs
        System.out.println("Valid URLs:");
        validURLs.forEach(System.out::println);
    }
}

