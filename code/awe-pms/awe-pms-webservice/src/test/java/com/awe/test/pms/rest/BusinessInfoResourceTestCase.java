package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.BusinessInfoRequest;
import com.awe.test.pms.rest.request.dto.BusinessInfoRequestDto;
import com.awe.test.pms.rest.response.BusinessInfoResponse;
import com.awe.test.pms.rest.response.dto.BusinessInfoResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * BusinessInfoResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class BusinessInfoResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetBusinessInfo() {
        String url= Urls.API_DOMAIN + "/businessInfo/getBusinessInfo";

        BusinessInfoRequestDto requestDto = new BusinessInfoRequestDto();
        requestDto.setId(1l);
        BusinessInfoRequest request = new BusinessInfoRequest("key",requestDto);
        
        BusinessInfoResponse response = super.getRestTemplate().postForObject(url, request, BusinessInfoResponse.class);
        Assert.notNull(response);
        BusinessInfoResponseDto businessInfoResponseDto = super.getResult(response);
        Assert.notNull(businessInfoResponseDto);
    }
}
