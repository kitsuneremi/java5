package com.example.demo.b4;

public class Product {
    private int proid;
    private String name;

    private int quantity;

    private Double price;

    public Product() {
    }

    public Product(int proid, String name, int quantity, Double price) {
        this.proid = proid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
