package com.supermarket.api.web.controller;

import com.supermarket.api.domain.service.ProductService;
import com.supermarket.api.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getProducts() {
        List<ProductEntity> productList = productService.getProducts();
        return ResponseEntity.ok(productList);
    }
}
