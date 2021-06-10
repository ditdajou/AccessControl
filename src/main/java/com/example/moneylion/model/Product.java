package com.example.moneylion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Product {
    @Id
    private ObjectId id = new ObjectId();
    private String title;
    private String type;
    private String description;
    private String filename;
    private double height;
    private double width;
    private double price;
    private int rating;
}