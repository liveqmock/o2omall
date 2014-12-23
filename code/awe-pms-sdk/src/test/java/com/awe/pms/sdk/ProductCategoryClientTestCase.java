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
 * @author lijianzhong
 * 
 */
public class ProductCategoryClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private ProductCategoryClient client;

    @Before
    public void init() {
        client = new ProductCategoryClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetProductCategory() {
        ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
        requestDto.setId(1l);
        ProductCategoryRequest request = new ProductCategoryRequest("key",requestDto);
        
        ProductCategoryResponseDto productCategoryResponseDto = client.getProductCategory(request);
        Assert.notNull(productCategoryResponseDto);
    } 

}
