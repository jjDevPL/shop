package com.jj.shop.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Data
@Entity
public class ProductInBasket  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;
    @OneToOne
    private Product product;
    @Max(value = 100)
    private Integer quantity;

}
