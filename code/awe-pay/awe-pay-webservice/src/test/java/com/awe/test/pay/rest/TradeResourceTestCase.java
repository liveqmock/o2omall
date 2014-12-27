package com.awe.test.pay.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pay.rest.request.TradeRequest;
import com.awe.test.pay.rest.request.dto.TradeRequestDto;
import com.awe.test.pay.rest.response.TradeResponse;
import com.awe.test.pay.rest.response.dto.TradeResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * TradeResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:50
 * 
 */
public class TradeResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetTrade() {
        String url= getServiceUrlDomain() + "/trade/getTrade";

        TradeRequestDto requestDto = new TradeRequestDto();
        requestDto.setId(1l);
        TradeRequest request = new TradeRequest("pay",requestDto);
        
        TradeResponse response = super.getRestTemplate().postForObject(url, request, TradeResponse.class);
        Assert.notNull(response);
        TradeResponseDto tradeResponseDto = super.getResult(response);
        Assert.notNull(tradeResponseDto);
    }
}
