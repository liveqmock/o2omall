package com.awe.order.domain;

import java.util.List;

/**
 * 订单详情表
 *OrderDetails	
 *
 * @author js
 * @version：2015年1月7日 上午10:45:04
 */
public class OrderDetails implements java.io.Serializable{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;
	/**订单表*/
	private Orders orders;
	/**订单管理商品*/
	private List<OrdersItems> ordersItemsList;
	/**订单日志*/
	private OrderLog orderLog;
	
	public OrderDetails(Orders orders, List<OrdersItems> ordersItemsList,
			OrderLog orderLog) {
		this.orders = orders;
		this.ordersItemsList = ordersItemsList;
		this.orderLog = orderLog;
	}
	/**
	 * @return the orders
	 */
	public Orders getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	/**
	 * @return the ordersItemsList
	 */
	public List<OrdersItems> getOrdersItemsList() {
		return ordersItemsList;
	}
	/**
	 * @param ordersItemsList the ordersItemsList to set
	 */
	public void setOrdersItemsList(List<OrdersItems> ordersItemsList) {
		this.ordersItemsList = ordersItemsList;
	}
	/**
	 * @return the orderLog
	 */
	public OrderLog getOrderLog() {
		return orderLog;
	}
	/**
	 * @param orderLog the orderLog to set
	 */
	public void setOrderLog(OrderLog orderLog) {
		this.orderLog = orderLog;
	} 
	
}
