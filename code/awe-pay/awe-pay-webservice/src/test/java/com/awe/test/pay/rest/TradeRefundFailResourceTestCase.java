package com.awe.test.pay.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pay.rest.request.TradeRefundFailRequest;
import com.awe.test.pay.rest.request.dto.TradeRefundFailRequestDto;
import com.awe.test.pay.rest.response.TradeRefundFailResponse;
import com.awe.test.pay.rest.response.dto.TradeRefundFailResponseDto;
import com.awe.test.pay.rest.Urls;

/**
 * TradeRefundFailResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeRefundFailResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTradeRefundFail() {
        String url= Urls.API_DOMAIN + "/tradeRefundFail/getTradeRefundFail";

        TradeRefundFailRequestDto requestDto = new TradeRefundFailRequestDto();
        requestDto.setId(1l);
        TradeRefundFailRequest request = new TradeRefundFailRequest("key",requestDto);
        
        TradeRefundFailResponse response = super.getRestTemplate().postForObject(url, request, TradeRefundFailResponse.class);
        Assert.notNull(response);
        TradeRefundFailResponseDto tradeRefundFailResponseDto = super.getResult(response);
        Assert.notNull(tradeRefundFailResponseDto);
    }
}
