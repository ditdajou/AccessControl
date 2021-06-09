package com.example.moneylion.services;

import com.example.moneylion.model.Product;
import com.example.moneylion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    ProductRepository productRepository;

    public Optional<Product> getProduct(String id){
        return productRepository.findById(id);
    }
}
