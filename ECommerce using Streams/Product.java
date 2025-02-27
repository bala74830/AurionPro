package com.aurionpro.assignments;

public class Product {
	private int productId;
    private String name;
    private String category;
    private double price;
    private double rating;

    public Product(int productId, String name, String category, double price, double rating) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

   
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", rating=" + rating + "]";
	}

    

}