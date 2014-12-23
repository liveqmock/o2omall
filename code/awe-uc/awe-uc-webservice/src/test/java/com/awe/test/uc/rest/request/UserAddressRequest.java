package com.awe.test.uc.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.uc.rest.request.dto.UserAddressRequestDto;

/**
 * UserAddressRequest：收货地址请求参数
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
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
