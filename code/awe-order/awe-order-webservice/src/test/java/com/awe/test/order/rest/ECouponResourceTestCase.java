package com.awe.test.order.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.ECouponRequest;
import com.awe.test.order.rest.request.dto.ECouponRequestDto;
import com.awe.test.order.rest.response.ECouponResponse;
import com.awe.test.order.rest.response.dto.ECouponResponseDto;
import com.awe.test.order.rest.Urls;

/**
 * ECouponResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class ECouponResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetECoupon() {
        String url= Urls.API_DOMAIN + "/eCoupon/getECoupon";

        ECouponRequestDto requestDto = new ECouponRequestDto();
        requestDto.setId(1l);
        ECouponRequest request = new ECouponRequest("key",requestDto);
        
        ECouponResponse response = super.getRestTemplate().postForObject(url, request, ECouponResponse.class);
        Assert.notNull(response);
        ECouponResponseDto eCouponResponseDto = super.getResult(response);
        Assert.notNull(eCouponResponseDto);
    }
}
