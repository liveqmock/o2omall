package com.awe.order.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态
 *EnumOrderStauts	
 *
 * @author js
 * @version：2014年12月31日 上午11:00:21
 */
public enum EnumOrderStauts {
	a("10","用户取消"),
	b("20","用户删除"),
	c("30","系统取消"),
	d("40","待付款"),
	e("50","已收款"),
	f("60","已发货"),
	g("70","已签收"),
	h("80","订单完成"),
	i("90","待拆单"),
	j("100","拆单完成"),
	k("110","订单审核"),
	l("120","待退款"),
	m("130","已退款"),
	n("140","待换货"),
	o("150","已换货"),
	p("160","已退款"),
	q("170","审核驳回");
	
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
	
    EnumOrderStauts(String status, String name) {
		this.status = status;
		this.name = name;
	}
    
    public static String getName(String status) {
        for (EnumOrderStauts printStatus : EnumOrderStauts.values()) {
            if (printStatus.getStatus().equals(status)) {
                return printStatus.getName();
            }
        }
        return "";
    }
    
	public static Map<String,String> getMap(){
		Map<String,String> dataMap = new HashMap<String,String>();
		for (EnumOrderStauts orderStatus : EnumOrderStauts.values()) {
			dataMap.put(orderStatus.getStatus(), orderStatus.getName());
		}
		return dataMap;
	}
}
