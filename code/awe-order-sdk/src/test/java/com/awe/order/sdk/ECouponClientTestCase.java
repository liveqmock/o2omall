package com.awe.order.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.ECouponRequest;
import com.awe.order.sdk.request.dto.ECouponRequestDto;
import com.awe.order.sdk.response.dto.ECouponResponseDto;

/**
 * ECouponClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:29:38
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
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetECoupon() {
        ECouponRequestDto requestDto = new ECouponRequestDto();
        requestDto.setId(1l);
        ECouponRequest request = new ECouponRequest("order",requestDto);
        
        ECouponResponseDto eCouponResponseDto = client.getECoupon(request);
        Assert.notNull(eCouponResponseDto);
    } 

}
