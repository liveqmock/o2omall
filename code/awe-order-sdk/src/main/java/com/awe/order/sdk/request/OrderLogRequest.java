package com.awe.order.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.order.sdk.request.dto.OrderLogRequestDto;

/**
 * OrderLogRequest：订单日志请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class OrderLogRequest extends HbirdSecureRequest<OrderLogRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OrderLogRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public OrderLogRequest(String key, OrderLogRequestDto content) {
        super(key, content);
    }
}
