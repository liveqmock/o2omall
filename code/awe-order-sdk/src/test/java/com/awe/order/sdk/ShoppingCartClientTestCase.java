package com.awe.order.sdk;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ShoppingCartClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class ShoppingCartClientTestCase {
	//String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
     String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8200/";
    private ShoppingCartClient client;

    @Before
    public void init() throws Exception {
        client = new ShoppingCartClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("order");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }
    /**
     * 购物车列表数据获取
     */
    @Test
    public void testGetShoppingCart() {
        ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setId(1l);
        
        ShoppingCartResponseDto shoppingCartResponseDto = client.getShoppingCart(requestDto);
        Assert.notNull(shoppingCartResponseDto);
    } 
    /**
     * 删除购物车指定商品数据
     */
    @Test
    public void deleteShoppingCart(){
    	ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setSkuNo("1");
        
        Wrapper<?> wrapper = client.deleteShoppingCart(requestDto);
        Assert.isTrue(WrapMapper.ok().getMessage().equals(wrapper.getMessage()));
    }
    /**
     * 添加购物车
     */
    @Test
    public void addShoppingCart(){
    	ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
        requestDto.setSeller("好再来商家");
        requestDto.setSellerNo("120");
        requestDto.setSkuCount(1);
        requestDto.setSkuNo("1245214");
        requestDto.setStatus(1);
        requestDto.setUserId(5L);
        requestDto.setCreateUser("张三");
        requestDto.setUpdateUser("张三");
        Wrapper<?> wrapper = client.addShoppingCart(requestDto);
        Assert.isTrue(WrapMapper.ok().getMessage().equals(wrapper.getMessage()));
    }
    /**
     * 购物车列表数据获取
     */
    @Test
    public void queryShoppingCartList(){
    	ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
    	requestDto.setUserId(1L);
    	List<ShoppingCartResponseDto> responseDtoList = client.queryShoppingCartList(requestDto);
    	Assert.notNull(responseDtoList);
    }
}
