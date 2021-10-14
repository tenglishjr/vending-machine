package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class Orchestrator {

    public Product purchase(Coin coin) {
        if (coin.getDiameter() == Coin.DOLLAR.getDiameter() &&
                coin.getValue() == Coin.DOLLAR.getValue() &&
                coin.getWeight() == Coin.DOLLAR.getWeight()) {
            return new Product("Dr. Pepper");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
