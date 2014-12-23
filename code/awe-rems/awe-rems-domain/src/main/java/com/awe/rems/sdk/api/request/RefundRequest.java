package com.awe.rems.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.rems.sdk.api.request.dto.RefundRequestDto;

/**
 * RefundRequest：退款表请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:15
 * 
 */
public class RefundRequest extends HbirdSecureRequest<RefundRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public RefundRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public RefundRequest(String key, RefundRequestDto content) {
        super(key, content);
    }
}
