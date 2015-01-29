package com.awe.test.order.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.order.rest.request.ShoppingCartRequest;
import com.awe.test.order.rest.request.dto.ShoppingCartRequestDto;
import com.awe.test.order.rest.response.ShoppingCartResponse;
import com.awe.test.order.rest.response.ShoppingCartResponseList;
import com.awe.test.order.rest.response.dto.ShoppingCartResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.wrap.WrapMapper;

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
    
    /**
     * 购物车列表数据获取
     * @result : 测试通过
     */
    @Test
    public void testQueryShoppingCartList(){
    	String url= getServiceUrlDomain() + "/shoppingCart/queryShoppingCartList";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setUserId(1L);
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponseList responseList = super.getRestTemplate().postForObject(url, request, ShoppingCartResponseList.class);
        Assert.notNull(responseList);
        List<ShoppingCartResponseDto> shoppingCartResponseDtoList = super.getResult(responseList);
        Assert.notNull(shoppingCartResponseDtoList);
    }
    /**
     * 删除购物车指定商品数据
     * @result : 测试通过
     */
    @Test
    public void deleteShoppingCartById(){
    	String url= getServiceUrlDomain() + "/shoppingCart/deleteShoppingCartById";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setId(1l);
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        Assert.isTrue(WrapMapper.ok().getMessage().equals(response.getMessage()));
    }
    /**
     * 添加购物车
     * @result : 测试通过
     */
    @Test
    public void addShoppingCart(){
    	String url= getServiceUrlDomain() + "/shoppingCart/addShoppingCart";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setSeller("好再来商家");
        requestDto.setSellerNo("120");
        requestDto.setSkuCount(1);
        requestDto.setSkuNo("1245214");
        requestDto.setStatus(1);
        requestDto.setUserId(2L);
        requestDto.setCreateUser("张三");
        requestDto.setUpdateUser("张三");
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        Assert.isTrue(WrapMapper.ok().getMessage().equals(response.getMessage()));
    }
    /**
     * 更新购物车数据
     * @result : 测试通过
     */
    @Test
    public void updateShoppingCart(){
    	String url= getServiceUrlDomain() + "/shoppingCart/updateShoppingCart";

        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setSkuNo("100010");
        requestDto.setSkuCount(100);
        ShoppingCartRequest request = new ShoppingCartRequest("order",requestDto);
        
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
        Assert.notNull(response);
        Assert.isTrue(WrapMapper.ok().getMessage().equals(response.getMessage()));
    }
}
