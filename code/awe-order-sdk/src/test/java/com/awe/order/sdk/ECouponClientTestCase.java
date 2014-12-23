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
 * @author lijianzhong
 * 
 */
public class ECouponClientTestCase {
    String WS_DOMAIN = "http://dev.orderws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.orderws.shop.hbird.com:8090/";
    private ECouponClient client;

    @Before
    public void init() {
        client = new ECouponClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetECoupon() {
        ECouponRequestDto requestDto = new ECouponRequestDto();
        requestDto.setId(1l);
        ECouponRequest request = new ECouponRequest("key",requestDto);
        
        ECouponResponseDto eCouponResponseDto = client.getECoupon(request);
        Assert.notNull(eCouponResponseDto);
    } 

}
