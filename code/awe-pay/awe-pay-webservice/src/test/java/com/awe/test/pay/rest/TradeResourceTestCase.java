package com.awe.test.pay.rest;

import java.util.Date;

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
        requestDto.setId(2l);
        TradeRequest request = new TradeRequest("pay",requestDto);
        
        TradeResponse response = super.getRestTemplate().postForObject(url, request, TradeResponse.class);
        Assert.notNull(response);
        TradeResponseDto tradeResponseDto = super.getResult(response);
        Assert.notNull(tradeResponseDto);
    }
    @Test
    public void addTrade(){
    	String url= getServiceUrlDomain() + "/trade/addTrade";

        TradeRequestDto requestDto = new TradeRequestDto();
        requestDto.setAccountName("张艳青");
        requestDto.setAccountNo("6228143314011988");
        requestDto.setAmount(120.00);
        requestDto.setBusinessNo("10010");
        requestDto.setBusinessName("北京婴幼儿商贸有限公司");
        requestDto.setChannelName("支付宝");
        requestDto.setChannelNo(10l);
        requestDto.setCreateTime(new Date());
        requestDto.setCreateUser("张艳青");
        requestDto.setCreateUserId(1l);
        requestDto.setLoginName("张艳青");
        requestDto.setLoginNo("15810819163");
        requestDto.setOrderNo("20150120123044");
        requestDto.setSerialNo("12434345");
        requestDto.setStatus(10);//交易状态:10:处理中;20:完成:30:失败
        requestDto.setTradeTime(new Date());
        requestDto.setUpdateTime(new Date());
        requestDto.setUpdateUser("张艳青");
        requestDto.setUpdateUserId(1l);
        requestDto.setYn(1);
        TradeRequest request = new TradeRequest("pay",requestDto);
        
        TradeResponse response = super.getRestTemplate().postForObject(url, request, TradeResponse.class);
        Assert.notNull(response);
    }
}
