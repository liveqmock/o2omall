package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.ShoppingCartRequest;
import com.awe.test.order.rest.request.dto.ShoppingCartRequestDto;
import com.awe.test.order.rest.response.ShoppingCartResponse;
import com.awe.test.order.rest.response.dto.ShoppingCartResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * ShoppingCartResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:38
 * 
 */
public class ShoppingCartResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetShoppingCart() {
        String url= Urls.API_DOMAIN + "/shoppingCart/getShoppingCart";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setId(1l);
        ShoppingCartRequest request = new ShoppingCartRequest("key",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        ShoppingCartResponseDto shoppingCartResponseDto = super.getResult(response);
        Assert.notNull(shoppingCartResponseDto);
    }
}
