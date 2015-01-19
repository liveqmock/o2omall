package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款单状态
 *EnumOrderCancelStatus	
 *
 * @author js
 * @version：2015年1月18日 下午4:40:58
 */
public enum EnumOrderCancelStatus {
	//501:待审核;502:退款中;503:已退款;504:审核驳回;505:退款失败;506:已取消
	a("501","待审核"),
	b("502","退款中"),
	c("503","已退款"),
	d("504","审核驳回"),
	e("505","退款失败"),
	f("506","已取消");

	
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
	
	EnumOrderCancelStatus(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumOrderCancelStatus CancelSta : EnumOrderCancelStatus.values()) {
            if (CancelSta.getStatus().equals(status)) {
                return CancelSta.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumOrderCancelStatus CancelSta : EnumOrderCancelStatus.values()){
			map.put( CancelSta.getStatus(),CancelSta.getName());
		}
		return map;
    }

}
