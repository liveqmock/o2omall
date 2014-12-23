package com.awe.order.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;

/**
 * ShoppingCartRequest：购物车请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class ShoppingCartRequest extends HbirdSecureRequest<ShoppingCartRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ShoppingCartRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ShoppingCartRequest(String key, ShoppingCartRequestDto content) {
        super(key, content);
    }
}
