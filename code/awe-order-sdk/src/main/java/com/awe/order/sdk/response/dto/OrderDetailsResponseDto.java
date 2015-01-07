package com.awe.order.sdk.response.dto;

import java.util.List;

import com.hbird.common.sdk.api.dto.HbirdDto;
/**
 * 
 *OrderDetailsResponseDto	
 *
 * @author js
 * @version：2015年1月7日 下午3:18:21
 */
public class OrderDetailsResponseDto extends HbirdDto{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
	/**订单表*/
	private OrdersResponseDto ordersResponseDto;
	/**订单详情表*/
	private List<OrdersItemsResponseDto> listOrdersItemsesponseDto;



	/**
	 * @return the listOrdersItemsesponseDto
	 */
	public List<OrdersItemsResponseDto> getListOrdersItemsesponseDto() {
		return listOrdersItemsesponseDto;
	}
	/**
	 * @param listOrdersItemsesponseDto the listOrdersItemsesponseDto to set
	 */
	public void setListOrdersItemsesponseDto(
			List<OrdersItemsResponseDto> listOrdersItemsesponseDto) {
		this.listOrdersItemsesponseDto = listOrdersItemsesponseDto;
	}
	/**
	 * @return the ordersResponseDto
	 */
	public OrdersResponseDto getOrdersResponseDto() {
		return ordersResponseDto;
	}
	/**
	 * @param ordersResponseDto the ordersResponseDto to set
	 */
	public void setOrdersResponseDto(OrdersResponseDto ordersResponseDto) {
		this.ordersResponseDto = ordersResponseDto;
	}
	/**
	 * @return the orderDetailsResponseDto
	 */
}
