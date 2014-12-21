package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.response.dto.UserCommonlyDto;
import com.awe.uc.sdk.request.UserCommonlyRequest;

/**
 * UserCommonlyClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class UserCommonlyClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserCommonlyClient client;

    @Before
    public void init() {
        client = new UserCommonlyClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserCommonly() {
        UserCommonlyRequest request = new UserCommonlyRequest();
        request.setId(1L);
        UserCommonlyDto userCommonlyDto = client.getUserCommonly(request);
        Assert.notNull(userCommonlyDto);
    } 

}
