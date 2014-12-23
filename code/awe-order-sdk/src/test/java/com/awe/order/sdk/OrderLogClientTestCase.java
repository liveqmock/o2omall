package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.OrderLogRequest;
import com.awe.order.sdk.request.dto.OrderLogRequestDto;
import com.awe.order.sdk.response.dto.OrderLogResponseDto;

/**
 * OrderLogClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class OrderLogClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrderLogClient client;

    @Before
    public void init() {
        client = new OrderLogClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetOrderLog() {
        OrderLogRequestDto requestDto = new OrderLogRequestDto();
        requestDto.setId(1l);
        OrderLogRequest request = new OrderLogRequest("key",requestDto);
        
        OrderLogResponseDto orderLogResponseDto = client.getOrderLog(request);
        Assert.notNull(orderLogResponseDto);
    } 

}
