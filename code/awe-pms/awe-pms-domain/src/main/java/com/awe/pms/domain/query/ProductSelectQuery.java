package com.awe.pms.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ProductSelectQuery：商品查询综合表查询类
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
public class ProductSelectQuery extends Query {
    
    /** 主键 */
	private Long id; 
    /** 商品编号 */
	private String productNo; 
    /** 商品名称 */
	private String productName; 
    /** sku编号 */
	private String skuNo; 
    /** SKU名称 */
	private String skuName; 
    /** 一级分类 */
	private Long categoryOneId; 
    /** 二级分类 */
	private Long categoryTwoId; 
    /** 三级分类 */
	private Long categoryThreeId; 
    /** 适用阶段 */
	private Integer applicableStep; 
    /** 品牌编号 */
	private String brandCode; 
    /** 经营模式（自营、三方） */
	private Integer mode; 
    /** 销售价 */
	private Double salePrice; 
    /** 市场价 */
	private Double price; 
    /** Sku主图 */
	private String imgPath; 
    /** 总销售量 */
	private Long saleQuantityTotal; 
    /** 每周销售量 */
	private Long saleQuantityWeek; 
    /** 推荐数量（客户） */
	private Long recommendAmount; 
    /** 是否推荐（专家） */
	private Integer isRecommend; 
    /** 是否热门 */
	private Integer isHot; 
    /** 浏览次数 */
	private Long hitCountTotal; 
    /** 上下架状态 */
	private Integer saleStatus; 
    /** 每周浏览次数 */
	private Long hitCountWeek; 
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
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
    
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
     * get 商品名称
     * 
     * @return the productName
     */
    public String getProductName(){
        return productName;
    }
        
    /**
     * set 商品名称
     * 
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * get 一级分类
     * 
     * @return the categoryOneId
     */
    public Long getCategoryOneId(){
        return categoryOneId;
    }
        
    /**
     * set 一级分类
     * 
     * @param categoryOneId the categoryOneId to set
     */
    public void setCategoryOneId(Long categoryOneId) {
        this.categoryOneId = categoryOneId;
    }
    
    /**
     * get 二级分类
     * 
     * @return the categoryTwoId
     */
    public Long getCategoryTwoId(){
        return categoryTwoId;
    }
        
    /**
     * set 二级分类
     * 
     * @param categoryTwoId the categoryTwoId to set
     */
    public void setCategoryTwoId(Long categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }
    
    /**
     * get 三级分类
     * 
     * @return the categoryThreeId
     */
    public Long getCategoryThreeId(){
        return categoryThreeId;
    }
        
    /**
     * set 三级分类
     * 
     * @param categoryThreeId the categoryThreeId to set
     */
    public void setCategoryThreeId(Long categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }
    
    /**
     * get 适用阶段
     * 
     * @return the applicableStep
     */
    public Integer getApplicableStep(){
        return applicableStep;
    }
        
    /**
     * set 适用阶段
     * 
     * @param applicableStep the applicableStep to set
     */
    public void setApplicableStep(Integer applicableStep) {
        this.applicableStep = applicableStep;
    }
    
    /**
     * get 品牌编号
     * 
     * @return the brandCode
     */
    public String getBrandCode(){
        return brandCode;
    }
        
    /**
     * set 品牌编号
     * 
     * @param brandCode the brandCode to set
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    
    /**
     * get 经营模式（自营、三方）
     * 
     * @return the mode
     */
    public Integer getMode(){
        return mode;
    }
        
    /**
     * set 经营模式（自营、三方）
     * 
     * @param mode the mode to set
     */
    public void setMode(Integer mode) {
        this.mode = mode;
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
     * get 总销售量
     * 
     * @return the saleQuantityTotal
     */
    public Long getSaleQuantityTotal(){
        return saleQuantityTotal;
    }
        
    /**
     * set 总销售量
     * 
     * @param saleQuantityTotal the saleQuantityTotal to set
     */
    public void setSaleQuantityTotal(Long saleQuantityTotal) {
        this.saleQuantityTotal = saleQuantityTotal;
    }
    
    /**
     * get 每周销售量
     * 
     * @return the saleQuantityWeek
     */
    public Long getSaleQuantityWeek(){
        return saleQuantityWeek;
    }
        
    /**
     * set 每周销售量
     * 
     * @param saleQuantityWeek the saleQuantityWeek to set
     */
    public void setSaleQuantityWeek(Long saleQuantityWeek) {
        this.saleQuantityWeek = saleQuantityWeek;
    }
    
    /**
     * get 推荐数量（客户）
     * 
     * @return the recommendAmount
     */
    public Long getRecommendAmount(){
        return recommendAmount;
    }
        
    /**
     * set 推荐数量（客户）
     * 
     * @param recommendAmount the recommendAmount to set
     */
    public void setRecommendAmount(Long recommendAmount) {
        this.recommendAmount = recommendAmount;
    }
    
    /**
     * get 是否推荐（专家）
     * 
     * @return the isRecommend
     */
    public Integer getIsRecommend(){
        return isRecommend;
    }
        
    /**
     * set 是否推荐（专家）
     * 
     * @param isRecommend the isRecommend to set
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }
    
    /**
     * get 是否热门
     * 
     * @return the isHot
     */
    public Integer getIsHot(){
        return isHot;
    }
        
    /**
     * set 是否热门
     * 
     * @param isHot the isHot to set
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    
    /**
     * get 浏览次数
     * 
     * @return the hitCountTotal
     */
    public Long getHitCountTotal(){
        return hitCountTotal;
    }
        
    /**
     * set 浏览次数
     * 
     * @param hitCountTotal the hitCountTotal to set
     */
    public void setHitCountTotal(Long hitCountTotal) {
        this.hitCountTotal = hitCountTotal;
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
     * get 每周浏览次数
     * 
     * @return the hitCountWeek
     */
    public Long getHitCountWeek(){
        return hitCountWeek;
    }
        
    /**
     * set 每周浏览次数
     * 
     * @param hitCountWeek the hitCountWeek to set
     */
    public void setHitCountWeek(Long hitCountWeek) {
        this.hitCountWeek = hitCountWeek;
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

    /**
     * get 开始时间
     * 
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }
    
    /**
     * set 开始时间
     * 
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    /**
     * get 结束时间
     * 
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }
    
    /**
     * set 结束时间
     * 
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
