package com.jj.shop.dao;

import com.jj.shop.domain.Product;
import com.jj.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
@Component
@Transactional
public class ProductDaoImpl implements ProductDao{
    private ProductRepository productRepository;

    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void setup() {
        int z=90;
        z++;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }
}
