package com.vending.machine.models;

public class Product {
    private String name;
    private String selectionId;

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

    public String getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }
}
