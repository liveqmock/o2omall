package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductRequest;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;

/**
 * ProductClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class ProductClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private ProductClient client;

    @Before
    public void init() {
        client = new ProductClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetProduct() {
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setId(1l);
        ProductRequest request = new ProductRequest("key",requestDto);
        
        ProductResponseDto productResponseDto = client.getProduct(request);
        Assert.notNull(productResponseDto);
    } 

}
