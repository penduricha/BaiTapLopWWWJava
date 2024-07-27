package com.example.springmongodb.services.impl;

import com.example.springmongodb.models.Product;
import com.example.springmongodb.repositories.ProductRepository;
import com.example.springmongodb.services.I_ProductService;
import com.mongodb.MongoClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements I_ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws MongoClientException {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "productId"));
        //DESC la giam
    }

    @Override
    public Product saveProduct(Product product) throws MongoClientException {
        return productRepository.save(product);
    }
}
