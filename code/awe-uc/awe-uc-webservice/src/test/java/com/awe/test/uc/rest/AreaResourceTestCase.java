package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.AreaRequest;
import com.awe.test.uc.rest.request.dto.AreaRequestDto;
import com.awe.test.uc.rest.response.AreaResponse;
import com.awe.test.uc.rest.response.dto.AreaResponseDto;
import com.awe.test.uc.rest.Urls;

/**
 * AreaResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class AreaResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetArea() {
        String url= Urls.API_DOMAIN + "/area/getArea";

        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setId(1l);
        AreaRequest request = new AreaRequest("key",requestDto);
        
        AreaResponse response = super.getRestTemplate().postForObject(url, request, AreaResponse.class);
        Assert.notNull(response);
        AreaResponseDto areaResponseDto = super.getResult(response);
        Assert.notNull(areaResponseDto);
    }
}
