package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.OrderCancelRequest;
import com.awe.test.order.rest.request.dto.OrderCancelRequestDto;
import com.awe.test.order.rest.response.OrderCancelResponse;
import com.awe.test.order.rest.response.dto.OrderCancelResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * OrderCancelResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrderCancelResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetOrderCancel() {
        String url= Urls.API_DOMAIN + "/orderCancel/getOrderCancel";

        OrderCancelRequestDto requestDto = new OrderCancelRequestDto();
        requestDto.setId(1l);
        OrderCancelRequest request = new OrderCancelRequest("key",requestDto);
        
        OrderCancelResponse response = super.getRestTemplate().postForObject(url, request, OrderCancelResponse.class);
        Assert.notNull(response);
        OrderCancelResponseDto orderCancelResponseDto = super.getResult(response);
        Assert.notNull(orderCancelResponseDto);
    }
}
