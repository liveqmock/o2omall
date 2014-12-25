package com.awe.test.rems.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.rems.rest.request.ReturnExchangeImageRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeImageRequestDto;
import com.awe.test.rems.rest.response.ReturnExchangeImageResponse;
import com.awe.test.rems.rest.response.dto.ReturnExchangeImageResponseDto;
import com.awe.test.rems.rest.Urls;

/**
 * ReturnExchangeImageResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ReturnExchangeImageResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetReturnExchangeImage() {
        String url= Urls.API_DOMAIN + "/returnExchangeImage/getReturnExchangeImage";

        ReturnExchangeImageRequestDto requestDto = new ReturnExchangeImageRequestDto();
        requestDto.setId(1l);
        ReturnExchangeImageRequest request = new ReturnExchangeImageRequest("key",requestDto);
        
        ReturnExchangeImageResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeImageResponse.class);
        Assert.notNull(response);
        ReturnExchangeImageResponseDto returnExchangeImageResponseDto = super.getResult(response);
        Assert.notNull(returnExchangeImageResponseDto);
    }
}
