package com.awe.rems.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 售后单审核状态枚举
 * @author zyq
 * @since 2014-11-10
 */
public enum AuditStatusEnum {
	UserSubmitStatus(10,"用户已提交"),
	AuditSuccessStatus(20,"审核通过"),
	RefundSubmitStatus(30,"退款已提交"),
	AuditFailStatus(25,"审核不通过"),
	CompleteStatus(40,"处理完成");
	
	int key;
	String value;
	
	AuditStatusEnum(int key,String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getName(int key){
		for (AuditStatusEnum splitStatus : AuditStatusEnum.values()) {
			if(splitStatus.getKey()==key){
				return splitStatus.getValue();
			}
		}
		return "";
	}
	
	public static Map<Integer,String> getMap(){
		Map<Integer,String> dataMap = new HashMap<Integer,String>();
		for (AuditStatusEnum splitStatus : AuditStatusEnum.values()) {
			dataMap.put(splitStatus.getKey(), splitStatus.getValue());
		}
		return dataMap;
	}
	
	public static List<EnumDataEntity> getDataList(){
		List<EnumDataEntity> dataList = new ArrayList<EnumDataEntity>();
		for (AuditStatusEnum splitStatus : AuditStatusEnum.values()) {
			EnumDataEntity dataEntity = new EnumDataEntity();
			dataEntity.setKey(splitStatus.getKey());
			dataEntity.setValue(splitStatus.getValue());
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
