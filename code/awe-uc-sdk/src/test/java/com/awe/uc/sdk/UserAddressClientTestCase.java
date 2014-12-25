package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;

/**
 * UserAddressClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:48:02
 * 
 */
public class UserAddressClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserAddressClient client;

    @Before
    public void init() throws Exception {
        client = new UserAddressClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("uc");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetUserAddress() {
        UserAddressRequestDto requestDto = new UserAddressRequestDto();
        requestDto.setId(1l);
        
        UserAddressResponseDto userAddressResponseDto = client.getUserAddress(requestDto);
        Assert.notNull(userAddressResponseDto);
    } 

}
