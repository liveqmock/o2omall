package com.awe.rems.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.rems.sdk.api.request.dto.ReturnExchangeImageRequestDto;

/**
 * ReturnExchangeImageRequest：退换货图片表请求参数
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
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
