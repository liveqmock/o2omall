package com.awe.uc.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;

/**
 * UserAddressRequest：收货地址请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserAddressRequest extends HbirdSecureRequest<UserAddressRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public UserAddressRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public UserAddressRequest(String key, UserAddressRequestDto content) {
        super(key, content);
    }
}
