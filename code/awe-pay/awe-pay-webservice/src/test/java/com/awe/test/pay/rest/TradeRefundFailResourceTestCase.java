package com.awe.test.pay.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pay.rest.request.TradeRefundFailRequest;
import com.awe.test.pay.rest.request.dto.TradeRefundFailRequestDto;
import com.awe.test.pay.rest.response.TradeRefundFailResponse;
import com.awe.test.pay.rest.response.dto.TradeRefundFailResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * TradeRefundFailResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:50
 * 
 */
public class TradeRefundFailResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetTradeRefundFail() {
        String url= getServiceUrlDomain() + "/tradeRefundFail/getTradeRefundFail";

        TradeRefundFailRequestDto requestDto = new TradeRefundFailRequestDto();
        requestDto.setId(1l);
        TradeRefundFailRequest request = new TradeRefundFailRequest("pay",requestDto);
        
        TradeRefundFailResponse response = super.getRestTemplate().postForObject(url, request, TradeRefundFailResponse.class);
        Assert.notNull(response);
        TradeRefundFailResponseDto tradeRefundFailResponseDto = super.getResult(response);
        Assert.notNull(tradeRefundFailResponseDto);
    }
}
