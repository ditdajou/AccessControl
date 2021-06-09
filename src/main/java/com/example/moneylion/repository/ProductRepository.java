package com.example.moneylion.repository;
import com.example.moneylion.model.Product;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public class ProductRepository {
    private final MongoTemplate mongoTemplate;

    public ProductRepository(String databaseName, String mongoUri){
        MongoClientURI mongoClientURI = new MongoClientURI(mongoUri);
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, databaseName);
        this.mongoTemplate = new MongoTemplate(mongoDbFactory);
    }

    public Optional<Product> findById(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(productId));
        return Optional.ofNullable(mongoTemplate.findOne(query, Product.class));
    }
}