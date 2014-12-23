package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductSkuRequest;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;

/**
 * ProductSkuClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class ProductSkuClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private ProductSkuClient client;

    @Before
    public void init() {
        client = new ProductSkuClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetProductSku() {
        ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
        requestDto.setId(1l);
        ProductSkuRequest request = new ProductSkuRequest("key",requestDto);
        
        ProductSkuResponseDto productSkuResponseDto = client.getProductSku(request);
        Assert.notNull(productSkuResponseDto);
    } 

}
