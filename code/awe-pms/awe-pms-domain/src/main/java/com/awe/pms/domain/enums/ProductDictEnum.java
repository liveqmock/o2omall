package com.awe.pms.domain.enums;


/**
 * @author zhc
 * 
 * 配置表枚举
 */
public enum ProductDictEnum {
	
	PMS_TYPE(10, "商品类型：1，进口；2，国内");

	int type;
    String desc;

    ProductDictEnum(int type, String desc){
    	this.type = type;
        this.desc = desc;
    }

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
