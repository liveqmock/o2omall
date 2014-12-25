package com.awe.pay.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.dto.RefundRequestDto;
import com.awe.pay.sdk.response.dto.RefundResponseDto;

/**
 * RefundClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class RefundClientTestCase {
    String WS_DOMAIN = "http://dev.payws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.payws.shop.hbird.com:8090/";
    private RefundClient client;

    @Before
    public void init() throws Exception {
        client = new RefundClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pay");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetRefund() {
        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setId(1l);
        
        RefundResponseDto refundResponseDto = client.getRefund(requestDto);
        Assert.notNull(refundResponseDto);
    } 

}
