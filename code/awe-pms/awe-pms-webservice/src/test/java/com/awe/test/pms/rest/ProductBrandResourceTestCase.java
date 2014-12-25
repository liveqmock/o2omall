package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductBrandRequest;
import com.awe.test.pms.rest.request.dto.ProductBrandRequestDto;
import com.awe.test.pms.rest.response.ProductBrandResponse;
import com.awe.test.pms.rest.response.dto.ProductBrandResponseDto;

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
}
