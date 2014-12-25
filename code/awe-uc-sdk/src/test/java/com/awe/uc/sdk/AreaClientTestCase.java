package com.awe.uc.sdk;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.AreaRequest;
import com.awe.uc.sdk.request.dto.AreaRequestDto;
import com.awe.uc.sdk.response.dto.AreaResponseDto;

/**
 * AreaClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class AreaClientTestCase {
    // String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private AreaClient client;

    @Before
    public void init() throws Exception {
        client = new AreaClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetArea() {
        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setId(1l);
        AreaRequest request = new AreaRequest("uc", requestDto);

        List<AreaResponseDto> areaResponseDtos = client.getArea(request);
        Assert.notEmpty(areaResponseDtos);
    }

}
