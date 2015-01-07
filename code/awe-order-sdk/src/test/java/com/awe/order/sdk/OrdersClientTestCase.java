package com.awe.order.sdk;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.OrdersDetailsRequest;
import com.awe.order.sdk.request.dto.OrderDetailsRequestDto;
import com.awe.order.sdk.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.OrderDetailsResponse;
import com.awe.order.sdk.response.dto.OrderDetailsResponseDto;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrdersClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrdersClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private OrdersClient client;

    @Before
    public void init() throws Exception {
        client = new OrdersClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("order");
        client.setConnectTimeout(3000);
        client.setReadTimeout(30000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetOrders() {
        OrdersRequestDto requestDto = new OrdersRequestDto();
        requestDto.setId(1l);
        
        OrdersResponseDto ordersResponseDto = client.getOrders(requestDto);
        Assert.notNull(ordersResponseDto);
    } 
    
    /**
     * 添加订单接口
     * Date:2015年1月7日下午3:29:13
     * user:js
     */
    @Test
    public void testAddOrders(){
    	OrderDetailsRequestDto detailsRequestDto = new OrderDetailsRequestDto();
    	OrdersRequestDto dto =  new OrdersRequestDto();
    	List<OrdersItemsRequestDto> list = new ArrayList<OrdersItemsRequestDto>();
    	dto.setOrderNo("1234567890");
    	dto.setUserId(123456l);
    	dto.setOrderStatus(1);
    	dto.setOrderType(1);
    	dto.setOrderDate(2);
    	dto.setOrderName("贾赛");
    	dto.setCreateUser("王五");
    	detailsRequestDto.setOrdersRequestDto(dto);
    	
    	for(int i=0;i<5;i++){
    	OrdersItemsRequestDto dto2 = new OrdersItemsRequestDto();
    	dto2.setCount(2);
    	dto2.setCreateUser("xxx"+i);
    	dto2.setSkuName("奶粉"+i);
    	dto2.setSkuNo("999999");
    	dto2.setSkuPrice(45.66);
    	dto2.setProductNo("6666");
    	list.add(dto2);
    	}
    	detailsRequestDto.setListOrdersItemsRequestDto(list);
    	
    	Wrapper<?> wrapper= client.addOrdersDetails(detailsRequestDto);
    	
    }

}
