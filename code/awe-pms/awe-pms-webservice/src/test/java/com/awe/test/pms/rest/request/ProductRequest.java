package com.awe.test.pms.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.pms.rest.request.dto.ProductRequestDto;

/**
 * ProductRequest：商品信息请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class ProductRequest extends HbirdSecureRequest<ProductRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductRequest(String key, ProductRequestDto content) {
        super(key, content);
    }
}
