package com.awe.test.rems.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeRequestDto;

/**
 * ReturnExchangeRequest：退换货请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:18
 * 
 */
public class ReturnExchangeRequest extends HbirdSecureRequest<ReturnExchangeRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ReturnExchangeRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ReturnExchangeRequest(String key, ReturnExchangeRequestDto content) {
        super(key, content);
    }
}
