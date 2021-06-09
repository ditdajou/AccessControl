package com.example.moneylion.config;

import com.example.moneylion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    public ProductRepository productRepository(@Value("${product.database.name}") String databaseName, @Value("${product.mongouri}") String mongoUri) {
        return new ProductRepository(databaseName, mongoUri);
    }
}
