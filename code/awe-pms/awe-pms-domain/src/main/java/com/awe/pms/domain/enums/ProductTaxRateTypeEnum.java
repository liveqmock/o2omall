package com.awe.pms.domain.enums;

/**
 * @author zhc
 * @email  you know
 * @version 2014-12-26 上午11:32:47 
 */
public enum ProductTaxRateTypeEnum {

	TAX_RATE_TYPE_1(1, "商品品类"),
	TAX_RATE_TYPE_2(2, "商品编号");

	int key;
    String value;

    ProductTaxRateTypeEnum(int key, String value){
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
