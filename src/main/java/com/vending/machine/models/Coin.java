package com.vending.machine.models;

public class Coin {
    public static Coin DOLLAR = new Coin(8.1, 26.5, 1.00);
    private double weight;
    private double diameter;
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
