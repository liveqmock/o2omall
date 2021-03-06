package com.awe.test.pms.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.pms.rest.request.dto.ProductBrandRequestDto;

/**
 * ProductBrandRequest：商品类别品牌请求参数
 * 
 * @author ljz
 * @version 2014-12-25 14:47:41
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
