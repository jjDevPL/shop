package com.jj.shop.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    void getAll() {
        assertThat(productDao.getAll()).isNotNull();
    }

    @Test
    void getProductById() {
        assertThat(productDao.getProductById(1l)).isNotNull();
    }
}
