package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.OrderLogRequest;
import com.awe.test.order.rest.request.dto.OrderLogRequestDto;
import com.awe.test.order.rest.response.OrderLogResponse;
import com.awe.test.order.rest.response.dto.OrderLogResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * OrderLogResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrderLogResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetOrderLog() {
        String url= Urls.API_DOMAIN + "/orderLog/getOrderLog";

        OrderLogRequestDto requestDto = new OrderLogRequestDto();
        requestDto.setId(1l);
        OrderLogRequest request = new OrderLogRequest("key",requestDto);
        
        OrderLogResponse response = super.getRestTemplate().postForObject(url, request, OrderLogResponse.class);
        Assert.notNull(response);
        OrderLogResponseDto orderLogResponseDto = super.getResult(response);
        Assert.notNull(orderLogResponseDto);
    }
}
