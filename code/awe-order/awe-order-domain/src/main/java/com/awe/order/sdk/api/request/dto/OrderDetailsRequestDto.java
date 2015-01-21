package com.awe.order.sdk.api.request.dto;

import java.util.List;
import java.util.Map;

import com.hbird.common.sdk.api.dto.HbirdDto;

public class OrderDetailsRequestDto extends HbirdDto{
	
	 /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /**订单表*/
    private OrdersRequestDto ordersRequestDto;
    
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
