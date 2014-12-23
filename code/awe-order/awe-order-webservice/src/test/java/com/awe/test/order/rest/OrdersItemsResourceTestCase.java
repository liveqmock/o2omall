package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.OrdersItemsRequest;
import com.awe.test.order.rest.request.dto.OrdersItemsRequestDto;
import com.awe.test.order.rest.response.OrdersItemsResponse;
import com.awe.test.order.rest.response.dto.OrdersItemsResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * OrdersItemsResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrdersItemsResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetOrdersItems() {
        String url= Urls.API_DOMAIN + "/ordersItems/getOrdersItems";

        OrdersItemsRequestDto requestDto = new OrdersItemsRequestDto();
        requestDto.setId(1l);
        OrdersItemsRequest request = new OrdersItemsRequest("key",requestDto);
        
        OrdersItemsResponse response = super.getRestTemplate().postForObject(url, request, OrdersItemsResponse.class);
        Assert.notNull(response);
        OrdersItemsResponseDto ordersItemsResponseDto = super.getResult(response);
        Assert.notNull(ordersItemsResponseDto);
    }
}
