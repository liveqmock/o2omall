package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductSkuRequest;
import com.awe.pms.sdk.response.ProductSkuResponse;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;

/**
 * 商品SKU服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductSkuClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ProductSkuClient.class);

    /**
     * 商品SKU查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductSkuDto 对象
     */
    public ProductSkuResponseDto getProductSku(ProductSkuRequest request) {
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
}
