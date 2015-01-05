package com.awe.test.order.rest.response;

import java.util.List;

import com.awe.order.sdk.api.response.dto.OrdersResponseDto;
import com.hbird.common.sdk.api.response.HbirdResponse;

/**
 * OrdersResponse：订单返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class OrdersResponseList extends HbirdResponse<List<OrdersResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
