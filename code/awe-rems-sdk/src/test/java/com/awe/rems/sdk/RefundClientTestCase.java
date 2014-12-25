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
 * @author lijianzhong
 * 
 */
public class RefundClientTestCase {
    String WS_DOMAIN = "http://dev.remsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.remsws.shop.hbird.com:8090/";
    private RefundClient client;

    @Before
    public void init() {
        client = new RefundClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetRefund() {
        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setId(1l);
        RefundRequest request = new RefundRequest("key",requestDto);
        
        RefundResponseDto refundResponseDto = client.getRefund(request);
        Assert.notNull(refundResponseDto);
    } 

}
