package com.awe.pms.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pms.sdk.api.request.dto.ProductBrandRequestDto;

/**
 * ProductBrandRequest：商品类别品牌请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
public class ProductBrandRequest extends HbirdSecureRequest<ProductBrandRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductBrandRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductBrandRequest(String key, ProductBrandRequestDto content) {
        super(key, content);
    }
}
