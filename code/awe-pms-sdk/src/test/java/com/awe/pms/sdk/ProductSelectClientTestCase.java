package com.awe.pms.sdk;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;

/**
 * ProductSelectClient测试用例
 * 
 * @author ljz
 * @version 2015-1-21 10:47:35
 * 
 */
public class ProductSelectClientTestCase {
//    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8100/";
    private ProductSelectClient client;

    @Before
    public void init() throws Exception {
        client = new ProductSelectClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductSelect() {
        ProductSelectRequestDto requestDto = new ProductSelectRequestDto();
        requestDto.setId(1l);
        
        ProductSelectResponseDto productSelectResponseDto = client.getProductSelect(requestDto);
        Assert.notNull(productSelectResponseDto);
    } 
    
    @Test
    public void testGetProductSelects() {
    	ProductSelectRequestDto requestDto = new ProductSelectRequestDto();
//    	requestDto.setId(1l);
    	
    	List<ProductSelectResponseDto> productSelectResponseDtos = client.getProductSelects(requestDto);
    	Assert.notNull(productSelectResponseDtos);
    } 

}
