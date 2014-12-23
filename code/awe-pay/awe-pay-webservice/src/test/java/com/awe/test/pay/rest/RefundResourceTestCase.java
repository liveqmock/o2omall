package com.awe.test.pay.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pay.rest.request.RefundRequest;
import com.awe.test.pay.rest.request.dto.RefundRequestDto;
import com.awe.test.pay.rest.response.RefundResponse;
import com.awe.test.pay.rest.response.dto.RefundResponseDto;
import com.awe.test.pay.rest.Urls;

/**
 * RefundResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class RefundResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetRefund() {
        String url= Urls.API_DOMAIN + "/refund/getRefund";

        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setId(1l);
        RefundRequest request = new RefundRequest("key",requestDto);
        
        RefundResponse response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);
        Assert.notNull(response);
        RefundResponseDto refundResponseDto = super.getResult(response);
        Assert.notNull(refundResponseDto);
    }
}
