package com.vending.machine.controllers;

import com.vending.machine.models.Coin;
import com.vending.machine.models.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vending-machine")
public class VendingMachineController {

    private Orchestrator orchestrator;

    @Autowired
    public VendingMachineController(Orchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping("/purchase")
    public PurchaseResponse getProduct(@RequestBody Coin coin) {
        PurchaseResponse response = new PurchaseResponse();
        response.setProduct(orchestrator.purchase(coin));
        return response;
    }
}
