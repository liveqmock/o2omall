package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductTaxRateRequest;
import com.awe.pms.sdk.response.ProductTaxRateResponse;
import com.awe.pms.sdk.response.dto.ProductTaxRateResponseDto;

/**
 * 税率服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 14:47:42
 * 
 */
public class ProductTaxRateClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ProductTaxRateClient.class);

    /**
     * 税率查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductTaxRateDto 对象
     */
    public ProductTaxRateResponseDto getProductTaxRate(ProductTaxRateRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductTaxRate request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productTaxRate/getProductTaxRate";
        ProductTaxRateResponse response = super.getRestTemplate().postForObject(url, request, ProductTaxRateResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductTaxRate url: " + url);
            LOG.debug("getProductTaxRate response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
