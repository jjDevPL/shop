package com.jj.shop.service;

import com.jj.shop.dao.ProductDao;
import com.jj.shop.domain.Product;
import com.jj.shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getProductById(id);
    }
}
