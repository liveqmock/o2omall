package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductTaxRateRequest;
import com.awe.test.pms.rest.request.dto.ProductTaxRateRequestDto;
import com.awe.test.pms.rest.response.ProductTaxRateResponse;
import com.awe.test.pms.rest.response.dto.ProductTaxRateResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductTaxRateResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductTaxRateResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProductTaxRate() {
        String url= Urls.API_DOMAIN + "/productTaxRate/getProductTaxRate";

        ProductTaxRateRequestDto requestDto = new ProductTaxRateRequestDto();
        requestDto.setId(1l);
        ProductTaxRateRequest request = new ProductTaxRateRequest("key",requestDto);
        
        ProductTaxRateResponse response = super.getRestTemplate().postForObject(url, request, ProductTaxRateResponse.class);
        Assert.notNull(response);
        ProductTaxRateResponseDto productTaxRateResponseDto = super.getResult(response);
        Assert.notNull(productTaxRateResponseDto);
    }
}
