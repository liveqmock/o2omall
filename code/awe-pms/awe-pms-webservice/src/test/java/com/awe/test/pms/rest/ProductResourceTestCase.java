package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductRequest;
import com.awe.test.pms.rest.request.dto.ProductRequestDto;
import com.awe.test.pms.rest.response.ProductResponse;
import com.awe.test.pms.rest.response.dto.ProductResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 14:47:41
 * 
 */
public class ProductResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProduct() {
        String url= Urls.API_DOMAIN + "/product/getProduct";

        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setId(1l);
        ProductRequest request = new ProductRequest("key",requestDto);
        
        ProductResponse response = super.getRestTemplate().postForObject(url, request, ProductResponse.class);
        Assert.notNull(response);
        ProductResponseDto productResponseDto = super.getResult(response);
        Assert.notNull(productResponseDto);
    }
}
