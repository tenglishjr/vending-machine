package com.vending.machine.repository;

import com.vending.machine.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductTable {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProductBySelectionId(String selectionId) {
        return jdbcTemplate.query(
                "SELECT * FROM products WHERE selection_id = ? LIMIT 1",
                new Object[]{selectionId},
                new BeanPropertyRowMapper<>(Product.class)
        ).get(0);
    }
}
