package com.awe.pay.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.TradeRequest;
import com.awe.pay.sdk.request.dto.TradeRequestDto;
import com.awe.pay.sdk.response.dto.TradeResponseDto;

/**
 * TradeClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:29:50
 * 
 */
public class TradeClientTestCase {
    String WS_DOMAIN = "http://dev.payws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.payws.shop.hbird.com:8090/";
    private TradeClient client;

    @Before
    public void init() throws Exception {
        client = new TradeClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetTrade() {
        TradeRequestDto requestDto = new TradeRequestDto();
        requestDto.setId(1l);
        TradeRequest request = new TradeRequest("pay",requestDto);
        
        TradeResponseDto tradeResponseDto = client.getTrade(request);
        Assert.notNull(tradeResponseDto);
    } 

}
