package com.awe.pay.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.dto.TradeRefundFailRequestDto;
import com.awe.pay.sdk.response.dto.TradeRefundFailResponseDto;

/**
 * TradeRefundFailClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class TradeRefundFailClientTestCase {
    String WS_DOMAIN = "http://dev.payws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.payws.shop.hbird.com:8090/";
    private TradeRefundFailClient client;

    @Before
    public void init() throws Exception {
        client = new TradeRefundFailClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pay");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetTradeRefundFail() {
        TradeRefundFailRequestDto requestDto = new TradeRefundFailRequestDto();
        requestDto.setId(1l);
        
        TradeRefundFailResponseDto tradeRefundFailResponseDto = client.getTradeRefundFail(requestDto);
        Assert.notNull(tradeRefundFailResponseDto);
    } 

}
