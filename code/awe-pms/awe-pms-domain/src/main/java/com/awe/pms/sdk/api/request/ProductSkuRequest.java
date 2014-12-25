package com.awe.pms.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pms.sdk.api.request.dto.ProductSkuRequestDto;

/**
 * ProductSkuRequest：商品SKU请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
public class ProductSkuRequest extends HbirdSecureRequest<ProductSkuRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductSkuRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductSkuRequest(String key, ProductSkuRequestDto content) {
        super(key, content);
    }
}
