package com.example.moneylion.services;

import com.example.moneylion.model.Product;
import com.example.moneylion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(String title){
        return productRepository.findByTitle(title);
    }
}
