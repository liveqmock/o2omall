package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否送货前电话确定
 *EnumIsTal	
 *
 * @author js
 * @version：2014年12月31日 下午2:41:07
 */
public enum EnumDate {
	a("1","只工作日送货(双休日、假日不用送)"),
	b("2","工作日、双休日与假日均可送货"),
	c("3","只双休日、假日送货(工作日不用送)");
	
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
	
	EnumDate(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumDate tal : EnumDate.values()) {
            if (tal.getStatus().equals(status)) {
                return tal.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumDate tal : EnumDate.values()){
			map.put( tal.getStatus(),tal.getName());
		}
		return map;
    }
}
