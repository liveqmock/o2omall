package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductRequest;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.response.ProductResponse;
import com.awe.pms.sdk.response.dto.ProductResponseDto;

/**
 * 商品信息服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
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
}
