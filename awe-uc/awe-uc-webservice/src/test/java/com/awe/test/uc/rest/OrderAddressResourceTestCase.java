package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.dto.OrderAddress;
import com.awe.test.uc.rest.request.OrderAddressRequest;
import com.awe.test.uc.rest.response.OrderAddressResponse;
import com.awe.test.uc.rest.Urls;

/**
 * OrderAddressResource单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class OrderAddressResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetOrderAddress() {
        String url= Urls.API_DOMAIN + "/orderAddress/getOrderAddress";

        OrderAddressRequest request = new OrderAddressRequest();
        request.setId(1l);
        OrderAddressResponse response = super.getRestTemplate().postForObject(url, request, OrderAddressResponse.class);
        Assert.notNull(response);
        OrderAddress orderAddress = super.getResult(response);
        Assert.notNull(orderAddress);
    }
}
