package com.jj.shop.controller;

import com.jj.shop.common.CommonResponse;
import com.jj.shop.coverter.OrderConverter;
import com.jj.shop.dao.OrderDao;
import com.jj.shop.domain.Order;
import com.jj.shop.domain.Product;
import com.jj.shop.dto.OrderDto;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@Log
public class OrderController {
    private ModelMapper modelMapper;
    private OrderConverter orderConverter;
    private OrderDao orderDao;

    public OrderController(OrderConverter orderConverter, OrderDao orderDao) {
        this.orderConverter = orderConverter;
        this.orderDao = orderDao;
    }

    @PostConstruct
    public void setUp() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(orderConverter);
    }

    @PostMapping("/order/new")
    public ResponseEntity<CommonResponse> newOrder(@Valid @RequestBody OrderDto orderDto) {
        Order orderToAdd =covertDto(orderDto);
        orderDao.addOrder(orderToAdd);
        CommonResponse commonResponse= new CommonResponse(orderToAdd.getId(),orderToAdd.getTotal().toString());
        return ResponseEntity.ok().body(commonResponse);
    }

    Order covertDto(OrderDto orderDto) {
        Order coverted = modelMapper.map(orderDto,Order.class);
        return coverted;

    }
}
