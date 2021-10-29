package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrchestratorTest {

    // need to validate coin is equal to expected price
    // validate we are returning the product

    private Orchestrator orchestrator;

    @Before
    public void setup() {
        orchestrator = new Orchestrator();
    }

    @Test
    public void purchaseShouldReturnProductWhenProvidedDollar() {
        // Arrange
        var coins = List.of(Coin.DOLLAR);
        // Act
        Product actual = orchestrator.purchase(coins);
        // Assert
        assertEquals("Dr. Pepper", actual.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void purchaseShouldReturnNoProductWhenProvidedInvalidCurrency() {
        // Arrange
        Coin badCoin = new Coin(24.3, 1.67, 0.25);
        var coins = List.of(badCoin);
        // Act
        orchestrator.purchase(coins);
    }

    @Test
    public void purchase_shouldReturnProductWhenProvidedMultipleQuartersEqualToDollar() {

        List<Coin> coins = Arrays.asList(
                Coin.QUARTER,
                Coin.QUARTER,
                Coin.QUARTER,
                Coin.QUARTER
        );

        Product product = orchestrator.purchase(coins);

        assertEquals("Dr. Pepper", product.getName());
    }

    @Test
    public void purchase_shouldReturnProductWhenProvidedMultipleDimesEqualToDollar() {
        List<Coin> coins = Arrays.asList(
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME,
                Coin.DIME
        );

        Product product = orchestrator.purchase(coins);

        assertEquals("Dr. Pepper", product.getName());
    }

    @Test
    public void purchase_shouldReturnProductWhenProvidedMultipleNickelsEqualToDollar() {
        List<Coin> coins = Arrays.asList(
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL
        );

        Product product = orchestrator.purchase(coins);

        assertEquals("Dr. Pepper", product.getName());
    }

    @Test
    public void purchase_shouldReturnProductWhenProvidedMixtureOfCoinsEqualToDollar() {
        List<Coin> coins = Arrays.asList(
                Coin.QUARTER,
                Coin.QUARTER,
                Coin.QUARTER,
                Coin.DIME,
                Coin.NICKEL,
                Coin.NICKEL,
                Coin.NICKEL
        );

        Product product = orchestrator.purchase(coins);

        assertEquals("Dr. Pepper", product.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void purchase_shouldReturn400BadRequestWhenProvidedCoinsNotEqualToDollar() {
        List<Coin> coins = Arrays.asList(
                Coin.QUARTER,
                Coin.QUARTER,
                Coin.DIME,
                Coin.NICKEL
        );

        orchestrator.purchase(coins);
    }
}
