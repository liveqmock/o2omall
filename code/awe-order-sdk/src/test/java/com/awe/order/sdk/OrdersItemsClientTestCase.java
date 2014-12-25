package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.OrdersItemsRequest;
import com.awe.order.sdk.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.response.dto.OrdersItemsResponseDto;

/**
 * OrdersItemsClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:29:38
 * 
 */
public class OrdersItemsClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrdersItemsClient client;

    @Before
    public void init() throws Exception {
        client = new OrdersItemsClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetOrdersItems() {
        OrdersItemsRequestDto requestDto = new OrdersItemsRequestDto();
        requestDto.setId(1l);
        OrdersItemsRequest request = new OrdersItemsRequest("order",requestDto);
        
        OrdersItemsResponseDto ordersItemsResponseDto = client.getOrdersItems(request);
        Assert.notNull(ordersItemsResponseDto);
    } 

}
