package com.awe.test.pms.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.ProductCategoryRequest;
import com.awe.test.pms.rest.request.dto.ProductCategoryRequestDto;
import com.awe.test.pms.rest.response.ProductCategoryResponse;
import com.awe.test.pms.rest.response.dto.ProductCategoryResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * ProductCategoryResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductCategoryResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductCategory() {
        String url= getServiceUrlDomain() + "/productCategory/getProductCategory";

        ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
        requestDto.setId(1l);
        ProductCategoryRequest request = new ProductCategoryRequest("pms",requestDto);
        
        ProductCategoryResponse response = super.getRestTemplate().postForObject(url, request, ProductCategoryResponse.class);
        Assert.notNull(response);
        ProductCategoryResponseDto productCategoryResponseDto = super.getResult(response);
        Assert.notNull(productCategoryResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProductCategorys() {
    	String url= getServiceUrlDomain() + "/productCategory/getProductCategorys";
    	
    	ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
//    	requestDto.setId(1l);
    	requestDto.setFid(10L);
    	ProductCategoryRequest request = new ProductCategoryRequest("pms",requestDto);
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductCategoryResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductCategoryResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductCategoryResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
