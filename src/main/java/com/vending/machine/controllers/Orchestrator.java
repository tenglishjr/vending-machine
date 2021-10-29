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
            if (validateCoins(coin))
                totalValue = totalValue.add(BigDecimal.valueOf(coin.getValue()));
        }

        if (totalValue.compareTo(BigDecimal.valueOf(Coin.DOLLAR.getValue())) == 0)
            return new Product("Dr. Pepper");

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private boolean validateCoins(Coin coin) {
//        return validateCoin(coin, Coin.DOLLAR) ||
//        validateCoin(coin, Coin.QUARTER) ||
//        validateCoin(coin, Coin.DIME) ||
//        validateCoin(coin, Coin.NICKEL);

        return Coin.VALID_COINS.stream().anyMatch(x -> validateCoin(coin, x));
//        return Coin.VALID_COINS.stream().filter(x -> x >= new BigDecimal("5.01"));
//        List<Double> weights = Coin.VALID_COINS.stream().map(x -> x.getWeight()).collect(Collectors.toList());
    }

    private boolean validateCoin(Coin coin, Coin validCoin) {
        return coin.getDiameter() == validCoin.getDiameter() &&
                coin.getWeight() == validCoin.getWeight() &&
                coin.getValue() == validCoin.getValue();
    }
}
