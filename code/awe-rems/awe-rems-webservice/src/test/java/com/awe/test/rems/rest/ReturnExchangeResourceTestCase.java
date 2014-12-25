package com.awe.test.rems.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.rems.rest.request.ReturnExchangeRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeRequestDto;
import com.awe.test.rems.rest.response.ReturnExchangeResponse;
import com.awe.test.rems.rest.response.dto.ReturnExchangeResponseDto;
import com.awe.test.rems.rest.Urls;

/**
 * ReturnExchangeResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ReturnExchangeResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetReturnExchange() {
        String url= Urls.API_DOMAIN + "/returnExchange/getReturnExchange";

        ReturnExchangeRequestDto requestDto = new ReturnExchangeRequestDto();
        requestDto.setId(1l);
        ReturnExchangeRequest request = new ReturnExchangeRequest("key",requestDto);
        
        ReturnExchangeResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponse.class);
        Assert.notNull(response);
        ReturnExchangeResponseDto returnExchangeResponseDto = super.getResult(response);
        Assert.notNull(returnExchangeResponseDto);
    }
}
