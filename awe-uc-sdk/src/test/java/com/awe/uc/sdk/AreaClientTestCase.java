package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.response.dto.AreaDto;
import com.awe.uc.sdk.request.AreaRequest;

/**
 * AreaClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class AreaClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private AreaClient client;

    @Before
    public void init() {
        client = new AreaClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetArea() {
        AreaRequest request = new AreaRequest();
        request.setId(1L);
        AreaDto areaDto = client.getArea(request);
        Assert.notNull(areaDto);
    } 

}
