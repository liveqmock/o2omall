package com.awe.test.pms.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.ProductBrandRequest;
import com.awe.test.pms.rest.request.dto.ProductBrandRequestDto;
import com.awe.test.pms.rest.response.ProductBrandResponse;
import com.awe.test.pms.rest.response.dto.ProductBrandResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * ProductBrandResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductBrandResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductBrand() {
        String url= getServiceUrlDomain() + "/productBrand/getProductBrand";

        ProductBrandRequestDto requestDto = new ProductBrandRequestDto();
        requestDto.setId(1l);
        ProductBrandRequest request = new ProductBrandRequest("pms",requestDto);
        
        ProductBrandResponse response = super.getRestTemplate().postForObject(url, request, ProductBrandResponse.class);
        Assert.notNull(response);
        ProductBrandResponseDto productBrandResponseDto = super.getResult(response);
        Assert.notNull(productBrandResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProductBrands() {
    	String url= getServiceUrlDomain() + "/productBrand/getProductBrands";
    	
    	ProductBrandRequestDto requestDto = new ProductBrandRequestDto();
//    	requestDto.setId(1l);
    	ProductBrandRequest request = new ProductBrandRequest("pms",requestDto);
    	
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductBrandResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductBrandResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductBrandResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
