package com.awe.rems.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 服务类型枚举
 * @author zyq
 * @since 2015-1-26
 */
public enum ServiceTypeEnum {
	//服务类型:1:退货:2:换货:3维修 */
	ReturnServiceType(1,"退货"),
	ExchangeServiceType(2,"换货"),
	MaintainServiceType(3,"维修");
	
	int key;
	String value;
	
	ServiceTypeEnum(int key,String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getName(int key){
		for (ServiceTypeEnum serviceType : ServiceTypeEnum.values()) {
			if(serviceType.getKey()==key){
				return serviceType.getValue();
			}
		}
		return "";
	}
	
	public static Map<Integer,String> getMap(){
		Map<Integer,String> dataMap = new HashMap<Integer,String>();
		for (ServiceTypeEnum serviceType : ServiceTypeEnum.values()) {
			dataMap.put(serviceType.getKey(), serviceType.getValue());
		}
		return dataMap;
	}
	
	public static List<EnumDataEntity> getDataList(){
		List<EnumDataEntity> dataList = new ArrayList<EnumDataEntity>();
		for (ServiceTypeEnum serviceType : ServiceTypeEnum.values()) {
			EnumDataEntity dataEntity = new EnumDataEntity();
			dataEntity.setKey(serviceType.getKey());
			dataEntity.setValue(serviceType.getValue());
			dataList.add(dataEntity);
		}
		return dataList;
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
