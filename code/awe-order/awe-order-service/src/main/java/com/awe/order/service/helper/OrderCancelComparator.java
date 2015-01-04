package com.awe.order.service.helper;

import java.util.Comparator;

import com.awe.order.dto.OrderCancelDto;
/**
 * 订单取消列表按订单号排序比较器
 * @author zyq
 * @version 1.0.0.0
 * @since 2015-1-4
 */
public class OrderCancelComparator implements Comparator<OrderCancelDto> {

	public int compare(OrderCancelDto o1, OrderCancelDto o2) {
		String orderNo1 = o1.getOrderNo();
		String orderNo2 = o2.getOrderNo();
		
		return orderNo2.compareTo(orderNo1);
	}

}
