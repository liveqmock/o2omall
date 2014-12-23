package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.OrdersRequest;
import com.awe.test.order.rest.request.dto.OrdersRequestDto;
import com.awe.test.order.rest.response.OrdersResponse;
import com.awe.test.order.rest.response.dto.OrdersResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * OrdersResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrdersResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetOrders() {
        String url= Urls.API_DOMAIN + "/orders/getOrders";

        OrdersRequestDto requestDto = new OrdersRequestDto();
        requestDto.setId(1l);
        OrdersRequest request = new OrdersRequest("key",requestDto);
        
        OrdersResponse response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);
        Assert.notNull(response);
        OrdersResponseDto ordersResponseDto = super.getResult(response);
        Assert.notNull(ordersResponseDto);
    }
}
