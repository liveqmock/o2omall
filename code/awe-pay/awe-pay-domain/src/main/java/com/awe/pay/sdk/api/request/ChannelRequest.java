package com.awe.pay.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pay.sdk.api.request.dto.ChannelRequestDto;

/**
 * ChannelRequest：支付通道请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public class ChannelRequest extends HbirdSecureRequest<ChannelRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ChannelRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ChannelRequest(String key, ChannelRequestDto content) {
        super(key, content);
    }
}
