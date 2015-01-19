package com.awe.test.pms.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.ProductSkuRequest;
import com.awe.test.pms.rest.request.dto.ProductSkuRequestDto;
import com.awe.test.pms.rest.response.ProductSkuResponse;
import com.awe.test.pms.rest.response.dto.ProductSkuResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * ProductSkuResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductSkuResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductSku() {
        String url= getServiceUrlDomain() + "/productSku/getProductSku";

        ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
        requestDto.setSkuNo("sku003");
        ProductSkuRequest request = new ProductSkuRequest("pms",requestDto);
        
        ProductSkuResponse response = super.getRestTemplate().postForObject(url, request, ProductSkuResponse.class);
        Assert.notNull(response);
        ProductSkuResponseDto productSkuResponseDto = super.getResult(response);
        Assert.notNull(productSkuResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProductSkus() {
    	String url= getServiceUrlDomain() + "/productSku/getProductSkus";
    	
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
//    	requestDto.setSkuNo("sku003");
    	List<String> skuNos = new ArrayList<String>();
    	skuNos.add("sku001");
//    	skuNos.add("sku002");
    	skuNos.add("sku005");
//    	skuNos.add("sku004");
    	requestDto.setSkuNos(skuNos);
    	ProductSkuRequest request = new ProductSkuRequest("pms",requestDto);
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductSkuResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductSkuResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductSkuResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
