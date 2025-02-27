package com.aurionpro.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import ProductManagement.model.Product;

public class ProductManagement {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        Set<Integer> productIds = new HashSet<>();
        Set<String> productNames = new HashSet<>();
        Set<String> validCategories = new HashSet<>(Arrays.asList("toys", "groceries", "makeup", "stationary", "wearables"));

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter the number of products: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid positive integer.");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");

            int productId;
            while (true) {
                try {
                    System.out.print("Product ID (must be unique and non-negative): ");
                    productId = Integer.parseInt(scanner.nextLine());

                    if (productId < 0) {
                        System.out.println("Error: Product ID cannot be negative. Try again.");
                    } else if (productIds.contains(productId)) {
                        System.out.println("Error: Product ID must be unique. Try again.");
                    } else {
                        productIds.add(productId);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid non-negative integer.");
                }
            }

            String name;
            while (true) {
                System.out.print("Product Name (must be unique): ");
                name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Error: Product name cannot be empty. Try again.");
                } else if (productNames.contains(name)) {
                    System.out.println("Error: Product name must be unique. Try again.");
                } else {
                    productNames.add(name);
                    break;
                }
            }

            String category;
            while (true) {
                System.out.print("Category (choose from: toys, groceries, makeup, stationary, wearables): ");
                category = scanner.nextLine().trim().toLowerCase();

                if (!validCategories.contains(category)) {
                    System.out.println("Error: Invalid category. Please choose from: toys, groceries, makeup, stationary, wearables.");
                } else {
                    break;
                }
            }

            double price;
            while (true) {
                try {
                    System.out.print("Price (must be non-negative): ");
                    price = Double.parseDouble(scanner.nextLine());

                    if (price < 0) {
                        System.out.println("Error: Price cannot be negative. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid numeric price.");
                }
            }

            double rating;
            while (true) {
                try {
                    System.out.print("Rating (must be between 0 and 5): ");
                    rating = Double.parseDouble(scanner.nextLine());

                    if (rating < 0 || rating > 5) {
                        System.out.println(" Error: Rating must be between 0 and 5. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid rating between 0 and 5.");
                }
            }

            products.add(new Product(productId, name, category, price, rating));
        }

        // Filter all products whose price is greater than 5000
        System.out.println("\nProducts priced above $5000:");
        products.stream()
                .filter(product -> product.getPrice() > 5000)
                .forEach(System.out::println);

        // Sort products by rating in descending order
        System.out.println("\nProducts sorted by rating (high to low):");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getRating).reversed())
                .forEach(System.out::println);

        // Group products by category
        System.out.println("\nProducts grouped by category:");
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // Find the most expensive product
        System.out.println("\nMost expensive product:");
        products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
        System.out.println("\nAverage price of all products: $" + averagePrice);

        // Convert all product names to uppercase
        System.out.println("\nProduct names in uppercase:");
        products.stream()
                .map(product -> product.getName().toUpperCase())
                .forEach(System.out::println);

        // Find the total number of products in each category
        System.out.println("\nTotal number of products per category:");
        Map<String, Long> productCountByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        productCountByCategory.forEach((category, count) -> {
            System.out.println(category + ": " + count);
        });
    }

}