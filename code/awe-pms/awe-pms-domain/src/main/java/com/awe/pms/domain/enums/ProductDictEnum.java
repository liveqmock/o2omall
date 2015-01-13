package com.awe.pms.domain.enums;


/**
 * @author zhc
 * 
 * 配置表枚举
 */
public enum ProductDictEnum {
	
	YN_TYPE(1, "是否：1，是；0，否；"),
	PMS_TYPE(10, "商品类型：1，原装进口；2，进口奶源；3，国产奶粉"),
	AUDIT_TYPE(20, "商家审核状态：0，待审核；10，审核中；20，审核成功；30，审核驳回；"),
	MODE_TYPE(30, "经营模式 ：10，三方；20，自营"),
	APPLICABLE_STEP_TYPE(40, "适用阶段 ：10，准备怀孕；20，0-3个月；30，3-6个月；40，6-12个月；50，1-2岁；"),
	PACK_TYPE(50, "包装方式 ：10，桶装；20，罐装；30，袋装；40，无；"),
	COLOR_TYPE(60, "颜色 ：10，红；20，黄；30，蓝；40，绿；50，黑；60，白；"),
	METHOD_TYPE(70, "食用方式 ：0，无；10，直接食用；20，冲配；"),
	SALE_STATUS_TYPE(80, "上下架状态 ：1，上架；0，下架；");

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
