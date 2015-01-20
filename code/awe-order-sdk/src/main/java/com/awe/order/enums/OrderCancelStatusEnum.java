package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderCancelStatusEnum {
	WaitAudit_CancelStatus(501,"待审核"),
	Refunding_CancelStatus(502,"退款中"),
	Refunded_CancelStatus(503,"已退款"),
	Reject_CancelStatus(503,"审核驳回"),
	RefundFail_CancelStatus(504,"退款失败");
	
	int key;
	String value;
	
	OrderCancelStatusEnum(int key,String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getName(int key){
		for (OrderCancelStatusEnum orderCancelStatus : OrderCancelStatusEnum.values()) {
			if(orderCancelStatus.getKey()==key){
				return orderCancelStatus.getValue();
			}
		}
		return "";
	}
	
	public static Map<Integer,String> getMap(){
		Map<Integer,String> dataMap = new HashMap<Integer,String>();
		for (OrderCancelStatusEnum orderCancelStatus : OrderCancelStatusEnum.values()) {
			dataMap.put(orderCancelStatus.getKey(), orderCancelStatus.getValue());
		}
		return dataMap;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
