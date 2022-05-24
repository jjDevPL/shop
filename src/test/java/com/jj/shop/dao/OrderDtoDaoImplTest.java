package com.jj.shop.dao;

import com.jj.shop.domain.Order;
import com.jj.shop.domain.Product;
import com.jj.shop.domain.ProductInBasket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles(value = "test")
@Transactional
class OrderDtoDaoImplTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;

    Product buildProduct(String name) {
        Product pro1 = new Product();
        pro1.setName(name);
        return  pro1;
    }

    @Test
    void addOrder() {
        Order newOrder= new Order();
        newOrder.setUserId(2l);
        Product pro1=buildProduct("Pro1");
        Product pro2=buildProduct("Pro2");
        productDao.addProduct(pro1);
        productDao.addProduct(pro2);

        ProductInBasket inBasket1= new ProductInBasket();
        inBasket1.setProduct(pro1);
        inBasket1.setQuantity(2);

        ProductInBasket inBasket2= new ProductInBasket();
        inBasket2.setProduct(pro2);
        inBasket2.setQuantity(2);

        newOrder.setProductList(new ArrayList<ProductInBasket>(){{add(inBasket1);add(inBasket2);}});

        orderDao.addOrder(newOrder);
        assertThat(newOrder).isNotNull();
        assertThat(newOrder.getId()).isGreaterThan(0);
    }

    @Test
    void getOrderById() {
        Order newOrder= new Order();
        newOrder.setUserId(2l);
        List<Product> list = new ArrayList<>();
        Product pro1=buildProduct("Pro1");
        Product pro2=buildProduct("Pro2");
        productDao.addProduct(pro1);
        productDao.addProduct(pro2);

        ProductInBasket inBasket1= new ProductInBasket();
        inBasket1.setProduct(pro1);
        inBasket1.setQuantity(2);

        ProductInBasket inBasket2= new ProductInBasket();
        inBasket2.setProduct(pro2);
        inBasket2.setQuantity(2);

        newOrder.setProductList(new ArrayList<ProductInBasket>(){{add(inBasket1);add(inBasket2);}});

        orderDao.addOrder(newOrder);
        assertThat(orderDao.getOrderById(newOrder.getId())).isNotNull();
    }
}
