package com.example.moneylion.services;

import com.example.moneylion.model.GetAccessDetailsResponse;
import com.example.moneylion.model.ModifyAccessRequest;
import com.example.moneylion.repository.AccessControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccessControlServices {

    @Autowired
    AccessControlRepository repository;

    public GetAccessDetailsResponse getAccessDetails(String email, String featureName) {
        boolean canAccess = repository.getAccessDetails(email, featureName);
        return new GetAccessDetailsResponse(canAccess);
    }

    public HttpStatus modifyAccess(ModifyAccessRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        if (repository.modifyAccess(request.getFeatureName(), request.getEmail(), request.isEnable()) == 1) {
            httpStatus = HttpStatus.OK;
        }
        return httpStatus;
    }
}
