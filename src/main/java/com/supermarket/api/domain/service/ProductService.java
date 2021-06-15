package com.supermarket.api.domain.service;

import com.supermarket.api.domain.repository.ProductRepository;
import com.supermarket.api.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }
}
