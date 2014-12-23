package com.awe.test.pay.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pay.rest.request.ChannelRequest;
import com.awe.test.pay.rest.request.dto.ChannelRequestDto;
import com.awe.test.pay.rest.response.ChannelResponse;
import com.awe.test.pay.rest.response.dto.ChannelResponseDto;
import com.awe.test.pay.rest.Urls;

/**
 * ChannelResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class ChannelResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetChannel() {
        String url= Urls.API_DOMAIN + "/channel/getChannel";

        ChannelRequestDto requestDto = new ChannelRequestDto();
        requestDto.setId(1l);
        ChannelRequest request = new ChannelRequest("key",requestDto);
        
        ChannelResponse response = super.getRestTemplate().postForObject(url, request, ChannelResponse.class);
        Assert.notNull(response);
        ChannelResponseDto channelResponseDto = super.getResult(response);
        Assert.notNull(channelResponseDto);
    }
}
