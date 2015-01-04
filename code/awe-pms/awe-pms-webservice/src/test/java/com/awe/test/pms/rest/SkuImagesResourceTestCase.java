package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.SkuImagesRequest;
import com.awe.test.pms.rest.request.dto.SkuImagesRequestDto;
import com.awe.test.pms.rest.response.SkuImagesResponse;
import com.awe.test.pms.rest.response.dto.SkuImagesResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * SkuImagesResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class SkuImagesResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetSkuImages() {
        String url= getServiceUrlDomain() + "/skuImages/getSkuImages";

        SkuImagesRequestDto requestDto = new SkuImagesRequestDto();
        requestDto.setId(1l);
        SkuImagesRequest request = new SkuImagesRequest("pms",requestDto);
        
        SkuImagesResponse response = super.getRestTemplate().postForObject(url, request, SkuImagesResponse.class);
        Assert.notNull(response);
        SkuImagesResponseDto skuImagesResponseDto = super.getResult(response);
        Assert.notNull(skuImagesResponseDto);
    }
}
