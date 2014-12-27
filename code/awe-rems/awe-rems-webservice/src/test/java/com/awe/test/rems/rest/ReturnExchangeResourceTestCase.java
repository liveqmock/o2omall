package com.awe.test.rems.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.rems.rest.request.ReturnExchangeRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeRequestDto;
import com.awe.test.rems.rest.response.ReturnExchangeResponse;
import com.awe.test.rems.rest.response.dto.ReturnExchangeResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ReturnExchangeResource单元测试
 * 
 * @author zyq
 * @version 2014-12-25 15:29:57
 * 
 */
public class ReturnExchangeResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetReturnExchange() {
        String url= getServiceUrlDomain() + "/returnExchange/getReturnExchange";

        ReturnExchangeRequestDto requestDto = new ReturnExchangeRequestDto();
        requestDto.setId(1l);
        ReturnExchangeRequest request = new ReturnExchangeRequest("rems",requestDto);
        
        ReturnExchangeResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponse.class);
        Assert.notNull(response);
        ReturnExchangeResponseDto returnExchangeResponseDto = super.getResult(response);
        Assert.notNull(returnExchangeResponseDto);
    }
}
