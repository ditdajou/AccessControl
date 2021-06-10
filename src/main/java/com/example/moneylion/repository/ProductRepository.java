package com.example.moneylion.repository;

import com.example.moneylion.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findByTitle(String title);

}