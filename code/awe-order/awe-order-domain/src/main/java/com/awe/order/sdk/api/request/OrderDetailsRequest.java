package com.awe.order.sdk.api.request;

import com.awe.order.sdk.api.request.dto.OrderDetailsRequestDto;
import com.hbird.common.sdk.api.request.HbirdSecureRequest;

public class OrderDetailsRequest  extends HbirdSecureRequest<OrderDetailsRequestDto>{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;

	public OrderDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailsRequest(String key, OrderDetailsRequestDto content) {
		super(key, content);
		// TODO Auto-generated constructor stub
	}
}
