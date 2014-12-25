package com.awe.test.order.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.order.rest.request.ECouponRequest;
import com.awe.test.order.rest.request.dto.ECouponRequestDto;
import com.awe.test.order.rest.response.ECouponResponse;
import com.awe.test.order.rest.response.dto.ECouponResponseDto;

/**
 * ECouponResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:37
 * 
 */
public class ECouponResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetECoupon() {
        String url= getServiceUrlDomain() + "/eCoupon/getECoupon";

        ECouponRequestDto requestDto = new ECouponRequestDto();
        requestDto.setId(1l);
        ECouponRequest request = new ECouponRequest("order",requestDto);
        
        ECouponResponse response = super.getRestTemplate().postForObject(url, request, ECouponResponse.class);
        Assert.notNull(response);
        ECouponResponseDto eCouponResponseDto = super.getResult(response);
        Assert.notNull(eCouponResponseDto);
    }
}
