package com.example.springmongodb.services;

import com.example.springmongodb.models.Product;

import java.util.List;

public interface I_ProductService {
    public List<Product> getAllProducts();
    public Product saveProduct(Product product);
}
