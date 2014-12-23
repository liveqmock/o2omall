package com.awe.test.pay.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pay.rest.request.TradeRequest;
import com.awe.test.pay.rest.request.dto.TradeRequestDto;
import com.awe.test.pay.rest.response.TradeResponse;
import com.awe.test.pay.rest.response.dto.TradeResponseDto;
import com.awe.test.pay.rest.Urls;

/**
 * TradeResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetTrade() {
        String url= Urls.API_DOMAIN + "/trade/getTrade";

        TradeRequestDto requestDto = new TradeRequestDto();
        requestDto.setId(1l);
        TradeRequest request = new TradeRequest("key",requestDto);
        
        TradeResponse response = super.getRestTemplate().postForObject(url, request, TradeResponse.class);
        Assert.notNull(response);
        TradeResponseDto tradeResponseDto = super.getResult(response);
        Assert.notNull(tradeResponseDto);
    }
}
