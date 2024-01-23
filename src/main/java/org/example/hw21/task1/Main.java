package org.example.hw21.task1;

public class Main {
    public static void main(String[] args) {
        Product product = Product.createProduct("banana", 3, "fruits");
        System.out.println(product);

        Product byCategory = Product.createProductByCategory("vegetable");
        System.out.println(byCategory);
        Product byPrice = Product.createProductByPrice(35);
        System.out.println(byPrice);
        Product byName = Product.createProductByName("Tomato");
        System.out.println(byName);
    }
}
