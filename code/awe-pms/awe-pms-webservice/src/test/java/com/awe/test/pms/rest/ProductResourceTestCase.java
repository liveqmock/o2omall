package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductRequest;
import com.awe.test.pms.rest.request.dto.ProductRequestDto;
import com.awe.test.pms.rest.response.ProductResponse;
import com.awe.test.pms.rest.response.dto.ProductResponseDto;

/**
 * ProductResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
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
        requestDto.setId(1l);
        ProductRequest request = new ProductRequest("pms",requestDto);
        
        ProductResponse response = super.getRestTemplate().postForObject(url, request, ProductResponse.class);
        Assert.notNull(response);
        ProductResponseDto productResponseDto = super.getResult(response);
        Assert.notNull(productResponseDto);
    }
}
