package com.awe.test.pms.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.BusinessInfoRequest;
import com.awe.test.pms.rest.request.dto.BusinessInfoRequestDto;
import com.awe.test.pms.rest.response.BusinessInfoResponse;
import com.awe.test.pms.rest.response.dto.BusinessInfoResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

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
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetAllBusinessInfos() {
    	String url= getServiceUrlDomain() + "/businessInfo/getAllBusinessInfos";
    	
    	BusinessInfoRequestDto requestDto = new BusinessInfoRequestDto();
    	BusinessInfoRequest request = new BusinessInfoRequest("pms",requestDto);
    	
//    	List<BusinessInfoResponseDto> result = response.getResult();
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	Assert.notNull(response);
    	
    	List<BusinessInfoResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), BusinessInfoResponseDto.class);
    	response.setResult(responseResult);
    	List<BusinessInfoRequestDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
