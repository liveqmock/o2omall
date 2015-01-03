package com.awe.pms.domain.enums;


/**
 * @author zhc
 * 
 * 配置表枚举
 */
public enum ProductDictEnum {
	
	PMS_TYPE(10, "商品类型：1，原装进口；2，进口奶源；3，国产奶粉"),
	AUDIT_TYPE(20, "商家审核状态：0，待审核；10，审核中；20，审核成功；30，审核驳回；"),
	MODE_TYPE(30, "经营模式 ：10，三方；20，自营");

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
