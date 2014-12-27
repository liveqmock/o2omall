package com.awe.test.rems.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.rems.rest.request.ReturnExchangeImageRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeImageRequestDto;
import com.awe.test.rems.rest.response.ReturnExchangeImageResponse;
import com.awe.test.rems.rest.response.dto.ReturnExchangeImageResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ReturnExchangeImageResource单元测试
 * 
 * @author zyq
 * @version 2014-12-25 15:29:57
 * 
 */
public class ReturnExchangeImageResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetReturnExchangeImage() {
        String url= getServiceUrlDomain() + "/returnExchangeImage/getReturnExchangeImage";

        ReturnExchangeImageRequestDto requestDto = new ReturnExchangeImageRequestDto();
        requestDto.setId(1l);
        ReturnExchangeImageRequest request = new ReturnExchangeImageRequest("rems",requestDto);
        
        ReturnExchangeImageResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeImageResponse.class);
        Assert.notNull(response);
        ReturnExchangeImageResponseDto returnExchangeImageResponseDto = super.getResult(response);
        Assert.notNull(returnExchangeImageResponseDto);
    }
}
