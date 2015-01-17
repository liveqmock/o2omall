package com.awe.pms.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductDictRequest;
import com.awe.pms.sdk.request.dto.ProductDictRequestDto;
import com.awe.pms.sdk.response.ProductDictResponse;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 配置表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductDictClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductDictClient.class);

    /**
     * 配置表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductDictResponseDto 接口返回的数据对象
     */
    public ProductDictResponseDto getProductDict(ProductDictRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductDictRequest request = new ProductDictRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductDict request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productDict/getProductDict";
        ProductDictResponse response = super.getRestTemplate().postForObject(url, request, ProductDictResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductDict url: " + url);
            LOG.debug("getProductDict response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 配置表查询服务-查询所有数据
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductDictResponseDto> 接口返回的数据对象
     */
    @SuppressWarnings("unchecked")
	public List<ProductDictResponseDto> getAllProductDict(ProductDictRequestDto requestDto) {
//    	Assert.notNull(requestDto);
    	
    	ProductDictRequest request = new ProductDictRequest(super.getKey(), requestDto);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getAllProductDict request: " + JsonHelper.toJson(request));
    	}
    	
    	String url = super.getServiceUrlDomain() + "services/productDict/getAllProductDict";
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductDictResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductDictResponseDto.class);
    	response.setResult(responseResult);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getAllProductDict url: " + url);
    		LOG.debug("getAllProductDict response: " + JsonHelper.toJson(response));
    	}
    	return super.getResult(response);
    }
}
