package com.awe.test.uc.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserAccountRequest;
import com.awe.test.uc.rest.request.dto.UserAccountRequestDto;
import com.awe.test.uc.rest.response.UserAccountResponse;
import com.awe.test.uc.rest.response.dto.UserAccountResponseDto;

/**
 * UserAccountResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:23:47
 * 
 */
public class UserAccountResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetUserAccount() {
        String url= getServiceUrlDomain() + "/userAccount/getUserAccount";

        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setId(1l);
        UserAccountRequest request = new UserAccountRequest("uc",requestDto);
        
        UserAccountResponse response = super.getRestTemplate().postForObject(url, request, UserAccountResponse.class);
        Assert.notNull(response);
        UserAccountResponseDto userAccountResponseDto = super.getResult(response);
        Assert.notNull(userAccountResponseDto);
    }
}
