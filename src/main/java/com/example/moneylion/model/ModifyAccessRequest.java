package com.example.moneylion.model;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class ModifyAccessRequest {
    @NotNull
    private String featureName;
    @NotNull
    private String email;
    @NotNull
    private boolean enable;
}
