package com.awe.test.uc.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserAddressRequest;
import com.awe.test.uc.rest.request.dto.UserAddressRequestDto;
import com.awe.test.uc.rest.response.UserAddressResponse;
import com.awe.test.uc.rest.response.dto.UserAddressResponseDto;

/**
 * UserAddressResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:23:47
 * 
 */
public class UserAddressResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetUserAddress() {
        String url= getServiceUrlDomain() + "/userAddress/getUserAddress";

        UserAddressRequestDto requestDto = new UserAddressRequestDto();
        requestDto.setId(1l);
        UserAddressRequest request = new UserAddressRequest("uc",requestDto);
        
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);
        Assert.notNull(response);
        UserAddressResponseDto userAddressResponseDto = super.getResult(response);
        Assert.notNull(userAddressResponseDto);
    }
}
