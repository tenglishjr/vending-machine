package com.vending.machine.repository;

import com.vending.machine.VendingMachineApplication;
import com.vending.machine.models.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = VendingMachineApplication.class
)
public class ProductTableTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void getProductBySelectionId_returnsProduct() {
        ProductTable productTable = new ProductTable(jdbcTemplate);
        String selectionId = "C4";
        jdbcTemplate.execute(
                "INSERT INTO products (selection_id, name, value, inventory) VALUES ('C4', 'Dasani', 1.50, 4)"
        );

        Product actual = productTable.getProductBySelectionId(selectionId);

        Assert.assertEquals(selectionId, actual.getSelectionId());
        Assert.assertEquals("Dasani", actual.getName());
    }

    /*

    TODO:
        - Tests for multiple products returned
        - Tests for zero products returned
        - Cleanup test data
        - Find better way to retrieve 1 item (unique, distinct, limit, etc)

     */
}
