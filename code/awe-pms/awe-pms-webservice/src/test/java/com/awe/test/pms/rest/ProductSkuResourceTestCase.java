package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.uc.rest.Urls;
import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.ProductSkuRequest;
import com.awe.test.pms.rest.request.dto.ProductSkuRequestDto;
import com.awe.test.pms.rest.response.ProductSkuResponse;
import com.awe.test.pms.rest.response.dto.ProductSkuResponseDto;

/**
 * ProductSkuResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class ProductSkuResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductSku() {
        String url= getServiceUrlDomain() + "/productSku/getProductSku";

        ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
        requestDto.setId(1l);
        ProductSkuRequest request = new ProductSkuRequest("pms",requestDto);
        
        ProductSkuResponse response = super.getRestTemplate().postForObject(url, request, ProductSkuResponse.class);
        Assert.notNull(response);
        ProductSkuResponseDto productSkuResponseDto = super.getResult(response);
        Assert.notNull(productSkuResponseDto);
    }
}
