package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 发票类型
 *EnumInvoiceType	
 *
 * @author js
 * @version：2014年12月31日 下午3:35:07
 */
public enum EnumInvoiceType {
	a("1","普通发票"),
	b("2","增值税发票");
	
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
	
	EnumInvoiceType(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumInvoiceType invoiceType : EnumInvoiceType.values()) {
            if (invoiceType.getStatus().equals(status)) {
                return invoiceType.getName();
            }
        }
        return "";
    }
    
    public static Object MapEnum(){
    	Map<String, String> map = new HashMap<String, String>();
		for(EnumInvoiceType invoiceType : EnumInvoiceType.values()){
			map.put( invoiceType.getStatus(),invoiceType.getName());
		}
		return map;
    }
}
