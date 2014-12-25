package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductDictRequest;
import com.awe.pms.sdk.response.ProductDictResponse;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;

/**
 * 配置表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductDictClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ProductDictClient.class);

    /**
     * 配置表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductDictDto 对象
     */
    public ProductDictResponseDto getProductDict(ProductDictRequest request) {
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
