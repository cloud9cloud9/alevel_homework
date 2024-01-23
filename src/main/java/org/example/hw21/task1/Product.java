package org.example.hw21.task1;

public class Product {
    private String name;
    private Integer price;
    private String category;


    private Product(String name,Integer price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Product createProduct(String name, Integer price, String category) {
        return new Product(name, price, category);
    }
    public static Product createProductByName(String name){
        return new Product(name, null, null);
    }
    public static  Product createProductByCategory(String category){
        return new Product(null, null, category);
    }
    public static Product createProductByPrice(int price){
        return new Product(null, price, null);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Product{");
        appendField(stringBuilder, "name", name);
        appendField(stringBuilder, "price", price);
        appendField(stringBuilder, "category", category);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
    private void appendField(StringBuilder stringBuilder, String fieldName, Object fieldValue) {
        if (fieldValue != null) {
            stringBuilder.append(fieldName).append("='").append(fieldValue);
        }
    }
}