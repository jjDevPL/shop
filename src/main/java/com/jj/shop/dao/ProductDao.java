package com.jj.shop.dao;

import com.jj.shop.domain.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> getAll();
    Product getProductById(Long id);

}
