package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * AreaQuery：三级地址查询类
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class AreaQuery extends Query {
    
    /** 自增ID */
	private Long id; 
    /** 父编号 */
	private String parentCode; 
    /** 编号 */
	private String code; 
    /** 名称 */
	private String name; 
    /** 级别 */
	private Integer level; 
    /** 创建人 */
	private String createUser; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改人 */
	private String updateUser; 
    /** 修改时间 */
	private Date updateTime; 
    /** 是否有效: 1-有效, 0-无效 */
	private Integer yn; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
    
    /**
     * get 自增ID
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 自增ID
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 父编号
     * 
     * @return the parentCode
     */
    public String getParentCode(){
        return parentCode;
    }
        
    /**
     * set 父编号
     * 
     * @param parentCode the parentCode to set
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    
    /**
     * get 编号
     * 
     * @return the code
     */
    public String getCode(){
        return code;
    }
        
    /**
     * set 编号
     * 
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * get 名称
     * 
     * @return the name
     */
    public String getName(){
        return name;
    }
        
    /**
     * set 名称
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * get 是否有效: 1-有效, 0-无效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效: 1-有效, 0-无效
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
