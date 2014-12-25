package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.ShoppingCartRequest;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;

/**
 * ShoppingCartClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:29:38
 * 
 */
public class ShoppingCartClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private ShoppingCartClient client;

    @Before
    public void init() throws Exception {
        client = new ShoppingCartClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetShoppingCart() {
        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setId(1l);
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponseDto shoppingCartResponseDto = client.getShoppingCart(request);
        Assert.notNull(shoppingCartResponseDto);
    } 

}
