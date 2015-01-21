package com.awe.order.sdk.response.dto;

import java.util.Map;

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
	/**存放skuNO和数据*/
	private Map<String,String> mapSC; 
	/**当前用户登录IP*/
	private String ipString;
	
	/**
	 * @return the ipString
	 */
	public String getIpString() {
		return ipString;
	}
	/**
	 * @param ipString the ipString to set
	 */
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	/**
	 * @return the mapSC
	 */
	public Map<String, String> getMapSC() {
		return mapSC;
	}
	/**
	 * @param mapSC the mapSC to set
	 */
	public void setMapSC(Map<String, String> mapSC) {
		this.mapSC = mapSC;
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
