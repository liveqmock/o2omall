package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.UserAddressRequest;
import com.awe.test.uc.rest.request.dto.UserAddressRequestDto;
import com.awe.test.uc.rest.response.UserAddressResponse;
import com.awe.test.uc.rest.response.dto.UserAddressResponseDto;
import com.awe.test.uc.rest.Urls;

/**
 * UserAddressResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class UserAddressResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserAddress() {
        String url= Urls.API_DOMAIN + "/userAddress/getUserAddress";

        UserAddressRequestDto requestDto = new UserAddressRequestDto();
        requestDto.setId(1l);
        UserAddressRequest request = new UserAddressRequest("key",requestDto);
        
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);
        Assert.notNull(response);
        UserAddressResponseDto userAddressResponseDto = super.getResult(response);
        Assert.notNull(userAddressResponseDto);
    }
}
