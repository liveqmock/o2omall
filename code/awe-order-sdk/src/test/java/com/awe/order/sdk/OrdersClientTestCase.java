package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.dto.OrdersResponseDto;

/**
 * OrdersClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrdersClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrdersClient client;

    @Before
    public void init() throws Exception {
        client = new OrdersClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("order");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetOrders() {
        OrdersRequestDto requestDto = new OrdersRequestDto();
        requestDto.setId(1l);
        
        OrdersResponseDto ordersResponseDto = client.getOrders(requestDto);
        Assert.notNull(ordersResponseDto);
    } 

}
