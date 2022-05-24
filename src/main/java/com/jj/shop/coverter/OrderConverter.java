package com.jj.shop.coverter;

import com.jj.shop.domain.Order;
import com.jj.shop.domain.Product;
import com.jj.shop.domain.ProductInBasket;
import com.jj.shop.dto.OrderDto;
import com.jj.shop.service.ProductService;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OrderConverter extends AbstractConverter<OrderDto, Order> {
    private ProductService productService;

    public OrderConverter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected Order convert(OrderDto orderDto) {
        Order newOrder= new Order();

        newOrder.setUserId(orderDto.getUserId());

        Stream<Map.Entry<Long,Integer>> stream = orderDto.getProductList().entrySet().stream();

        List<ProductInBasket> basket = stream.map(entry-> {
            Product prod = productService.getById(entry.getKey());
            ProductInBasket productInBasket = new ProductInBasket();
            productInBasket.setProduct(prod);
            productInBasket.setQuantity(entry.getValue());
            productInBasket.setOrder(newOrder);
            return productInBasket;

        }).collect(Collectors.toList());

        newOrder.setTotal(basket.stream().map(item -> {
           return item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity()));
        }).reduce(new BigDecimal(0),BigDecimal::add));

        /*newOrder.setProductList(basket);*/
        return newOrder;
    }
}
