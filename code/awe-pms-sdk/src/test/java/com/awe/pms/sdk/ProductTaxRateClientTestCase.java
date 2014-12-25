package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductTaxRateRequest;
import com.awe.pms.sdk.request.dto.ProductTaxRateRequestDto;
import com.awe.pms.sdk.response.dto.ProductTaxRateResponseDto;

/**
 * ProductTaxRateClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductTaxRateClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private ProductTaxRateClient client;

    @Before
    public void init() throws Exception {
        client = new ProductTaxRateClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductTaxRate() {
        ProductTaxRateRequestDto requestDto = new ProductTaxRateRequestDto();
        requestDto.setId(1l);
        ProductTaxRateRequest request = new ProductTaxRateRequest("pms",requestDto);
        
        ProductTaxRateResponseDto productTaxRateResponseDto = client.getProductTaxRate(request);
        Assert.notNull(productTaxRateResponseDto);
    } 

}
