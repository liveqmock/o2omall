package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.OrderLogRequest;
import com.awe.test.order.rest.request.dto.OrderLogRequestDto;
import com.awe.test.order.rest.response.OrderLogResponse;
import com.awe.test.order.rest.response.dto.OrderLogResponseDto;

/**
 * OrderLogResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class OrderLogResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetOrderLog() {
        String url= getServiceUrlDomain() + "/orderLog/getOrderLog";

        OrderLogRequestDto requestDto = new OrderLogRequestDto();
        requestDto.setId(1l);
        OrderLogRequest request = new OrderLogRequest("order",requestDto);
        
        OrderLogResponse response = super.getRestTemplate().postForObject(url, request, OrderLogResponse.class);
        Assert.notNull(response);
        OrderLogResponseDto orderLogResponseDto = super.getResult(response);
        Assert.notNull(orderLogResponseDto);
    }
}
