package com.vending.machine.models;

public class Product {
    private String name;

    public Product() {      // Jackson needs default constructor for [de]serialization
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
