package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductTaxRateRequest;
import com.awe.test.pms.rest.request.dto.ProductTaxRateRequestDto;
import com.awe.test.pms.rest.response.ProductTaxRateResponse;
import com.awe.test.pms.rest.response.dto.ProductTaxRateResponseDto;

/**
 * ProductTaxRateResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductTaxRateResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductTaxRate() {
        String url= getServiceUrlDomain() + "/productTaxRate/getProductTaxRate";

        ProductTaxRateRequestDto requestDto = new ProductTaxRateRequestDto();
        requestDto.setId(1l);
        ProductTaxRateRequest request = new ProductTaxRateRequest("pms",requestDto);
        
        ProductTaxRateResponse response = super.getRestTemplate().postForObject(url, request, ProductTaxRateResponse.class);
        Assert.notNull(response);
        ProductTaxRateResponseDto productTaxRateResponseDto = super.getResult(response);
        Assert.notNull(productTaxRateResponseDto);
    }
}
