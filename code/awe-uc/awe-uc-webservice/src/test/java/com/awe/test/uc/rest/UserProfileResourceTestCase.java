package com.awe.test.uc.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserProfileRequest;
import com.awe.test.uc.rest.request.dto.UserProfileRequestDto;
import com.awe.test.uc.rest.response.UserProfileResponse;
import com.awe.test.uc.rest.response.dto.UserProfileResponseDto;

/**
 * UserProfileResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:23:47
 * 
 */
public class UserProfileResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetUserProfile() {
        String url= getServiceUrlDomain() + "/userProfile/getUserProfile";

        UserProfileRequestDto requestDto = new UserProfileRequestDto();
        requestDto.setId(1l);
        UserProfileRequest request = new UserProfileRequest("uc",requestDto);
        
        UserProfileResponse response = super.getRestTemplate().postForObject(url, request, UserProfileResponse.class);
        Assert.notNull(response);
        UserProfileResponseDto userProfileResponseDto = super.getResult(response);
        Assert.notNull(userProfileResponseDto);
    }
}
