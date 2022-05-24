package com.jj.shop.service;

import com.jj.shop.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles(value = "test")
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;


    @Test
    void addProduct() {
        Product product= new Product();
        product.setName("Product1");
        product.setPrice(new BigDecimal(123.222));
        productService.addProduct(product);
        assertThat(product.getId()).isGreaterThan(0l);
    }
}
