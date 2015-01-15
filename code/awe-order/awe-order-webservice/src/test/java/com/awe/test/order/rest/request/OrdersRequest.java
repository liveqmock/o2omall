package com.awe.test.order.rest.request;

import com.awe.test.order.rest.request.dto.OrdersRequestDto;
import com.hbird.common.sdk.api.request.HbirdPageSecureRequest;
import com.hbird.common.utils.page.PageUtil;

/**
 * OrdersRequest：订单请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class OrdersRequest extends HbirdPageSecureRequest<OrdersRequestDto> {

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
    /**
     * 
     * @param key
     * @param content
     * @param pageUtil
     */
    public OrdersRequest(String key, OrdersRequestDto content,PageUtil pageUtil) {
        super(key, content, pageUtil);
        
    }
}
