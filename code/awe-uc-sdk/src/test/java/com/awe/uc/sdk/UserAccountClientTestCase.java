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
 * @author lijianzhong
 * 
 */
public class UserAccountClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserAccountClient client;

    @Before
    public void init() {
        client = new UserAccountClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserAccount() {
        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setId(1l);
        UserAccountRequest request = new UserAccountRequest("key",requestDto);
        
        UserAccountResponseDto userAccountResponseDto = client.getUserAccount(request);
        Assert.notNull(userAccountResponseDto);
    } 

}
