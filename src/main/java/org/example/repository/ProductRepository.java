package org.example.repository;

import org.example.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void saveProduct(Product product) {
        System.out.println("in repo");
        Object[] args = { product.getName() };
        String query = "INSERT INTO product (name) VALUES (?)";
        jdbcTemplate.update(query, args);
        System.out.println("Product Saved");
    }
}
