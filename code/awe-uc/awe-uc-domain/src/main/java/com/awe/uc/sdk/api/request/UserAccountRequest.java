package com.awe.uc.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.uc.sdk.api.request.dto.UserAccountRequestDto;

/**
 * UserAccountRequest：用户账号请求参数
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserAccountRequest extends HbirdSecureRequest<UserAccountRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public UserAccountRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public UserAccountRequest(String key, UserAccountRequestDto content) {
        super(key, content);
    }
}
