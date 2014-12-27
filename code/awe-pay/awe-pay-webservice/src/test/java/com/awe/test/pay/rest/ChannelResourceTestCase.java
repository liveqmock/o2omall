package com.awe.test.pay.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pay.rest.request.ChannelRequest;
import com.awe.test.pay.rest.request.dto.ChannelRequestDto;
import com.awe.test.pay.rest.response.ChannelResponse;
import com.awe.test.pay.rest.response.dto.ChannelResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ChannelResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:29:50
 * 
 */
public class ChannelResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetChannel() {
        String url= getServiceUrlDomain() + "/channel/getChannel";

        ChannelRequestDto requestDto = new ChannelRequestDto();
        requestDto.setId(1l);
        ChannelRequest request = new ChannelRequest("pay",requestDto);
        
        ChannelResponse response = super.getRestTemplate().postForObject(url, request, ChannelResponse.class);
        Assert.notNull(response);
        ChannelResponseDto channelResponseDto = super.getResult(response);
        Assert.notNull(channelResponseDto);
    }
}
