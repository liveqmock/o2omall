package com.awe.pms.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ProductSkuResponseDto：商品SKU返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
public class ProductSkuResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** 商品编号 */
    private String productNo; 
    /** sku编号 */
    private String skuNo; 
    /** SKU名称 */
    private String skuName; 
    /** 尺码 */
    private String size; 
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
    /** 上架时间 */
    private Date saleTimeStart; 
    /** 下架时间 */
    private Date saleTimeEnd; 
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
    private String remark; 
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
     * get 上架时间
     * 
     * @return the saleTimeStart
     */
    public Date getSaleTimeStart(){
        return saleTimeStart;
    }
        
    /**
     * set 上架时间
     * 
     * @param saleTimeStart the saleTimeStart to set
     */
    public void setSaleTimeStart(Date saleTimeStart) {
        this.saleTimeStart = saleTimeStart;
    }
    
    /**
     * get 下架时间
     * 
     * @return the saleTimeEnd
     */
    public Date getSaleTimeEnd(){
        return saleTimeEnd;
    }
        
    /**
     * set 下架时间
     * 
     * @param saleTimeEnd the saleTimeEnd to set
     */
    public void setSaleTimeEnd(Date saleTimeEnd) {
        this.saleTimeEnd = saleTimeEnd;
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
     * @return the remark
     */
    public String getRemark(){
        return remark;
    }
        
    /**
     * set 描述
     * 
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
