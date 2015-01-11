package com.awe.mall.domain.dto;

/**
 * 订单核对信息 商品列表
 *OrderInfo	
 *
 * @author js
 * @version：2015年1月10日 下午1:13:09
 */
public class OrderInfo implements java.io.Serializable{

	/** 序列化标识 */
	private static final long serialVersionUID = 1L;

	 /** 主键 */
    private Long id;
    /** 用户编号 */
    private String userId;
    /** sku编号 */
    private String skuNo; 
    /** SKU名称 */
    private String skuName; 
    /** 商品数量 */
    private Integer skuCount;
    /** 销售商 */
    private String seller; 
    /** 销售商编号*/
    private String sellerNo;
    /** Sku主图 */
    private String imgPath; 
    /** 销售价 */
    private Double salePrice; 
    /** 市场价 */
    private Double price;
    /** 折扣（会员） */
    private Double discount;
    /** 商品广告词 */
    private String productAd; 
    /** 商品促销信息（赠品，多个可分割保存） */
    private String salesPromotion;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the skuNo
	 */
	public String getSkuNo() {
		return skuNo;
	}
	/**
	 * @param skuNo the skuNo to set
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	/**
	 * @return the skuName
	 */
	public String getSkuName() {
		return skuName;
	}
	/**
	 * @param skuName the skuName to set
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * @return the skuCount
	 */
	public Integer getSkuCount() {
		return skuCount;
	}
	/**
	 * @param skuCount the skuCount to set
	 */
	public void setSkuCount(Integer skuCount) {
		this.skuCount = skuCount;
	}
	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}
	/**
	 * @return the sellerNo
	 */
	public String getSellerNo() {
		return sellerNo;
	}
	/**
	 * @param sellerNo the sellerNo to set
	 */
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}
	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	/**
	 * @return the salePrice
	 */
	public Double getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * @return the productAd
	 */
	public String getProductAd() {
		return productAd;
	}
	/**
	 * @param productAd the productAd to set
	 */
	public void setProductAd(String productAd) {
		this.productAd = productAd;
	}
	/**
	 * @return the salesPromotion
	 */
	public String getSalesPromotion() {
		return salesPromotion;
	}
	/**
	 * @param salesPromotion the salesPromotion to set
	 */
	public void setSalesPromotion(String salesPromotion) {
		this.salesPromotion = salesPromotion;
	} 
    
}
