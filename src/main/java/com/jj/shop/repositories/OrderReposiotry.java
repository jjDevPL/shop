package com.jj.shop.repositories;

import com.jj.shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposiotry extends JpaRepository<Order,Long> {
}
