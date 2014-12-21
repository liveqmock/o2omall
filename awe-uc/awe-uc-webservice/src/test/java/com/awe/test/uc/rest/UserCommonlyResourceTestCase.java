package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.dto.UserCommonly;
import com.awe.test.uc.rest.request.UserCommonlyRequest;
import com.awe.test.uc.rest.response.UserCommonlyResponse;
import com.awe.test.uc.rest.Urls;

/**
 * UserCommonlyResource单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class UserCommonlyResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserCommonly() {
        String url= Urls.API_DOMAIN + "/userCommonly/getUserCommonly";

        UserCommonlyRequest request = new UserCommonlyRequest();
        request.setId(1l);
        UserCommonlyResponse response = super.getRestTemplate().postForObject(url, request, UserCommonlyResponse.class);
        Assert.notNull(response);
        UserCommonly userCommonly = super.getResult(response);
        Assert.notNull(userCommonly);
    }
}
