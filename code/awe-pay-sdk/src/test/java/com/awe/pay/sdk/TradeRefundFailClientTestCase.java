package com.awe.pay.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.TradeRefundFailRequest;
import com.awe.pay.sdk.request.dto.TradeRefundFailRequestDto;
import com.awe.pay.sdk.response.dto.TradeRefundFailResponseDto;

/**
 * TradeRefundFailClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class TradeRefundFailClientTestCase {
    String WS_DOMAIN = "http://dev.payws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.payws.shop.hbird.com:8090/";
    private TradeRefundFailClient client;

    @Before
    public void init() {
        client = new TradeRefundFailClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetTradeRefundFail() {
        TradeRefundFailRequestDto requestDto = new TradeRefundFailRequestDto();
        requestDto.setId(1l);
        TradeRefundFailRequest request = new TradeRefundFailRequest("key",requestDto);
        
        TradeRefundFailResponseDto tradeRefundFailResponseDto = client.getTradeRefundFail(request);
        Assert.notNull(tradeRefundFailResponseDto);
    } 

}
