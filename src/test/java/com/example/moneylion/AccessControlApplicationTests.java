package com.example.moneylion;

import com.example.moneylion.controller.AccessControlController;
import com.example.moneylion.model.GetAccessDetailsResponse;
import com.example.moneylion.model.ModifyAccessRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class AccessControlControllerTests {
    @Autowired
    AccessControlController subject;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void modifyAccess_getAccessDetails_positive_test_1() {
        ModifyAccessRequest modifyRequest = new ModifyAccessRequest();
        modifyRequest.setEmail("JackYap@outlook.com");
        modifyRequest.setFeatureName("APPLY_LOAN");
        modifyRequest.setEnable(true);
        ResponseEntity modifyResponse = subject.modifyAccess(modifyRequest);
        Assert.assertSame(modifyResponse.getStatusCode(), HttpStatus.OK);

        GetAccessDetailsResponse getDetailResponse =
                (GetAccessDetailsResponse) subject.getAccessDetails("jackyap@outlook.com","APPLY_LOAN").getBody();
        Assert.assertSame(getDetailResponse.isCanAccess(), true);

        //modify access to false
        modifyRequest.setEnable(false);
        subject.modifyAccess(modifyRequest);
        getDetailResponse =
                (GetAccessDetailsResponse) subject.getAccessDetails("jackyap@outlook.com","APPLY_LOAN").getBody();
        Assert.assertSame(getDetailResponse.isCanAccess(), false);
    }

    @Test
    void modifyAccess_getAccessDetails_negative_test_1() {
        ModifyAccessRequest modifyRequest = new ModifyAccessRequest();
        modifyRequest.setEmail("jackyap@outlook.com");
        modifyRequest.setFeatureName("APPLY_LOAN2");
        modifyRequest.setEnable(true);
        ResponseEntity modifyResponse = subject.modifyAccess(modifyRequest);
        Assert.assertSame(modifyResponse.getStatusCode(), HttpStatus.NOT_MODIFIED);
    }

    @Test
    void modifyAccess_getAccessDetails_negative_test_2() {
        ModifyAccessRequest modifyRequest = new ModifyAccessRequest();
        modifyRequest.setEmail("jackyap@outlook.com");
        modifyRequest.setFeatureName("APPLY_LOAN");
        modifyRequest.setEnable(true);
        ResponseEntity modifyResponse = subject.modifyAccess(modifyRequest);
        Assert.assertSame(modifyResponse.getStatusCode(), HttpStatus.OK);

        GetAccessDetailsResponse getDetailResponse =
                (GetAccessDetailsResponse) subject.getAccessDetails("jackyap@outlook.com3","APPLY_LOAN").getBody();
        Assert.assertSame(getDetailResponse.isCanAccess(), false);
    }

}
