package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;

/**
 * OrderCancelClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrderCancelClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrderCancelClient client;

    @Before
    public void init() throws Exception {
        client = new OrderCancelClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("order");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetOrderCancel() {
        OrderCancelRequestDto requestDto = new OrderCancelRequestDto();
        requestDto.setId(1l);
        
        OrderCancelResponseDto orderCancelResponseDto = client.getOrderCancel(requestDto);
        Assert.notNull(orderCancelResponseDto);
    } 

}
