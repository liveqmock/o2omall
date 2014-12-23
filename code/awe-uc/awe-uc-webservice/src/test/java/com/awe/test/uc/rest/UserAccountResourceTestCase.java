package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserAccountRequest;
import com.awe.test.uc.rest.request.dto.UserAccountRequestDto;
import com.awe.test.uc.rest.response.UserAccountResponse;
import com.awe.test.uc.rest.response.dto.UserAccountResponseDto;
import com.awe.test.uc.rest.Urls;

/**
 * UserAccountResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class UserAccountResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserAccount() {
        String url= Urls.API_DOMAIN + "/userAccount/getUserAccount";

        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setId(1l);
        UserAccountRequest request = new UserAccountRequest("key",requestDto);
        
        UserAccountResponse response = super.getRestTemplate().postForObject(url, request, UserAccountResponse.class);
        Assert.notNull(response);
        UserAccountResponseDto userAccountResponseDto = super.getResult(response);
        Assert.notNull(userAccountResponseDto);
    }
}
