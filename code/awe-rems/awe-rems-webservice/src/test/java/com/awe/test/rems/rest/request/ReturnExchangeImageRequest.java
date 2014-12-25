package com.awe.test.rems.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.rems.rest.request.dto.ReturnExchangeImageRequestDto;

/**
 * ReturnExchangeImageRequest：退换货图片表请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
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
