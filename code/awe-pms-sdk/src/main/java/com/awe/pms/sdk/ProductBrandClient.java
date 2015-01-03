package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductBrandRequest;
import com.awe.pms.sdk.request.dto.ProductBrandRequestDto;
import com.awe.pms.sdk.response.ProductBrandResponse;
import com.awe.pms.sdk.response.dto.ProductBrandResponseDto;

/**
 * 商品类别品牌服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductBrandClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductBrandClient.class);

    /**
     * 商品类别品牌查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductBrandResponseDto 接口返回的数据对象
     */
    public ProductBrandResponseDto getProductBrand(ProductBrandRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductBrandRequest request = new ProductBrandRequest(super.getKey(), requestDto);
        
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
