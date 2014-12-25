package com.awe.rems.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.rems.sdk.request.RefundRequest;
import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.response.dto.RefundResponseDto;

/**
 * RefundClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:29:58
 * 
 */
public class RefundClientTestCase {
    String WS_DOMAIN = "http://dev.remsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.remsws.shop.hbird.com:8090/";
    private RefundClient client;

    @Before
    public void init() throws Exception {
        client = new RefundClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetRefund() {
        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setId(1l);
        RefundRequest request = new RefundRequest("rems",requestDto);
        
        RefundResponseDto refundResponseDto = client.getRefund(request);
        Assert.notNull(refundResponseDto);
    } 

}
