package com.awe.order.sdk.request.dto;

import java.util.List;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * 订单详情表
 *OrderDetailsRequestDto	
 *
 * @author js
 * @version：2015年1月7日 上午11:41:17
 */
public class OrderDetailsRequestDto extends HbirdDto{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;
	/**订单表*/
	private OrdersRequestDto ordersRequestDto;
	/**订单详情表*/
	private List<OrdersItemsRequestDto> listOrdersItemsRequestDto;
	/**
	 * @return the ordersRequestDto
	 */
	public OrdersRequestDto getOrdersRequestDto() {
		return ordersRequestDto;
	}
	/**
	 * @param ordersRequestDto the ordersRequestDto to set
	 */
	public void setOrdersRequestDto(OrdersRequestDto ordersRequestDto) {
		this.ordersRequestDto = ordersRequestDto;
	}
	/**
	 * @return the listOrdersItemsRequestDto
	 */
	public List<OrdersItemsRequestDto> getListOrdersItemsRequestDto() {
		return listOrdersItemsRequestDto;
	}
	/**
	 * @param listOrdersItemsRequestDto the listOrdersItemsRequestDto to set
	 */
	public void setListOrdersItemsRequestDto(
			List<OrdersItemsRequestDto> listOrdersItemsRequestDto) {
		this.listOrdersItemsRequestDto = listOrdersItemsRequestDto;
	}
   
}
