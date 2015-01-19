package com.awe.pms.sdk;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;

/**
 * ProductClient测试用例
 * 
 * @author ljz
 * @version 2015-1-4 16:09:20
 * 
 */
public class ProductClientTestCase {
//    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8100/";
    private ProductClient client;

    @Before
    public void init() throws Exception {
        client = new ProductClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProduct() {
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setId(1l);
        
        ProductResponseDto productResponseDto = client.getProduct(requestDto);
        Assert.notNull(productResponseDto);
    }
    
    @Test
    public void testGetProductBySkuNo() {
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
    	requestDto.setSkuNo("sku001");
    	
    	ProductResponseDto productResponseDto = client.getProductBySkuNo(requestDto);
    	Assert.notNull(productResponseDto);
    }
    
    @Test
    public void testGetProductBySkuNos() {
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
    	List<String> skuNos = new ArrayList<String>();
    	skuNos.add("sku001");
//    	skuNos.add("sku002");
    	skuNos.add("sku005");
    	skuNos.add("sku004");
    	requestDto.setSkuNos(skuNos);
    	
    	List<ProductResponseDto> productResponseDtos = client.getProductBySkuNos(requestDto);
    	Assert.notNull(productResponseDtos);
    }
    
    @Test
    public void testGetProducts() {
    	ProductRequestDto requestDto = new ProductRequestDto();
//    	requestDto.setId(1l);
    	
    	List<ProductResponseDto> productResponseDtos = client.getProducts(requestDto);
    	Assert.notNull(productResponseDtos);
    } 

}
