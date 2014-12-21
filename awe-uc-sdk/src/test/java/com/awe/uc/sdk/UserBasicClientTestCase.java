package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.response.dto.UserBasicDto;
import com.awe.uc.sdk.request.UserBasicRequest;

/**
 * UserBasicClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class UserBasicClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserBasicClient client;

    @Before
    public void init() {
        client = new UserBasicClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserBasic() {
        UserBasicRequest request = new UserBasicRequest();
        request.setId(1L);
        UserBasicDto userBasicDto = client.getUserBasic(request);
        Assert.notNull(userBasicDto);
    } 

}
