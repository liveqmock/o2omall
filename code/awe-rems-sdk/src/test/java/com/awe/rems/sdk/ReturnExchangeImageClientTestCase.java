package com.awe.rems.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.rems.sdk.request.ReturnExchangeImageRequest;
import com.awe.rems.sdk.request.dto.ReturnExchangeImageRequestDto;
import com.awe.rems.sdk.response.dto.ReturnExchangeImageResponseDto;

/**
 * ReturnExchangeImageClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class ReturnExchangeImageClientTestCase {
    String WS_DOMAIN = "http://dev.remsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.remsws.shop.hbird.com:8090/";
    private ReturnExchangeImageClient client;

    @Before
    public void init() {
        client = new ReturnExchangeImageClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetReturnExchangeImage() {
        ReturnExchangeImageRequestDto requestDto = new ReturnExchangeImageRequestDto();
        requestDto.setId(1l);
        ReturnExchangeImageRequest request = new ReturnExchangeImageRequest("key",requestDto);
        
        ReturnExchangeImageResponseDto returnExchangeImageResponseDto = client.getReturnExchangeImage(request);
        Assert.notNull(returnExchangeImageResponseDto);
    } 

}
