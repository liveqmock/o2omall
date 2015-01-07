package com.awe.order.sdk.request;

import com.awe.order.sdk.request.dto.OrderDetailsRequestDto;
import com.hbird.common.sdk.api.request.HbirdSecureRequest;

/**
 * 订单相关参数
 *OrdersDetailsRequest	
 *
 * @author js
 * @version：2015年1月7日 下午3:06:45
 */
public class OrdersDetailsRequest extends HbirdSecureRequest<OrderDetailsRequestDto>{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;

	public OrdersDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersDetailsRequest(String key, OrderDetailsRequestDto content) {
		super(key, content);
		// TODO Auto-generated constructor stub
	}
	

}
