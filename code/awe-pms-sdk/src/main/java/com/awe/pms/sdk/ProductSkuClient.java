package com.awe.pms.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductSkuRequest;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.ProductSkuResponse;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 商品SKU服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductSkuClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductSkuClient.class);

    /**
     * 商品SKU查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductSkuResponseDto 接口返回的数据对象
     */
    public ProductSkuResponseDto getProductSku(ProductSkuRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductSkuRequest request = new ProductSkuRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductSku request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productSku/getProductSku";
        ProductSkuResponse response = super.getRestTemplate().postForObject(url, request, ProductSkuResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductSku url: " + url);
            LOG.debug("getProductSku response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 商品SKU查询服务--集合
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductSkuResponseDto> 接口返回的数据对象
     */
    @SuppressWarnings("unchecked")
	public List<ProductSkuResponseDto> getProductSkus(ProductSkuRequestDto requestDto) {
    	Assert.notNull(requestDto);
    	
    	ProductSkuRequest request = new ProductSkuRequest(super.getKey(), requestDto);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductSkus request: " + JsonHelper.toJson(request));
    	}
    	
    	String url = super.getServiceUrlDomain() + "services/productSku/getProductSkus";
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductSkuResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductSkuResponseDto.class);
    	response.setResult(responseResult);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductSkus url: " + url);
    		LOG.debug("getProductSkus response: " + JsonHelper.toJson(response));
    	}
    	return super.getResult(response);
    }
}
