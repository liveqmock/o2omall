package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.order.rest.request.OrdersItemsRequest;
import com.awe.test.order.rest.request.dto.OrdersItemsRequestDto;
import com.awe.test.order.rest.response.OrdersItemsResponse;
import com.awe.test.order.rest.response.dto.OrdersItemsResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * OrdersItemsResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class OrdersItemsResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetOrdersItems() {
        String url= getServiceUrlDomain() + "/ordersItems/getOrdersItems";

        OrdersItemsRequestDto requestDto = new OrdersItemsRequestDto();
        requestDto.setId(1l);
        OrdersItemsRequest request = new OrdersItemsRequest("order",requestDto);
        
        OrdersItemsResponse response = super.getRestTemplate().postForObject(url, request, OrdersItemsResponse.class);
        Assert.notNull(response);
        OrdersItemsResponseDto ordersItemsResponseDto = super.getResult(response);
        Assert.notNull(ordersItemsResponseDto);
    }
}
