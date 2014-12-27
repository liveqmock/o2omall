package com.awe.test.pay.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pay.rest.request.RefundRequest;
import com.awe.test.pay.rest.request.dto.RefundRequestDto;
import com.awe.test.pay.rest.response.RefundResponse;
import com.awe.test.pay.rest.response.dto.RefundResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * RefundResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:50
 * 
 */
public class RefundResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetRefund() {
        String url= getServiceUrlDomain() + "/refund/getRefund";

        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setId(1l);
        RefundRequest request = new RefundRequest("pay",requestDto);
        
        RefundResponse response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);
        Assert.notNull(response);
        RefundResponseDto refundResponseDto = super.getResult(response);
        Assert.notNull(refundResponseDto);
    }
}
