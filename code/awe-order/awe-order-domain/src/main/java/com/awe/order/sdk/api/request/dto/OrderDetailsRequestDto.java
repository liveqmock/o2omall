package com.awe.order.sdk.api.request.dto;

import java.util.List;

import com.hbird.common.sdk.api.dto.HbirdDto;

public class OrderDetailsRequestDto extends HbirdDto{
	
	 /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**订单表*/
    private OrdersRequestDto ordersRequestDto;
    
    /** 订单item表*/
    private List<OrdersItemsRequestDto> listOrdersItemsRequestDto;
    
    
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
}
