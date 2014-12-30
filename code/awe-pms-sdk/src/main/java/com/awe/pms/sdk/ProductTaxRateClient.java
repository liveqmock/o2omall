package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.ProductTaxRateRequest;
import com.awe.pms.sdk.request.dto.ProductTaxRateRequestDto;
import com.awe.pms.sdk.response.ProductTaxRateResponse;
import com.awe.pms.sdk.response.dto.ProductTaxRateResponseDto;

/**
 * 税率服务的客户端
 * 
 * @author ljz
 * @version 2014-12-29 17:29:38
 * 
 */
public class ProductTaxRateClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductTaxRateClient.class);

    /**
     * 税率查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductTaxRateResponseDto 接口返回的数据对象
     */
    public ProductTaxRateResponseDto getProductTaxRate(ProductTaxRateRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductTaxRateRequest request = new ProductTaxRateRequest(super.getKey(), requestDto);
        
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
