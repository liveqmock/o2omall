package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductCategoryRequest;
import com.awe.pms.sdk.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;

/**
 * ProductCategoryClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductCategoryClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private ProductCategoryClient client;

    @Before
    public void init() throws Exception {
        client = new ProductCategoryClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductCategory() {
        ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
        requestDto.setId(1l);
        ProductCategoryRequest request = new ProductCategoryRequest("pms",requestDto);
        
        ProductCategoryResponseDto productCategoryResponseDto = client.getProductCategory(request);
        Assert.notNull(productCategoryResponseDto);
    } 

}
