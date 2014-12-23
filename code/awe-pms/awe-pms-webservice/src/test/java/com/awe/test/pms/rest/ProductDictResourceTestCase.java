package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductDictRequest;
import com.awe.test.pms.rest.request.dto.ProductDictRequestDto;
import com.awe.test.pms.rest.response.ProductDictResponse;
import com.awe.test.pms.rest.response.dto.ProductDictResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductDictResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductDictResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProductDict() {
        String url= Urls.API_DOMAIN + "/productDict/getProductDict";

        ProductDictRequestDto requestDto = new ProductDictRequestDto();
        requestDto.setId(1l);
        ProductDictRequest request = new ProductDictRequest("key",requestDto);
        
        ProductDictResponse response = super.getRestTemplate().postForObject(url, request, ProductDictResponse.class);
        Assert.notNull(response);
        ProductDictResponseDto productDictResponseDto = super.getResult(response);
        Assert.notNull(productDictResponseDto);
    }
}
