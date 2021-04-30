package com.example.moneylion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GetAccessDetailsResponse implements Serializable {
    private boolean canAccess;
}