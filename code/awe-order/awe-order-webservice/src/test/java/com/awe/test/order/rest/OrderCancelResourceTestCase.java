package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.order.rest.request.OrderCancelRequest;
import com.awe.test.order.rest.request.dto.OrderCancelRequestDto;
import com.awe.test.order.rest.response.OrderCancelResponse;
import com.awe.test.order.rest.response.dto.OrderCancelResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * OrderCancelResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class OrderCancelResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetOrderCancel() {
        String url= getServiceUrlDomain() + "/orderCancel/getOrderCancel";

        OrderCancelRequestDto requestDto = new OrderCancelRequestDto();
        requestDto.setId(1l);
        OrderCancelRequest request = new OrderCancelRequest("order",requestDto);
        
        OrderCancelResponse response = super.getRestTemplate().postForObject(url, request, OrderCancelResponse.class);
        Assert.notNull(response);
        OrderCancelResponseDto orderCancelResponseDto = super.getResult(response);
        Assert.notNull(orderCancelResponseDto);
    }
}
