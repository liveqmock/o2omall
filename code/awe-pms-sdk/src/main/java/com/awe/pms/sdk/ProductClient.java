package com.awe.pms.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductRequest;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.response.ProductResponse;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 商品信息服务的客户端
 * 
 * @author ljz
 * @version 2015-1-4 16:09:20
 * 
 */
public class ProductClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductClient.class);

    /**
     * 商品信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductResponseDto 接口返回的数据对象
     */
    public ProductResponseDto getProduct(ProductRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductRequest request = new ProductRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProduct request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/product/getProduct";
        ProductResponse response = super.getRestTemplate().postForObject(url, request, ProductResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProduct url: " + url);
            LOG.debug("getProduct response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 根据条件查询商品信息服务
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductResponseDto> 接口返回的数据对象
     */
    public List<ProductResponseDto> getProducts(ProductRequestDto requestDto) {
//    	Assert.notNull(requestDto);
    	
    	ProductRequest request = new ProductRequest(super.getKey(), requestDto);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProduct request: " + JsonHelper.toJson(request));
    	}
    	
    	String url = super.getServiceUrlDomain() + "services/product/getProducts";
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductResponseDto.class);
    	response.setResult(responseResult);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProduct url: " + url);
    		LOG.debug("getProduct response: " + JsonHelper.toJson(response));
    	}
    	return super.getResult(response);
    }
}
