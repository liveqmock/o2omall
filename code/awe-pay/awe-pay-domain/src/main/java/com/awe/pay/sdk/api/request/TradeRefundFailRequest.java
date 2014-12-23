package com.awe.pay.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pay.sdk.api.request.dto.TradeRefundFailRequestDto;

/**
 * TradeRefundFailRequest：正向交易及逆向退款失败表请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public class TradeRefundFailRequest extends HbirdSecureRequest<TradeRefundFailRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public TradeRefundFailRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public TradeRefundFailRequest(String key, TradeRefundFailRequestDto content) {
        super(key, content);
    }
}
