package com.vending.machine.controllers;

import com.vending.machine.VendingMachineApplication;
import com.vending.machine.models.Coin;
import com.vending.machine.models.PurchaseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = VendingMachineApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class RestControllerIT {

    @LocalServerPort
    private int port;

    @Test
    public void vendingMachineReturnsProduct() {
        String url = "http://localhost:" + port + "/vending-machine/purchase";
        RestTemplate restTemplate = new RestTemplate();
        Coin coin = Coin.DOLLAR;

        ResponseEntity<PurchaseResponse> response = restTemplate.postForEntity(url, coin, PurchaseResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Dr. Pepper", response.getBody().getProduct().getName());
    }
}
