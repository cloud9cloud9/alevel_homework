package org.example.hw21.task1;

public class Product {
    private String name;
    private int price;
    private String category;


    private Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Product createProduct(String name, int price, String category) {
        return new Product(name, price, category);
    }
}