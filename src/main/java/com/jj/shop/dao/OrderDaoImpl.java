package com.jj.shop.dao;

import com.jj.shop.domain.Order;
import com.jj.shop.repositories.OrderReposiotry;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class OrderDaoImpl implements OrderDao {
    private OrderReposiotry orderReposiotry;

    public OrderDaoImpl(OrderReposiotry orderReposiotry) {
        this.orderReposiotry = orderReposiotry;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderReposiotry.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderReposiotry.findById(id);
    }
}
