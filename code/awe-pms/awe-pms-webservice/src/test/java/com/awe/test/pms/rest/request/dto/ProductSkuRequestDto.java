package com.awe.test.pms.rest.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;
import java.util.List;

/**
 * ProductSkuRequestDto：商品SKU请求参数
 * 
 * @author ljz
 * @version 2015-1-7 9:51:31
 * 
 */
public class ProductSkuRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** 商品编号 */
    private String productNo;
    /** sku编号 */
    private String skuNo;
    /**
     * 查询的sku集合
     */
    private List<String> skuNos;
    /** SKU名称 */
    private String skuName; 
    /** 颜色 */
    private Integer color; 
    /** 颜色描述 */
    private String colorDesc; 
    /** 颜色顺序 */
    private Integer colorOrder; 
    /** 尺码 */
    private String size; 
    /** 尺码描述 */
    private String sizeDesc; 
    /** 尺码顺序 */
    private Integer sizeOrder; 
    /** 商品广告词 */
    private String productAd; 
    /** 商品促销信息（赠品，多个可分割保存） */
    private String salesPromotion; 
    /** 商品保质期 */
    private String durabilityPeriod; 
    /** 商品生产日期 */
    private Date productionDate; 
    /** 上下架状态 */
    private Integer saleStatus; 
    /** 上下架时间 */
    private Date saleTime; 
    /** Sku主图 */
    private String imgPath; 
    /** 市场价 */
    private Double price; 
    /** 销售价 */
    private Double salePrice; 
    /** 可售数量 */
    private Long saleQuantity; 
    /** 折扣（会员） */
    private Double discount; 
    /** 描述 */
    private String features; 
    /** 一维码 */
    private String dimensionCodeOne; 
    /** 二维码 */
    private String dimensionCodeTwo; 
    /** 优先级 */
    private Integer priority; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 是否有效 */
    private Integer yn; 
    
    /**
     * get 主键
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 主键
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 商品编号
     * 
     * @return the productNo
     */
    public String getProductNo(){
        return productNo;
    }
        
    /**
     * set 商品编号
     * 
     * @param productNo the productNo to set
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    
    /**
     * get sku编号
     * 
     * @return the skuNo
     */
    public String getSkuNo(){
        return skuNo;
    }
        
    /**
     * set sku编号
     * 
     * @param skuNo the skuNo to set
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }
    
    /**
	 * @return the skuNos
	 */
	public List<String> getSkuNos() {
		return skuNos;
	}

	/**
	 * @param skuNos the skuNos to set
	 */
	public void setSkuNos(List<String> skuNos) {
		this.skuNos = skuNos;
	}

	/**
     * get SKU名称
     * 
     * @return the skuName
     */
    public String getSkuName(){
        return skuName;
    }
        
    /**
     * set SKU名称
     * 
     * @param skuName the skuName to set
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    
    /**
     * get 颜色
     * 
     * @return the color
     */
    public Integer getColor(){
        return color;
    }
        
    /**
     * set 颜色
     * 
     * @param color the color to set
     */
    public void setColor(Integer color) {
        this.color = color;
    }
    
    /**
     * get 颜色描述
     * 
     * @return the colorDesc
     */
    public String getColorDesc(){
        return colorDesc;
    }
        
    /**
     * set 颜色描述
     * 
     * @param colorDesc the colorDesc to set
     */
    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }
    
    /**
     * get 颜色顺序
     * 
     * @return the colorOrder
     */
    public Integer getColorOrder(){
        return colorOrder;
    }
        
    /**
     * set 颜色顺序
     * 
     * @param colorOrder the colorOrder to set
     */
    public void setColorOrder(Integer colorOrder) {
        this.colorOrder = colorOrder;
    }
    
    /**
     * get 尺码
     * 
     * @return the size
     */
    public String getSize(){
        return size;
    }
        
    /**
     * set 尺码
     * 
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }
    
    /**
     * get 尺码描述
     * 
     * @return the sizeDesc
     */
    public String getSizeDesc(){
        return sizeDesc;
    }
        
    /**
     * set 尺码描述
     * 
     * @param sizeDesc the sizeDesc to set
     */
    public void setSizeDesc(String sizeDesc) {
        this.sizeDesc = sizeDesc;
    }
    
    /**
     * get 尺码顺序
     * 
     * @return the sizeOrder
     */
    public Integer getSizeOrder(){
        return sizeOrder;
    }
        
    /**
     * set 尺码顺序
     * 
     * @param sizeOrder the sizeOrder to set
     */
    public void setSizeOrder(Integer sizeOrder) {
        this.sizeOrder = sizeOrder;
    }
    
    /**
     * get 商品广告词
     * 
     * @return the productAd
     */
    public String getProductAd(){
        return productAd;
    }
        
    /**
     * set 商品广告词
     * 
     * @param productAd the productAd to set
     */
    public void setProductAd(String productAd) {
        this.productAd = productAd;
    }
    
    /**
     * get 商品促销信息（赠品，多个可分割保存）
     * 
     * @return the salesPromotion
     */
    public String getSalesPromotion(){
        return salesPromotion;
    }
        
    /**
     * set 商品促销信息（赠品，多个可分割保存）
     * 
     * @param salesPromotion the salesPromotion to set
     */
    public void setSalesPromotion(String salesPromotion) {
        this.salesPromotion = salesPromotion;
    }
    
    /**
     * get 商品保质期
     * 
     * @return the durabilityPeriod
     */
    public String getDurabilityPeriod(){
        return durabilityPeriod;
    }
        
    /**
     * set 商品保质期
     * 
     * @param durabilityPeriod the durabilityPeriod to set
     */
    public void setDurabilityPeriod(String durabilityPeriod) {
        this.durabilityPeriod = durabilityPeriod;
    }
    
    /**
     * get 商品生产日期
     * 
     * @return the productionDate
     */
    public Date getProductionDate(){
        return productionDate;
    }
        
    /**
     * set 商品生产日期
     * 
     * @param productionDate the productionDate to set
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    
    /**
     * get 上下架状态
     * 
     * @return the saleStatus
     */
    public Integer getSaleStatus(){
        return saleStatus;
    }
        
    /**
     * set 上下架状态
     * 
     * @param saleStatus the saleStatus to set
     */
    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }
    
    /**
     * get 上下架时间
     * 
     * @return the saleTime
     */
    public Date getSaleTime(){
        return saleTime;
    }
        
    /**
     * set 上下架时间
     * 
     * @param saleTime the saleTime to set
     */
    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }
    
    /**
     * get Sku主图
     * 
     * @return the imgPath
     */
    public String getImgPath(){
        return imgPath;
    }
        
    /**
     * set Sku主图
     * 
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    /**
     * get 市场价
     * 
     * @return the price
     */
    public Double getPrice(){
        return price;
    }
        
    /**
     * set 市场价
     * 
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    
    /**
     * get 销售价
     * 
     * @return the salePrice
     */
    public Double getSalePrice(){
        return salePrice;
    }
        
    /**
     * set 销售价
     * 
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
    
    /**
     * get 可售数量
     * 
     * @return the saleQuantity
     */
    public Long getSaleQuantity(){
        return saleQuantity;
    }
        
    /**
     * set 可售数量
     * 
     * @param saleQuantity the saleQuantity to set
     */
    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
    }
    
    /**
     * get 折扣（会员）
     * 
     * @return the discount
     */
    public Double getDiscount(){
        return discount;
    }
        
    /**
     * set 折扣（会员）
     * 
     * @param discount the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    
    /**
     * get 描述
     * 
     * @return the features
     */
    public String getFeatures(){
        return features;
    }
        
    /**
     * set 描述
     * 
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
    }
    
    /**
     * get 一维码
     * 
     * @return the dimensionCodeOne
     */
    public String getDimensionCodeOne(){
        return dimensionCodeOne;
    }
        
    /**
     * set 一维码
     * 
     * @param dimensionCodeOne the dimensionCodeOne to set
     */
    public void setDimensionCodeOne(String dimensionCodeOne) {
        this.dimensionCodeOne = dimensionCodeOne;
    }
    
    /**
     * get 二维码
     * 
     * @return the dimensionCodeTwo
     */
    public String getDimensionCodeTwo(){
        return dimensionCodeTwo;
    }
        
    /**
     * set 二维码
     * 
     * @param dimensionCodeTwo the dimensionCodeTwo to set
     */
    public void setDimensionCodeTwo(String dimensionCodeTwo) {
        this.dimensionCodeTwo = dimensionCodeTwo;
    }
    
    /**
     * get 优先级
     * 
     * @return the priority
     */
    public Integer getPriority(){
        return priority;
    }
        
    /**
     * set 优先级
     * 
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    /**
     * get 创建时间
     * 
     * @return the createTime
     */
    public Date getCreateTime(){
        return createTime;
    }
        
    /**
     * set 创建时间
     * 
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * get 修改时间
     * 
     * @return the updateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }
        
    /**
     * set 修改时间
     * 
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * get 创建人
     * 
     * @return the createUser
     */
    public String getCreateUser(){
        return createUser;
    }
        
    /**
     * set 创建人
     * 
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    /**
     * get 修改人
     * 
     * @return the updateUser
     */
    public String getUpdateUser(){
        return updateUser;
    }
        
    /**
     * set 修改人
     * 
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    /**
     * get 是否有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
