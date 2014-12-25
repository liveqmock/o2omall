package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.dto.ECouponRequestDto;
import com.awe.order.sdk.response.dto.ECouponResponseDto;

/**
 * ECouponClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class ECouponClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private ECouponClient client;

    @Before
    public void init() throws Exception {
        client = new ECouponClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("order");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetECoupon() {
        ECouponRequestDto requestDto = new ECouponRequestDto();
        requestDto.setId(1l);
        
        ECouponResponseDto eCouponResponseDto = client.getECoupon(requestDto);
        Assert.notNull(eCouponResponseDto);
    } 

}
