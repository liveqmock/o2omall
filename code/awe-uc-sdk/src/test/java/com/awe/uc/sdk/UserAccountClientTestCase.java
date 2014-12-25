package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.UserAccountRequest;
import com.awe.uc.sdk.request.dto.UserAccountRequestDto;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;

/**
 * UserAccountClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:23:48
 * 
 */
public class UserAccountClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserAccountClient client;

    @Before
    public void init() throws Exception {
        client = new UserAccountClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetUserAccount() {
        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setId(1l);
        UserAccountRequest request = new UserAccountRequest("uc",requestDto);
        
        UserAccountResponseDto userAccountResponseDto = client.getUserAccount(request);
        Assert.notNull(userAccountResponseDto);
    } 

}
