package com.example.moneylion.controller;

import com.example.moneylion.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductServices services;

    @GetMapping(value = "/product/")
    public ResponseEntity getProduct(@RequestParam(name = "title") String title) {
        return ResponseEntity.ok(services.getProduct(title));
    }
}
