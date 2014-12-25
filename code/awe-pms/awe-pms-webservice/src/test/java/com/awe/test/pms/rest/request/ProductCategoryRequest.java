package com.awe.test.pms.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.pms.rest.request.dto.ProductCategoryRequestDto;

/**
 * ProductCategoryRequest：商品类别请求参数
 * 
 * @author ljz
 * @version 2014-12-25 14:47:41
 * 
 */
public class ProductCategoryRequest extends HbirdSecureRequest<ProductCategoryRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductCategoryRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductCategoryRequest(String key, ProductCategoryRequestDto content) {
        super(key, content);
    }
}
