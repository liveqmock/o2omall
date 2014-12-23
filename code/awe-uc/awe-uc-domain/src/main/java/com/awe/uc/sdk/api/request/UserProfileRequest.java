package com.awe.uc.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.uc.sdk.api.request.dto.UserProfileRequestDto;

/**
 * UserProfileRequest：用户基本信息请求参数
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserProfileRequest extends HbirdSecureRequest<UserProfileRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public UserProfileRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public UserProfileRequest(String key, UserProfileRequestDto content) {
        super(key, content);
    }
}
