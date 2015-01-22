package com.awe.test.pms.rest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.pms.rest.request.ProductSelectRequest;
import com.awe.test.pms.rest.request.dto.ProductSelectRequestDto;
import com.awe.test.pms.rest.response.ProductSelectResponse;
import com.awe.test.pms.rest.response.dto.ProductSelectResponseDto;
import com.hbird.common.client.AbstractClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * ProductSelectResource单元测试
 * 
 * @author ljz
 * @version 2015-1-21 10:47:34
 * 
 */
public class ProductSelectResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetProductSelect() {
        String url= getServiceUrlDomain() + "/productSelect/getProductSelect";

        ProductSelectRequestDto requestDto = new ProductSelectRequestDto();
        requestDto.setId(1l);
        ProductSelectRequest request = new ProductSelectRequest("pms",requestDto);
        
        ProductSelectResponse response = super.getRestTemplate().postForObject(url, request, ProductSelectResponse.class);
        Assert.notNull(response);
        ProductSelectResponseDto productSelectResponseDto = super.getResult(response);
        Assert.notNull(productSelectResponseDto);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testGetProductSelects() {
    	String url= getServiceUrlDomain() + "/productSelect/getProductSelects";
    	
    	ProductSelectRequestDto requestDto = new ProductSelectRequestDto();
//    	requestDto.setId(1l);
    	ProductSelectRequest request = new ProductSelectRequest("pms",requestDto);
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductSelectResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductSelectResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductSelectResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testGetProductSelectsWithPage() {
    	String url= getServiceUrlDomain() + "/productSelect/getProductSelectsWithPage";
    	
    	ProductSelectRequestDto requestDto = new ProductSelectRequestDto();
    	PageUtil pageUtil = new PageUtil();
    	pageUtil.setPageSize(1);
    	pageUtil.setCurPage(2);
    	ProductSelectRequest request = new ProductSelectRequest("pms",requestDto, pageUtil);
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductSelectResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductSelectResponseDto.class);
    	Assert.notNull(response);
    	response.setResult(responseResult);
    	List<ProductSelectResponseDto> result = super.getResult(response);
    	Assert.notNull(result);
    }
}
