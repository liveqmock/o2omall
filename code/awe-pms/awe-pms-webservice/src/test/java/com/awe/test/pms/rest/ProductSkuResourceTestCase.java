package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductSkuRequest;
import com.awe.test.pms.rest.request.dto.ProductSkuRequestDto;
import com.awe.test.pms.rest.response.ProductSkuResponse;
import com.awe.test.pms.rest.response.dto.ProductSkuResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * ProductSkuResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductSkuResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetProductSku() {
        String url= Urls.API_DOMAIN + "/productSku/getProductSku";

        ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
        requestDto.setId(1l);
        ProductSkuRequest request = new ProductSkuRequest("key",requestDto);
        
        ProductSkuResponse response = super.getRestTemplate().postForObject(url, request, ProductSkuResponse.class);
        Assert.notNull(response);
        ProductSkuResponseDto productSkuResponseDto = super.getResult(response);
        Assert.notNull(productSkuResponseDto);
    }
}
