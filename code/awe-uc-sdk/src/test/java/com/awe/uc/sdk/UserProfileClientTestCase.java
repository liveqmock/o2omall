package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;

/**
 * UserProfileClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:48:02
 * 
 */
public class UserProfileClientTestCase {
    //String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
     String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8100/";
    private UserProfileClient client;

    @Before
    public void init() throws Exception {
        client = new UserProfileClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("uc");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetUserProfile() {
        UserProfileRequestDto requestDto = new UserProfileRequestDto();
        requestDto.setId(1l);
        
        UserProfileResponseDto userProfileResponseDto = client.getUserProfile(requestDto);
        Assert.notNull(userProfileResponseDto);
    } 

}
