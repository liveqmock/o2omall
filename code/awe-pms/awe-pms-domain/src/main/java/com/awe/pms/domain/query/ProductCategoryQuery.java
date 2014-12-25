package com.awe.pms.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ProductCategoryQuery：商品类别查询类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:30
 * 
 */
public class ProductCategoryQuery extends Query {
    
    /** 主键 */
	private Long id; 
    /** 父ID */
	private Long fid; 
    /** 类目名称 */
	private String name; 
    /** 类目英文名称 */
	private String enName; 
    /** 关键字 */
	private String keyword; 
    /** 描述 */
	private String features; 
    /** 级别 */
	private Integer level; 
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
     * get 父ID
     * 
     * @return the fid
     */
    public Long getFid(){
        return fid;
    }
        
    /**
     * set 父ID
     * 
     * @param fid the fid to set
     */
    public void setFid(Long fid) {
        this.fid = fid;
    }
    
    /**
     * get 类目名称
     * 
     * @return the name
     */
    public String getName(){
        return name;
    }
        
    /**
     * set 类目名称
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get 类目英文名称
     * 
     * @return the enName
     */
    public String getEnName(){
        return enName;
    }
        
    /**
     * set 类目英文名称
     * 
     * @param enName the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
    
    /**
     * get 关键字
     * 
     * @return the keyword
     */
    public String getKeyword(){
        return keyword;
    }
        
    /**
     * set 关键字
     * 
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
     * get 级别
     * 
     * @return the level
     */
    public Integer getLevel(){
        return level;
    }
        
    /**
     * set 级别
     * 
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
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
