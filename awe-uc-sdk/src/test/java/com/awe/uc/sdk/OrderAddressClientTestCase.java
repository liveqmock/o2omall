package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.response.dto.OrderAddressDto;
import com.awe.uc.sdk.request.OrderAddressRequest;

/**
 * OrderAddressClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class OrderAddressClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private OrderAddressClient client;

    @Before
    public void init() {
        client = new OrderAddressClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetOrderAddress() {
        OrderAddressRequest request = new OrderAddressRequest();
        request.setId(1L);
        OrderAddressDto orderAddressDto = client.getOrderAddress(request);
        Assert.notNull(orderAddressDto);
    } 

}
