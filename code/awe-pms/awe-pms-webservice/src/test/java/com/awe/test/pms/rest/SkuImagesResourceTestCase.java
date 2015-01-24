package com.awe.test.pms.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.SkuImagesRequest;
import com.awe.test.pms.rest.request.dto.SkuImagesRequestDto;
import com.awe.test.pms.rest.response.SkuImagesResponse;
import com.awe.test.pms.rest.response.dto.ProductSelectResponseDto;
import com.awe.test.pms.rest.response.dto.SkuImagesResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * SkuImagesResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class SkuImagesResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetSkuImages() {
        String url= getServiceUrlDomain() + "/skuImages/getSkuImages";

        SkuImagesRequestDto requestDto = new SkuImagesRequestDto();
        requestDto.setId(1l);
        SkuImagesRequest request = new SkuImagesRequest("pms",requestDto);
        
        SkuImagesResponse response = super.getRestTemplate().postForObject(url, request, SkuImagesResponse.class);
        Assert.notNull(response);
        SkuImagesResponseDto skuImagesResponseDto = super.getResult(response);
        Assert.notNull(skuImagesResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetSkuImagesList() {
    	String url= getServiceUrlDomain() + "/skuImages/getSkuImageList";
    	
    	SkuImagesRequestDto requestDto = new SkuImagesRequestDto();
    	requestDto.setSkuNo("10000000010008");
    	SkuImagesRequest request = new SkuImagesRequest("pms",requestDto);
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<SkuImagesResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), SkuImagesResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductSelectResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
