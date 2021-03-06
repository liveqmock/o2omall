package com.awe.pms.sdk;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;

/**
 * ProductCategoryClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductCategoryClientTestCase {
//    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8081/";
    private ProductCategoryClient client;

    @Before
    public void init() throws Exception {
        client = new ProductCategoryClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductCategory() {
        ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
        requestDto.setId(1l);
        
        ProductCategoryResponseDto productCategoryResponseDto = client.getProductCategory(requestDto);
        Assert.notNull(productCategoryResponseDto);
    } 
    
    @Test
    public void testGetProductCategorys() {
    	ProductCategoryRequestDto requestDto = new ProductCategoryRequestDto();
//    	requestDto.setId(1l);
    	
    	List<ProductCategoryResponseDto> productCategoryResponseDtos = client.getProductCategorys(requestDto);
    	Assert.notNull(productCategoryResponseDtos);
    } 

}
