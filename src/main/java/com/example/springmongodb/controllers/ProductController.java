package com.example.springmongodb.controllers;


import com.example.springmongodb.models.Product;
import com.example.springmongodb.services.impl.ProductService;
import com.mongodb.MongoClientException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) throws MongoClientException {
        return productService.saveProduct(product);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}
