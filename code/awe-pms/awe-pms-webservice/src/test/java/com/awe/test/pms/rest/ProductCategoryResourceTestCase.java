package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductCategoryRequest;
import com.awe.test.pms.rest.request.dto.ProductCategoryRequestDto;
import com.awe.test.pms.rest.response.ProductCategoryResponse;
import com.awe.test.pms.rest.response.dto.ProductCategoryResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductCategoryResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductCategoryResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProductCategory() {
        String url= Urls.API_DOMAIN + "/productCategory/getProductCategory";

        ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
        requestDto.setId(1l);
        ProductCategoryRequest request = new ProductCategoryRequest("key",requestDto);
        
        ProductCategoryResponse response = super.getRestTemplate().postForObject(url, request, ProductCategoryResponse.class);
        Assert.notNull(response);
        ProductCategoryResponseDto productCategoryResponseDto = super.getResult(response);
        Assert.notNull(productCategoryResponseDto);
    }
}
