package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductBrandRequest;
import com.awe.test.pms.rest.request.dto.ProductBrandRequestDto;
import com.awe.test.pms.rest.response.ProductBrandResponse;
import com.awe.test.pms.rest.response.dto.ProductBrandResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductBrandResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductBrandResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProductBrand() {
        String url= Urls.API_DOMAIN + "/productBrand/getProductBrand";

        ProductBrandRequestDto requestDto = new ProductBrandRequestDto();
        requestDto.setId(1l);
        ProductBrandRequest request = new ProductBrandRequest("key",requestDto);
        
        ProductBrandResponse response = super.getRestTemplate().postForObject(url, request, ProductBrandResponse.class);
        Assert.notNull(response);
        ProductBrandResponseDto productBrandResponseDto = super.getResult(response);
        Assert.notNull(productBrandResponseDto);
    }
}
