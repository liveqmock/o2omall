package com.awe.pms.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;

/**
 * ProductSelectRequest：商品查询综合表请求参数
 * 
 * @author ljz
 * @version 2015-1-21 10:47:35
 * 
 */
public class ProductSelectRequest extends HbirdSecureRequest<ProductSelectRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductSelectRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductSelectRequest(String key, ProductSelectRequestDto content) {
        super(key, content);
    }
}
