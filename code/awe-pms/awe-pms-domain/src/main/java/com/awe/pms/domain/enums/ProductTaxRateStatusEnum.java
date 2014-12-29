package com.awe.pms.domain.enums;

/**
 * @author zhc
 * @email  you know
 * @version 2014-12-26 上午11:32:47 
 */
public enum ProductTaxRateStatusEnum {

	STATUS_Y(1, "启用"),
	STATUS_N(2, "禁用");

	int key;
    String value;

    ProductTaxRateStatusEnum(int key, String value){
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
