package com.awe.test.order.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.order.rest.request.dto.OrdersRequestDto;

/**
 * OrdersRequest：订单请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrdersRequest extends HbirdSecureRequest<OrdersRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OrdersRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public OrdersRequest(String key, OrdersRequestDto content) {
        super(key, content);
    }
}