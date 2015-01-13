package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.order.rest.request.OrdersRequest;
import com.awe.test.order.rest.request.dto.OrdersRequestDto;
import com.awe.test.order.rest.response.OrdersResponse;
import com.awe.test.order.rest.response.OrdersResponseList;
import com.awe.test.order.rest.response.dto.OrdersResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.page.PageUtil;

/**
 * OrdersResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class OrdersResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetOrders() {
        String url= getServiceUrlDomain() + "/orders/getOrders";

        OrdersRequestDto requestDto = new OrdersRequestDto();
        requestDto.setId(1l);
        OrdersRequest request = new OrdersRequest("order",requestDto);
        
        OrdersResponse response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);
        Assert.notNull(response);
        OrdersResponseDto ordersResponseDto = super.getResult(response);
        Assert.notNull(ordersResponseDto);
    }
    
    @Test
    public void queryFrontOrdersListWithPage(){
    	String url= getServiceUrlDomain() + "/orders/queryFrontOrdersListWithPage";

        OrdersRequestDto requestDto = new OrdersRequestDto();
        requestDto.setOrderNo("1");
        PageUtil page = new PageUtil();
        page.setPageSize(10);
        page.setCurPage(0);
        OrdersRequest request = new OrdersRequest("order",requestDto);
        request.setPageUtil(page);
        OrdersResponseList responseList = super.getRestTemplate().postForObject(url, request, OrdersResponseList.class);
        Assert.notNull(responseList);
        
    }
}
