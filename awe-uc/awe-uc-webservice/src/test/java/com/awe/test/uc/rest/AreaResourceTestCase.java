package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.dto.Area;
import com.awe.test.uc.rest.request.AreaRequest;
import com.awe.test.uc.rest.response.AreaResponse;
import com.awe.test.uc.rest.Urls;

/**
 * AreaResource单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class AreaResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetArea() {
        String url= Urls.API_DOMAIN + "/area/getArea";

        AreaRequest request = new AreaRequest();
        request.setId(1l);
        AreaResponse response = super.getRestTemplate().postForObject(url, request, AreaResponse.class);
        Assert.notNull(response);
        Area area = super.getResult(response);
        Assert.notNull(area);
    }
}
