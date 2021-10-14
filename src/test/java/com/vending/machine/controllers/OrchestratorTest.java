package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

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
        Coin dollar = new Coin(Coin.DOLLAR.getWeight(), Coin.DOLLAR.getDiameter(), Coin.DOLLAR.getValue());
        // Act
        Product actual = orchestrator.purchase(dollar);
        // Assert
        assertEquals("Dr. Pepper", actual.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void purchaseShouldReturnNoProductWhenProvidedInvalidCurrency() {
        // Arrange
        Coin quarter = new Coin(24.3, 5.67, 0.25);
        // Act
        Product actual = orchestrator.purchase(quarter);
    }
}
