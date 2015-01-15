package com.awe.order.sdk.api.request;

import com.awe.order.sdk.api.request.dto.OrderCancelRequestDto;
import com.hbird.common.sdk.api.request.HbirdPageSecureRequest;
import com.hbird.common.utils.page.PageUtil;

/**
 * OrderCancelRequest：订单取消请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class OrderCancelRequest extends HbirdPageSecureRequest<OrderCancelRequestDto> {

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
    
    public OrderCancelRequest(String key, OrderCancelRequestDto content, PageUtil pageUtil) {
        super(key, content, pageUtil);
    }
}
