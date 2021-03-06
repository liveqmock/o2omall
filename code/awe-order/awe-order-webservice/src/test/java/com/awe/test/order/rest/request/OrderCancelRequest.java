package com.awe.test.order.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.order.rest.request.dto.OrderCancelRequestDto;

/**
 * OrderCancelRequest：订单取消请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrderCancelRequest extends HbirdSecureRequest<OrderCancelRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OrderCancelRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public OrderCancelRequest(String key, OrderCancelRequestDto content) {
        super(key, content);
    }
}
