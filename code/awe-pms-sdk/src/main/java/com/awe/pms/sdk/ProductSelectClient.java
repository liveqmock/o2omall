package com.awe.pms.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductSelectRequest;
import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.response.ProductSelectResponse;
import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 商品查询综合表服务的客户端
 * 
 * @author ljz
 * @version 2015-1-21 10:47:35
 * 
 */
public class ProductSelectClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductSelectClient.class);

    /**
     * 商品查询综合表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductSelectResponseDto 接口返回的数据对象
     */
    public ProductSelectResponseDto getProductSelect(ProductSelectRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductSelectRequest request = new ProductSelectRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductSelect request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productSelect/getProductSelect";
        ProductSelectResponse response = super.getRestTemplate().postForObject(url, request, ProductSelectResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductSelect url: " + url);
            LOG.debug("getProductSelect response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 根据条件查询商品信息服务
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductSelectResponseDto> 接口返回的数据对象
     */
    @SuppressWarnings("unchecked")
	public List<ProductSelectResponseDto> getProductSelects(ProductSelectRequestDto requestDto) {
//    	Assert.notNull(requestDto);
    	
    	ProductSelectRequest request = new ProductSelectRequest(super.getKey(), requestDto);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductSelects request: " + JsonHelper.toJson(request));
    	}
    	
    	String url = super.getServiceUrlDomain() + "services/productSelect/getProductSelects";
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductSelectResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductSelectResponseDto.class);
    	response.setResult(responseResult);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductSelects url: " + url);
    		LOG.debug("getProductSelects response: " + JsonHelper.toJson(response));
    	}
    	return super.getResult(response);
    }
}
