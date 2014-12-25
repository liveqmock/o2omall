package com.awe.test.pms.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.pms.rest.request.dto.ProductDictRequestDto;

/**
 * ProductDictRequest：配置表请求参数
 * 
 * @author ljz
 * @version 2014-12-25 14:47:41
 * 
 */
public class ProductDictRequest extends HbirdSecureRequest<ProductDictRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ProductDictRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ProductDictRequest(String key, ProductDictRequestDto content) {
        super(key, content);
    }
}
