package com.jj.shop.config;

import com.jj.shop.domain.Product;
import com.jj.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Configuration
@Profile(value = "!test")
public class DbInit {
    @Autowired
    private ProductService productService;

    @PostConstruct
    public void setUp() {
        Product first=new Product();
        first.setName("Prod1");
        first.setPrice(new BigDecimal(12.11));
        productService.addProduct(first);
        Product first2=new Product();
        first.setName("Prod2");
        first.setPrice(new BigDecimal(12.11));
        productService.addProduct(first2);
    }
}
