package com.awe.pay.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.ChannelRequest;
import com.awe.pay.sdk.request.dto.ChannelRequestDto;
import com.awe.pay.sdk.response.dto.ChannelResponseDto;

/**
 * ChannelClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class ChannelClientTestCase {
    String WS_DOMAIN = "http://dev.payws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.payws.shop.hbird.com:8090/";
    private ChannelClient client;

    @Before
    public void init() {
        client = new ChannelClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetChannel() {
        ChannelRequestDto requestDto = new ChannelRequestDto();
        requestDto.setId(1l);
        ChannelRequest request = new ChannelRequest("key",requestDto);
        
        ChannelResponseDto channelResponseDto = client.getChannel(request);
        Assert.notNull(channelResponseDto);
    } 

}
