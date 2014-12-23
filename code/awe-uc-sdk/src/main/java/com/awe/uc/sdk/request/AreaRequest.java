package com.awe.uc.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.uc.sdk.request.dto.AreaRequestDto;

/**
 * AreaRequest：三级地址请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class AreaRequest extends HbirdSecureRequest<AreaRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public AreaRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public AreaRequest(String key, AreaRequestDto content) {
        super(key, content);
    }
}
