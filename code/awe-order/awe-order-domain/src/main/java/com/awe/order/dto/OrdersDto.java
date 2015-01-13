package com.awe.order.dto;

import java.util.Date;

/**
 * OrdersDto：订单Dto
 * 
 * @author zyq
 * @version 2015-1-3
 * 
 */
public class OrdersDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	 /** 自增id */
    private Long id; 
    /** 订单编号 */
    private String orderNo; 
    /** 100:事物订单;200:虚拟订单 */
    private Integer orderType; 
    /** 用户ID */
    private Long userId; 
    /** 下单用户账号 */
    private String userName; 
    /** 下单姓名 */
    private String orderName; 
    /** 收货人姓名 */
    private String consigneeName; 
   
    /** 1-现金;2-Pos刷卡 */
    private Integer payWay; 
    /** 1-货到付款;2-在线支付;3-公司转账;4-邮件汇款 */
    private Integer payType; 
    /** 10-用户取消;20-用户删除;30-系统取消;40-待付款;50-已收款;60-已发货;70-已签收;80-订单完成;90-待拆单;100-拆单完成;110-订单审核;120-待退货;130-已退货;140-待换货;150-已换货;160-已退款;
 */
    private Integer orderStatus; 
    /** 应付总额 */
    private Double amountPay; 
    /** 父订单编号 */
    private String parentOrderNo; 
    
    /** 创建时间 */
    private Date createTime; 

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
    /** 商品单价 */
    private Double skuPrice; 
    /** 优惠后价格 */
    private Double finalPrice; 
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Double getAmountPay() {
		return amountPay;
	}
	public void setAmountPay(Double amountPay) {
		this.amountPay = amountPay;
	}
	public String getParentOrderNo() {
		return parentOrderNo;
	}
	public void setParentOrderNo(String parentOrderNo) {
		this.parentOrderNo = parentOrderNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	/**
	 * sku编号
	 * @return
	 */
	public String getSkuNo() {
		return skuNo;
	}
	/**
	 * sku编号
	 * @param skuNo
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	/**
	 * 商品编号
	 * @return
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * 商品编号
	 * @param productNo
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * sku名称
	 * @return
	 */
	public String getSkuName() {
		return skuName;
	}
	/**
	 * sku名称
	 * @param skuName
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * 商品主图
	 * @return
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 商品主图
	 * @param imgUrl
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 商品单价
	 * @return
	 */
	public Double getSkuPrice() {
		return skuPrice;
	}
	/**
	 * 商品单价
	 * @param skuPrice
	 */
	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}
	/**
	 * 优惠后价格
	 * @return
	 */
	public Double getFinalPrice() {
		return finalPrice;
	}
	/**
	 * 优惠后价格
	 * @param finalPrice
	 */
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	/**
	 * 商品个数
	 * @return
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 商品个数
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}
