package com.awe.order.dto;

import java.util.Date;
import java.util.List;

import com.awe.order.domain.OrdersItems;

/**
 * OrderCancelDto：订单取消Dto
 * 
 * @author zyq
 * @version 2015-1-3
 * 
 */
public class OrderCancelDto implements java.io.Serializable{
	/** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /** 自增id */
    private Long id; 
    /** 退款单号 */
    private String refund; 
    /** 501:待审核;502:退款中;503:已退款;503:审核驳回;504:退款失败; */
    private Integer status; 
    /** 订单编号 */
    private String orderNo; 
    /** 退款金额 */
    private Double refundAmount; 
    /** 创建时间 */
    private Date createTime; 
    /**订单取消明细表集合*/
    private List<OrdersItems> ordersItemsList;
    /**支付方式 1:货到付款;2:在线支付;3:公司转账;4:邮局汇款 */
    private Integer payWay;
    /**用户ID*/
    private Long userId;
    /** 销售商 */
    private String seller; 
    /** 销售商编号*/
    private String sellerNo;
    
    /** sku编号 */
    private String skuNo; 
    /** 商品编号 */
    private String productNo; 
    /** 商品个数 */
    private Integer count; 
    /** sku名称 */
    private String skuName; 
    /** 商品主图 */
    private String imgUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<OrdersItems> getOrdersItemsList() {
		return ordersItemsList;
	}
	public void setOrdersItemsList(List<OrdersItems> ordersItemsList) {
		this.ordersItemsList = ordersItemsList;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getSkuNo() {
		return skuNo;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	} 
    
}
