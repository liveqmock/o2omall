package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.SkuImagesRequest;
import com.awe.test.pms.rest.request.dto.SkuImagesRequestDto;
import com.awe.test.pms.rest.response.SkuImagesResponse;
import com.awe.test.pms.rest.response.dto.SkuImagesResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * SkuImagesResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 14:47:41
 * 
 */
public class SkuImagesResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetSkuImages() {
        String url= Urls.API_DOMAIN + "/skuImages/getSkuImages";

        SkuImagesRequestDto requestDto = new SkuImagesRequestDto();
        requestDto.setId(1l);
        SkuImagesRequest request = new SkuImagesRequest("key",requestDto);
        
        SkuImagesResponse response = super.getRestTemplate().postForObject(url, request, SkuImagesResponse.class);
        Assert.notNull(response);
        SkuImagesResponseDto skuImagesResponseDto = super.getResult(response);
        Assert.notNull(skuImagesResponseDto);
    }
}
