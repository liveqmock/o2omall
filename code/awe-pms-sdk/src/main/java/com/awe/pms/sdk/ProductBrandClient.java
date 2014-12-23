package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductBrandRequest;
import com.awe.pms.sdk.response.ProductBrandResponse;
import com.awe.pms.sdk.response.dto.ProductBrandResponseDto;

/**
 * 商品类别品牌服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductBrandClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ProductBrandClient.class);

    /**
     * 商品类别品牌查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductBrandDto 对象
     */
    public ProductBrandResponseDto getProductBrand(ProductBrandRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductBrand request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productBrand/getProductBrand";
        ProductBrandResponse response = super.getRestTemplate().postForObject(url, request, ProductBrandResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductBrand url: " + url);
            LOG.debug("getProductBrand response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
