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
 * @author lijianzhong
 * 
 */
public class OrdersItemsClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrdersItemsClient client;

    @Before
    public void init() {
        client = new OrdersItemsClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetOrdersItems() {
        OrdersItemsRequestDto requestDto = new OrdersItemsRequestDto();
        requestDto.setId(1l);
        OrdersItemsRequest request = new OrdersItemsRequest("key",requestDto);
        
        OrdersItemsResponseDto ordersItemsResponseDto = client.getOrdersItems(request);
        Assert.notNull(ordersItemsResponseDto);
    } 

}
