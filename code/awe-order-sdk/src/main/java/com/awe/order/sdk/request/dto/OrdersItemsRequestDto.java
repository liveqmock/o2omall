package com.awe.order.sdk.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * OrdersItemsRequestDto：订单明细请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class OrdersItemsRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键自增id */
    private Long id; 
    /** 订单编号 */
    private String orderNo; 
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
    /** 商品优惠价 */
    private Double discount; 
    /** 商品单价 */
    private Double skuPrice; 
    /** 优惠后价格 */
    private Double finalPrice; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 0-无效;1-有效 */
    private Integer yn; 
    
    /**
     * get 主键自增id
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 主键自增id
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 订单编号
     * 
     * @return the orderNo
     */
    public String getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单编号
     * 
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * get 商品个数
     * 
     * @return the count
     */
    public Integer getCount(){
        return count;
    }
        
    /**
     * set 商品个数
     * 
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }
    
    /**
     * get sku名称
     * 
     * @return the skuName
     */
    public String getSkuName(){
        return skuName;
    }
        
    /**
     * set sku名称
     * 
     * @param skuName the skuName to set
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    
    /**
     * get 商品主图
     * 
     * @return the imgUrl
     */
    public String getImgUrl(){
        return imgUrl;
    }
        
    /**
     * set 商品主图
     * 
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    /**
     * get 商品优惠价
     * 
     * @return the discount
     */
    public Double getDiscount(){
        return discount;
    }
        
    /**
     * set 商品优惠价
     * 
     * @param discount the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    
    /**
     * get 商品单价
     * 
     * @return the skuPrice
     */
    public Double getSkuPrice(){
        return skuPrice;
    }
        
    /**
     * set 商品单价
     * 
     * @param skuPrice the skuPrice to set
     */
    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }
    
    /**
     * get 优惠后价格
     * 
     * @return the finalPrice
     */
    public Double getFinalPrice(){
        return finalPrice;
    }
        
    /**
     * set 优惠后价格
     * 
     * @param finalPrice the finalPrice to set
     */
    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
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
     * get 0-无效;1-有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 0-无效;1-有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
