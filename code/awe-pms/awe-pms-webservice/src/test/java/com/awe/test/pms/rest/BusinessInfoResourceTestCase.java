package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.BusinessInfoRequest;
import com.awe.test.pms.rest.request.dto.BusinessInfoRequestDto;
import com.awe.test.pms.rest.response.BusinessInfoResponse;
import com.awe.test.pms.rest.response.dto.BusinessInfoResponseDto;

/**
 * BusinessInfoResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class BusinessInfoResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetBusinessInfo() {
        String url= getServiceUrlDomain() + "/businessInfo/getBusinessInfo";

        BusinessInfoRequestDto requestDto = new BusinessInfoRequestDto();
        requestDto.setId(1l);
        BusinessInfoRequest request = new BusinessInfoRequest("pms",requestDto);
        
        BusinessInfoResponse response = super.getRestTemplate().postForObject(url, request, BusinessInfoResponse.class);
        Assert.notNull(response);
        BusinessInfoResponseDto businessInfoResponseDto = super.getResult(response);
        Assert.notNull(businessInfoResponseDto);
    }
}
