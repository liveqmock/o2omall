package com.awe.pms.utils.enums;


/**
 * @author zhc
 * 
 * 商品编码枚举
 */
public enum CodeEnum {
	
	PRODUCT_NO_S(10, 1000000000L),
	PRODUCT_NO_Z(20, 100000L);

	int type;
    Long code;

    CodeEnum(int type, Long code){
    	this.type = type;
        this.code = code;
    }
    
    public static Long getCode(int mode) {
    	for (CodeEnum codeEnum : CodeEnum.values()) {
    		if (codeEnum.getType() == mode) {
    			return codeEnum.getCode();
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
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
}
