package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付方式
 *EnumPayWay	
 *
 * @author js
 * @version：2014年12月31日 下午2:48:48
 */
public enum EnumPayWay {
	a("1","现金"),
	b("2","pos刷卡");
	
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
	
	EnumPayWay(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumPayWay payWay : EnumPayWay.values()) {
            if (payWay.getStatus().equals(status)) {
                return payWay.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumPayWay payWay : EnumPayWay.values()){
			map.put( payWay.getStatus(),payWay.getName());
		}
		return map;
    }
}
