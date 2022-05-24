package com.jj.shop.dao;

import com.jj.shop.domain.Order;

import java.util.Optional;

public interface OrderDao {
    void addOrder(Order order);
    Optional<Order> getOrderById(Long id);
}
