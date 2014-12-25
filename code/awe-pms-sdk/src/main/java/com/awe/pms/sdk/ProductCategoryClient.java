package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductCategoryRequest;
import com.awe.pms.sdk.response.ProductCategoryResponse;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;

/**
 * 商品类别服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductCategoryClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ProductCategoryClient.class);

    /**
     * 商品类别查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductCategoryDto 对象
     */
    public ProductCategoryResponseDto getProductCategory(ProductCategoryRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductCategory request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productCategory/getProductCategory";
        ProductCategoryResponse response = super.getRestTemplate().postForObject(url, request, ProductCategoryResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductCategory url: " + url);
            LOG.debug("getProductCategory response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
