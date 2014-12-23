package com.awe.order.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.order.sdk.request.dto.OrdersItemsRequestDto;

/**
 * OrdersItemsRequest：订单明细请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:38
 * 
 */
public class OrdersItemsRequest extends HbirdSecureRequest<OrdersItemsRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OrdersItemsRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public OrdersItemsRequest(String key, OrdersItemsRequestDto content) {
        super(key, content);
    }
}
