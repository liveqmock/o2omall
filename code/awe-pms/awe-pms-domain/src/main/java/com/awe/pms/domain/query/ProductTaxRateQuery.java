package com.awe.pms.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ProductTaxRateQuery：税率查询类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:30
 * 
 */
public class ProductTaxRateQuery extends Query {
    
    /** 主键 */
	private Long id; 
    /** 一级分类 */
	private Long categoryOneId; 
    /** 一级分类名称 */
	private String categoryOne; 
    /** 二级分类 */
	private Long categoryTwoId; 
    /** 二级分类名称 */
	private String categoryTwo; 
    /** 三级分类 */
	private Long categoryThreeId; 
    /** 三级分类名称 */
	private String categoryThree; 
    /** 商品ID */
	private Long productId; 
    /** 商品名称 */
	private String productName; 
    /** 状态 */
	private Integer status; 
    /** 描述 */
	private String features; 
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
     * get 一级分类名称
     * 
     * @return the categoryOne
     */
    public String getCategoryOne(){
        return categoryOne;
    }
        
    /**
     * set 一级分类名称
     * 
     * @param categoryOne the categoryOne to set
     */
    public void setCategoryOne(String categoryOne) {
        this.categoryOne = categoryOne;
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
     * get 二级分类名称
     * 
     * @return the categoryTwo
     */
    public String getCategoryTwo(){
        return categoryTwo;
    }
        
    /**
     * set 二级分类名称
     * 
     * @param categoryTwo the categoryTwo to set
     */
    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo;
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
     * get 三级分类名称
     * 
     * @return the categoryThree
     */
    public String getCategoryThree(){
        return categoryThree;
    }
        
    /**
     * set 三级分类名称
     * 
     * @param categoryThree the categoryThree to set
     */
    public void setCategoryThree(String categoryThree) {
        this.categoryThree = categoryThree;
    }
    
    /**
     * get 商品ID
     * 
     * @return the productId
     */
    public Long getProductId(){
        return productId;
    }
        
    /**
     * set 商品ID
     * 
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
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
     * get 状态
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 状态
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
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
