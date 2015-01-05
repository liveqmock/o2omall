package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.order.rest.request.ShoppingCartRequest;
import com.awe.test.order.rest.request.dto.ShoppingCartRequestDto;
import com.awe.test.order.rest.response.ShoppingCartResponse;
import com.awe.test.order.rest.response.dto.ShoppingCartResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ShoppingCartResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class ShoppingCartResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetShoppingCart() {
        String url= getServiceUrlDomain() + "/shoppingCart/getShoppingCart";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setId(1l);
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        ShoppingCartResponseDto shoppingCartResponseDto = super.getResult(response);
        Assert.notNull(shoppingCartResponseDto);
    }
    
    @Test
    public void testQueryShoppingCartList() {
        String url= getServiceUrlDomain() + "/shoppingCart/queryShoppingCartList";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setUserNo("1");
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        ShoppingCartResponseDto shoppingCartResponseDto = super.getResult(response);
        Assert.notNull(shoppingCartResponseDto);
    }
}
