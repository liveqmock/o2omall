package com.awe.uc.sdk.request;

import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.hbird.common.sdk.api.request.HbirdSecureRequest;

/**
 * PasswordModifyRequest 用户密码修改的Request 对象
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class PasswordModifyRequest extends HbirdSecureRequest<PasswordModifyRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public PasswordModifyRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public PasswordModifyRequest(String key, PasswordModifyRequestDto content) {
        super(key, content);
    }
}
