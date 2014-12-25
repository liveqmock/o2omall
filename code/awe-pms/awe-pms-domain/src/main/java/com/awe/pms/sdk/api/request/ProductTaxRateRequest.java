package com.awe.pms.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pms.sdk.api.request.dto.ProductTaxRateRequestDto;

/**
 * ProductTaxRateRequest：税率请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
public class ProductTaxRateRequest extends HbirdSecureRequest<ProductTaxRateRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductTaxRateRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductTaxRateRequest(String key, ProductTaxRateRequestDto content) {
        super(key, content);
    }
}
