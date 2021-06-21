package com.supermarket.api.domain.service;

import com.supermarket.api.domain.repository.ProductRepository;
import com.supermarket.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        product = productRepository.save(product);
        return product;
    }

    public boolean deleteProduct(String productId) throws Exception {
        return getProduct(productId).map(product -> {
            productRepository.deleteById(productId);
            return true;
        }).orElse(false);
    }

}
