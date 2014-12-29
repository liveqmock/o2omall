package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.ProductTaxRateRequestDto;
import com.awe.pms.sdk.response.dto.ProductTaxRateResponseDto;

/**
 * ProductTaxRateClient测试用例
 * 
 * @author ljz
 * @version 2014-12-29 11:46:00
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
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductTaxRate() {
        ProductTaxRateRequestDto requestDto = new ProductTaxRateRequestDto();
        requestDto.setId(1l);
        
        ProductTaxRateResponseDto productTaxRateResponseDto = client.getProductTaxRate(requestDto);
        Assert.notNull(productTaxRateResponseDto);
    } 

}
