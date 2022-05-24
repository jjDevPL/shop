package com.jj.shop;

import com.jj.shop.common.CommonResponse;
import com.jj.shop.controller.OrderController;
import com.jj.shop.domain.Product;
import com.jj.shop.domain.User;
import com.jj.shop.dto.OrderDto;
import com.jj.shop.service.ProductService;
import com.jj.shop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class OrderIntegrationTest {
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
        Product product= new Product();
        product.setName("Product1");
        product.setPrice(new BigDecimal(123.222));
        productService.addProduct(product);

        Product product2= new Product();
        product2.setName("Product2");
        product2.setPrice(new BigDecimal(123.222));
        productService.addProduct(product2);

        User user = new User();
        user.setName("User1");
        userService.addUser(user);

    }

    @Test
    public void newNotValidOrder() {
        ResponseEntity<CommonResponse> respo  = this.restTemplate.postForEntity("http://localhost:" + port + "/order/new",new OrderDto(),
            CommonResponse.class);
        assertThat(respo.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void newValidOrder() {
        OrderDto neworder= new OrderDto();
        neworder.setUserId(123l);
        // prodId, count
        Map<Long,Integer> products = new HashMap<>();

        products.put(1l,12);
        products.put(2l,5);
        neworder.setProductList(products);

        ResponseEntity<CommonResponse> respo  = this.restTemplate.postForEntity("http://localhost:" + port + "/order/new",neworder,
            CommonResponse.class);
        assertThat(respo.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(((CommonResponse)respo.getBody()).getMessage()).isNotNull();
    }
}
