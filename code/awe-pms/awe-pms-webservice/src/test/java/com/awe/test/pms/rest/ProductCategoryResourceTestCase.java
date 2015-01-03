package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductCategoryRequest;
import com.awe.test.pms.rest.request.dto.ProductCategoryRequestDto;
import com.awe.test.pms.rest.response.ProductCategoryResponse;
import com.awe.test.pms.rest.response.dto.ProductCategoryResponseDto;

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
}
