package com.supermarket.api.web.controller;

import com.supermarket.api.domain.service.ProductService;
import com.supermarket.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // @GetMapping("/all")
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        List<Product> productList = productService.getProducts();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String productId) throws Exception {
        if (productService.deleteProduct(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
