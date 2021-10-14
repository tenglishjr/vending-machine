package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import com.vending.machine.models.PurchaseResponse;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    private Orchestrator orchestrator;

    @Test
    public void getProductShouldCallOrchestrator() {
        orchestrator = Mockito.mock(Orchestrator.class);
        VendingMachineController controller = new VendingMachineController(orchestrator);
        Coin coin = Coin.DOLLAR;

        PurchaseResponse actual = controller.getProduct(coin);

        Mockito.verify(orchestrator, Mockito.times(1)).purchase(coin);
    }

    @Test
    public void getProductShouldReturnProduct() {
        orchestrator = Mockito.mock(Orchestrator.class);
        VendingMachineController controller = new VendingMachineController(orchestrator);
        Coin coin = Coin.DOLLAR;
        Mockito.when(orchestrator.purchase(coin)).thenReturn(new Product("Dr. Pepper"));

        PurchaseResponse actual = controller.getProduct(coin);

        assertEquals("Dr. Pepper", actual.getProduct().getName());
    }
}
