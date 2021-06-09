package com.example.moneylion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ModifyAccessRequest {
    @NotNull
    private String featureName;
    @NotNull
    private String email;
    @NotNull
    private boolean enable;
}
