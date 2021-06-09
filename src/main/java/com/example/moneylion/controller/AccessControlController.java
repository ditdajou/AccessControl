package com.example.moneylion.controller;


import com.example.moneylion.model.ModifyAccessRequest;
import com.example.moneylion.services.AccessControlServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccessControlController {
    @Autowired
    AccessControlServices services;

    @GetMapping(value = "/features")
    public ResponseEntity getAccessDetails() {
        return ResponseEntity.ok(services.getAccessDetails());
    }

    @GetMapping(value = "/feature")
    public ResponseEntity getAccessDetails(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "featureName") String featureName
    ) {
        return ResponseEntity.ok(services.getAccessDetails(email, featureName));
    }

    @PostMapping(value = "/feature")
    public ResponseEntity modifyAccess(
            @Valid @RequestBody ModifyAccessRequest request
    ) {
        return new ResponseEntity<>(services.modifyAccess(request));
    }
}
