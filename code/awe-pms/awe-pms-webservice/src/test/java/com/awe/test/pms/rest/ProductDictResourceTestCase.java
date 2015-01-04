package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.ProductDictRequest;
import com.awe.test.pms.rest.request.dto.ProductDictRequestDto;
import com.awe.test.pms.rest.response.ProductDictResponse;
import com.awe.test.pms.rest.response.dto.ProductDictResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ProductDictResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductDictResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductDict() {
        String url= getServiceUrlDomain() + "/productDict/getProductDict";

        ProductDictRequestDto requestDto = new ProductDictRequestDto();
        requestDto.setId(1l);
        ProductDictRequest request = new ProductDictRequest("pms",requestDto);
        
        ProductDictResponse response = super.getRestTemplate().postForObject(url, request, ProductDictResponse.class);
        Assert.notNull(response);
        ProductDictResponseDto productDictResponseDto = super.getResult(response);
        Assert.notNull(productDictResponseDto);
    }
}
