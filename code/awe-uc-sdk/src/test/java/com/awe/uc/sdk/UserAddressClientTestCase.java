package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.UserAddressRequest;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;

/**
 * UserAddressClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class UserAddressClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserAddressClient client;

    @Before
    public void init() {
        client = new UserAddressClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserAddress() {
        UserAddressRequestDto requestDto = new UserAddressRequestDto();
        requestDto.setId(1l);
        UserAddressRequest request = new UserAddressRequest("key",requestDto);
        
        UserAddressResponseDto userAddressResponseDto = client.getUserAddress(request);
        Assert.notNull(userAddressResponseDto);
    } 

}
