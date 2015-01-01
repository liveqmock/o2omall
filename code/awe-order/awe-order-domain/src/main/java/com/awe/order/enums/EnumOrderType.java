package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类型
 *EnumOrderType	
 *
 * @author js
 * @version：2014年12月31日 下午2:39:35
 */
public enum EnumOrderType {
	a("100","实物订单"),
	b("200","虚拟订单");
	
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
	
	EnumOrderType(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumOrderType type : EnumOrderType.values()) {
            if (type.getStatus().equals(status)) {
                return type.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumOrderType type : EnumOrderType.values()){
			map.put( type.getStatus(),type.getName());
		}
		return map;
    }
}
