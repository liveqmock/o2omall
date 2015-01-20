package com.awe.test.pay.rest;

import java.util.Date;

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
    @Test
    public void addRefund(){
    	String url= getServiceUrlDomain() + "/refund/addRefund";

        RefundRequestDto requestDto = new RefundRequestDto();
        requestDto.setCreateUserId(1l);
        requestDto.setOrderNo("20150120123044");
        requestDto.setServiceNo("T000000001");
        requestDto.setAccountName("张艳青");
        requestDto.setAccountNo("6228143314011988");
        requestDto.setCreateTime(new Date());
        requestDto.setCreateUser("张艳青");
        requestDto.setRefundAmount(100.00);
        requestDto.setRefundDate(new Date());
        requestDto.setSerialNo("12434345");
        requestDto.setStatus(30);
        requestDto.setUpdateTime(new Date());
        requestDto.setUpdateUser("张艳青");
        requestDto.setUpdateUserId(1l);
        requestDto.setYn(1);
        requestDto.setBusinessNo("10010");
        requestDto.setBusinessName("北京婴幼儿商贸有限公司");
        
        RefundRequest request = new RefundRequest("pay",requestDto);
        
        RefundResponse response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);
        Assert.notNull(response);
        RefundResponseDto refundResponseDto = super.getResult(response);
        Assert.notNull(refundResponseDto);
    }
}
