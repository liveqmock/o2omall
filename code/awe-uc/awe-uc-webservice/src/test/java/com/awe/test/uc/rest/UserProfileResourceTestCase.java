package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserProfileRequest;
import com.awe.test.uc.rest.request.dto.UserProfileRequestDto;
import com.awe.test.uc.rest.response.UserProfileResponse;
import com.awe.test.uc.rest.response.dto.UserProfileResponseDto;
import com.awe.test.uc.rest.Urls;

/**
 * UserProfileResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserProfileResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserProfile() {
        String url= Urls.API_DOMAIN + "/userProfile/getUserProfile";

        UserProfileRequestDto requestDto = new UserProfileRequestDto();
        requestDto.setId(1l);
        UserProfileRequest request = new UserProfileRequest("key",requestDto);
        
        UserProfileResponse response = super.getRestTemplate().postForObject(url, request, UserProfileResponse.class);
        Assert.notNull(response);
        UserProfileResponseDto userProfileResponseDto = super.getResult(response);
        Assert.notNull(userProfileResponseDto);
    }
}
