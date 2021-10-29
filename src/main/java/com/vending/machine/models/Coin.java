package com.vending.machine.models;

public class Coin {
    public static Coin DOLLAR = new Coin(8.1, 26.5, 1.00);
    public static Coin QUARTER = new Coin(5.67, 24.26, 0.25);
    public static Coin DIME = new Coin(2.268, 17.91, 0.10);
    public static Coin NICKEL = new Coin(5.0, 21.21, 0.05);
    private double weight;      // in grams
    private double diameter;    // in millimeters
    private double value;

    public Coin() {
    }

    public Coin(double weight, double diameter, double value) {
        this.weight = weight;
        this.diameter = diameter;
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getValue() {
        return value;
    }
}
