package com.awe.pms.sdk.api.request;

import com.awe.pms.sdk.api.request.dto.ProductSelectRequestDto;
import com.hbird.common.sdk.api.request.HbirdPageSecureRequest;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductSelectRequest：商品查询综合表请求参数
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
public class ProductSelectRequest extends HbirdPageSecureRequest<ProductSelectRequestDto> {

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
    
    /**
     * @param key
     * @param content
     * @param pageUtil
     */
    public ProductSelectRequest(String key, ProductSelectRequestDto content,PageUtil pageUtil) {
        super(key, content, pageUtil);
    }
}
