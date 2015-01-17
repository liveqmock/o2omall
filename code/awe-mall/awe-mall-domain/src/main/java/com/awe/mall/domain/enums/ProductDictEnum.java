package com.awe.mall.domain.enums;


/**
 * @author zhc
 * 
 * 配置表枚举
 */
public enum ProductDictEnum {
	
	YN_TYPE(1, "ynTypes", "是否：1，是；0，否；"),
	PMS_TYPE(10, "pmsTypes", "商品类型：1，原装进口；2，进口奶源；3，国产奶粉"),
	AUDIT_TYPE(20, "auditTypes", "商家审核状态：0，待审核；10，审核中；20，审核成功；30，审核驳回；"),
	MODE_TYPE(30, "modeTypes", "经营模式 ：10，三方；20，自营"),
	APPLICABLE_STEP_TYPE(40, "applicableStepTypes", "适用阶段 ：10，准备怀孕；20，0-3个月；30，3-6个月；40，6-12个月；50，1-2岁；"),
	PACK_TYPE(50, "packTypes", "包装方式 ：10，桶装；20，罐装；30，袋装；40，无；"),
	COLOR_TYPE(60, "colorTypes", "颜色 ：10，红；20，黄；30，蓝；40，绿；50，黑；60，白；"),
	METHOD_TYPE(70, "mothodTypes", "食用方式 ：0，无；10，直接食用；20，冲配；"),
	SALE_STATUS_TYPE(80, "saleStatusTypes", "上下架状态 ：1，上架；0，下架；");

	int type;
	String attr;
    String desc;

    ProductDictEnum(int type, String attr, String desc){
    	this.type = type;
    	this.attr = attr;
        this.desc = desc;
    }
    
    public static String getAttrByType(Integer type) {
    	if (type != null) {
    		for (ProductDictEnum productDictEnum : ProductDictEnum.values()) {
    			if (productDictEnum.getType() == type) {
    				return productDictEnum.getAttr();
    			}
    		}
    	}
    	return null;
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
	 * @return the attr
	 */
	public String getAttr() {
		return attr;
	}

	/**
	 * @param attr the attr to set
	 */
	public void setAttr(String attr) {
		this.attr = attr;
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
