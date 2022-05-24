package com.jj.shop.controller;

import com.jj.shop.common.CommonResponse;
import com.jj.shop.domain.Order;
import com.jj.shop.domain.Product;
import com.jj.shop.domain.User;
import com.jj.shop.dto.OrderDto;
import com.jj.shop.service.ProductService;
import com.jj.shop.service.UserService;
import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
class OrderControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrderController orderController;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        productService.addProduct(buildProd1());
        productService.addProduct(buildProd2());

        User user = new User();
        user.setName("User1");
        userService.addUser(user);

    }

    Product buildProd1() {
        Product product= new Product();
        product.setName("Product1");
        product.setPrice(new BigDecimal(123.222));
        return product;
    }

    Product buildProd2() {
        Product product2= new Product();
        product2.setName("Product2");
        product2.setPrice(new BigDecimal(123.222));
        return product2;
    }


    @Test
    public void contextLoad() {
        assertThat(orderController).isNotNull();
    }






    @Test
    void testNewOrderWithValidation() {

    }

    @Test
    void testCovertDto() {
        Product p1 = buildProd1();
        Product p2 = buildProd2();
        OrderDto neworder= new OrderDto();
        neworder.setUserId(1L);
        neworder.setProductList(new HashMap<Long,Integer>(){{put(p1.getId(),2);put(p2.getId(),4);}});

        Order order = orderController.covertDto(neworder);

    }
}

