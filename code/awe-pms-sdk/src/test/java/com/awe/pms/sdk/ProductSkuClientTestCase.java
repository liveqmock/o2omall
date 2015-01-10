package com.awe.pms.sdk;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;

/**
 * ProductSkuClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductSkuClientTestCase {
//    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8120/";
    private ProductSkuClient client;

    @Before
    public void init() throws Exception {
        client = new ProductSkuClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetProductSku() {
        ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
//        requestDto.setId(1l);
        requestDto.setSkuNo("sku001");
        
        ProductSkuResponseDto productSkuResponseDto = client.getProductSku(requestDto);
        Assert.notNull(productSkuResponseDto);
    } 
    
    @Test
    public void testGetProductSkus() {
    	ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
//    	requestDto.setId(1l);
//    	requestDto.setSkuNo("sku003");
    	List<String> skuNos = new ArrayList<String>();
    	skuNos.add("sku001");
//    	skuNos.add("sku002");
    	skuNos.add("sku005");
    	skuNos.add("sku004");
    	requestDto.setSkuNos(skuNos);
    	
    	List<ProductSkuResponseDto> productSkuResponseDtos = client.getProductSkus(requestDto);
    	Assert.notNull(productSkuResponseDtos);
    } 

}
