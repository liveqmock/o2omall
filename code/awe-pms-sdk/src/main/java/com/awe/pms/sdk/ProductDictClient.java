package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductDictRequest;
import com.awe.pms.sdk.request.dto.ProductDictRequestDto;
import com.awe.pms.sdk.response.ProductDictResponse;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;

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
}
