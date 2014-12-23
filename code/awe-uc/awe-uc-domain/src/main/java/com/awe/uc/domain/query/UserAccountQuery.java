package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * UserAccountQuery：用户账号查询类
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserAccountQuery extends Query {
    
    /** id自增 */
	private Long id; 
    /** 账号 */
	private String username; 
    /** 密码 */
	private String password; 
    /** 登录次数 */
	private Integer loginTimes; 
    /** 用户上次登录IP */
	private String lastLoginIp; 
    /** 用户上次登录时间 */
	private Date lastLoginTime; 
    /** 创建人 */
	private String createUser; 
    /** 修改人 */
	private String updateUser; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改时间 */
	private Date updateTime; 
    /** 是否有效: 1-有效, 0-无效 */
	private Integer yn; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
    
    /**
     * get id自增
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set id自增
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 账号
     * 
     * @return the username
     */
    public String getUsername(){
        return username;
    }
        
    /**
     * set 账号
     * 
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * get 密码
     * 
     * @return the password
     */
    public String getPassword(){
        return password;
    }
        
    /**
     * set 密码
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * get 登录次数
     * 
     * @return the loginTimes
     */
    public Integer getLoginTimes(){
        return loginTimes;
    }
        
    /**
     * set 登录次数
     * 
     * @param loginTimes the loginTimes to set
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }
    
    /**
     * get 用户上次登录IP
     * 
     * @return the lastLoginIp
     */
    public String getLastLoginIp(){
        return lastLoginIp;
    }
        
    /**
     * set 用户上次登录IP
     * 
     * @param lastLoginIp the lastLoginIp to set
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    
    /**
     * get 用户上次登录时间
     * 
     * @return the lastLoginTime
     */
    public Date getLastLoginTime(){
        return lastLoginTime;
    }
        
    /**
     * set 用户上次登录时间
     * 
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
