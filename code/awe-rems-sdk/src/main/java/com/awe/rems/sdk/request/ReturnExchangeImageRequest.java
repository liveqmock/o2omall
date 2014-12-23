package com.awe.rems.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.rems.sdk.request.dto.ReturnExchangeImageRequestDto;

/**
 * ReturnExchangeImageRequest：退换货图片表请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:18
 * 
 */
public class ReturnExchangeImageRequest extends HbirdSecureRequest<ReturnExchangeImageRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ReturnExchangeImageRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ReturnExchangeImageRequest(String key, ReturnExchangeImageRequestDto content) {
        super(key, content);
    }
}
