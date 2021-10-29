package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.Product;
import com.vending.machine.models.PurchaseResponse;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    private Orchestrator orchestrator;

    @Test
    public void getProductShouldCallOrchestrator() {
        orchestrator = Mockito.mock(Orchestrator.class);
        VendingMachineController controller = new VendingMachineController(orchestrator);
        var coins = List.of(Coin.DOLLAR);

        PurchaseResponse actual = controller.getProduct(coins);

        Mockito.verify(orchestrator, Mockito.times(1)).purchase(coins);
    }

    @Test
    public void getProductShouldReturnProduct() {
        orchestrator = Mockito.mock(Orchestrator.class);
        VendingMachineController controller = new VendingMachineController(orchestrator);
        var coins = List.of(Coin.DOLLAR);
        Mockito.when(orchestrator.purchase(coins)).thenReturn(new Product("Dr. Pepper"));

        PurchaseResponse actual = controller.getProduct(coins);

        assertEquals("Dr. Pepper", actual.getProduct().getName());
    }
}
