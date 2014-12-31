package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付类型
 *EnumPayType	
 *
 * @author js
 * @version：2014年12月31日 下午3:23:48
 */
public enum EnumPayType {
	a("1","货到付款"),
	b("2","在线支付"),
	c("3","公司转账"),
	e("4","邮件汇款");
	
	private String status;
	private String name;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	EnumPayType(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumPayType enumPayType : EnumPayType.values()) {
            if (enumPayType.getStatus().equals(status)) {
                return enumPayType.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumPayType enumPayType : EnumPayType.values()){
			map.put( enumPayType.getStatus(),enumPayType.getName());
		}
		return map;
    }
}
