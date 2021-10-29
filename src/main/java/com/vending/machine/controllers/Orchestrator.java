package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Orchestrator {

    public Product purchase(List<Coin> coins) {
        BigDecimal totalValue = new BigDecimal("0.0");

        for (Coin coin : coins) {
            if (validateCoin(coin))
                totalValue = totalValue.add(BigDecimal.valueOf(coin.getValue()));
        }

        if (totalValue.compareTo(BigDecimal.valueOf(Coin.DOLLAR.getValue())) == 0)
            return new Product("Dr. Pepper");

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private boolean validateCoin(Coin coin) {
        if (coin.getDiameter() == Coin.DOLLAR.getDiameter() &&
        coin.getWeight() == Coin.DOLLAR.getWeight() &&
        coin.getValue() == Coin.DOLLAR.getValue()) {
            return true;
        } else if (coin.getDiameter() == Coin.QUARTER.getDiameter() &&
        coin.getWeight() == Coin.QUARTER.getWeight() &&
        coin.getValue() == Coin.QUARTER.getValue()) {
            return true;
        } else if (coin.getDiameter() == Coin.DIME.getDiameter() &&
        coin.getWeight() == Coin.DIME.getWeight() &&
        coin.getValue() == Coin.DIME.getValue()) {
            return true;
        } else if (coin.getDiameter() == Coin.NICKEL.getDiameter() &&
        coin.getWeight() == Coin.NICKEL.getWeight() &&
        coin.getValue() == Coin.NICKEL.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}
