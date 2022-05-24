package com.jj.shop.service;

import com.jj.shop.domain.Product;

public interface ProductService {
    void addProduct(Product product);
    Product getById(Long id);
}
