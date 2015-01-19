package com.awe.test.pms.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.api.request.ProductSkuRequest;
import com.awe.pms.sdk.api.request.dto.ProductSkuRequestDto;
import com.awe.test.pms.rest.request.ProductRequest;
import com.awe.test.pms.rest.request.dto.ProductRequestDto;
import com.awe.test.pms.rest.response.ProductResponse;
import com.awe.test.pms.rest.response.dto.ProductResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * ProductResource单元测试
 * 
 * @author ljz
 * @version 2015-1-4 16:09:19
 * 
 */
public class ProductResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProduct() {
        String url= getServiceUrlDomain() + "/product/getProduct";

        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setId(1L);
        ProductRequest request = new ProductRequest("pms",requestDto);
        
        ProductResponse response = super.getRestTemplate().postForObject(url, request, ProductResponse.class);
        Assert.notNull(response);
        ProductResponseDto productResponseDto = super.getResult(response);
        Assert.notNull(productResponseDto);
    }
    
    @Test
    public void testGetProductBySkuNo() {
    	String url= getServiceUrlDomain() + "/product/getProductBySkuNo";
    	
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
    	requestDto.setSkuNo("sku001");
		ProductSkuRequest request = new ProductSkuRequest("pms",requestDto );
    	
    	ProductResponse response = super.getRestTemplate().postForObject(url, request, ProductResponse.class);
    	Assert.notNull(response);
    	ProductResponseDto productResponseDto = super.getResult(response);
    	Assert.notNull(productResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProductBySkuNos() {
    	String url= getServiceUrlDomain() + "/product/getProductBySkuNos";
    	
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
//    	requestDto.setSkuNo("sku003");
    	List<String> skuNos = new ArrayList<String>();
    	skuNos.add("sku001");
    	skuNos.add("sku002");
    	skuNos.add("sku005");
//    	skuNos.add("sku004");
    	requestDto.setSkuNos(skuNos);
    	ProductSkuRequest request = new ProductSkuRequest("pms",requestDto );
    	
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProducts() {
    	String url= getServiceUrlDomain() + "/product/getProducts";
    	
    	ProductRequestDto requestDto = new ProductRequestDto();
//    	requestDto.setId(1l);
    	ProductRequest request = new ProductRequest("pms",requestDto);
    	
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
