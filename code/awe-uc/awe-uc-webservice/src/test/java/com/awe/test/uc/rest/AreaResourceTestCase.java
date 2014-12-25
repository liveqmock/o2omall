package com.awe.test.uc.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.request.AreaRequest;
import com.awe.test.uc.rest.request.dto.AreaRequestDto;
import com.awe.test.uc.rest.response.AreaResponse;
import com.awe.test.uc.rest.response.dto.AreaResponseDto;

/**
 * AreaResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class AreaResourceTestCase extends AbstractClient {

    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }

    @Test
    public void testGetArea() {
        String url = getServiceUrlDomain() + "/area/getArea";

        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setId(1l);
        AreaRequest request = new AreaRequest("uc", requestDto);

        AreaResponse response = super.getRestTemplate().postForObject(url, request, AreaResponse.class);
        Assert.notNull(response);
        List<AreaResponseDto> areaResponseDtos = super.getResult(response);
        Assert.notEmpty(areaResponseDtos);
    }
}
