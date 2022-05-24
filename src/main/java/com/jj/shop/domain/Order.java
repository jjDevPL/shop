package com.jj.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    @OneToMany (mappedBy = "order",cascade = CascadeType.ALL)
    private List<ProductInBasket> productList;
    private Long userId;
    private BigDecimal total;

}
