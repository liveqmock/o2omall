package com.awe.pms.domain.enums;

/**
 * @author zhc
 * @email  you know
 * @version 2014-12-26 上午11:32:47 
 */
public enum ProductCategoryEnum {

	CATEGORY_ONE(1, "一级品类"),
	CATEGORY_TWO(2, "二级品类"),
	CATEGORY_THREE(3, "三级品类");

	int key;
    String value;

    ProductCategoryEnum(int key, String value){
        this.key = key;
        this.value = value;
    }
    
	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
