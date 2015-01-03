package com.awe.order.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ShoppingCartQuery：购物车查询类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class ShoppingCartQuery extends Query {
    
    /** 自增id */
	private Long id; 
    /** 用户编号 */
	private String userNo; 
    /** 商品编号 */
	private String skuNo; 
    /** 商品数量 */
	private Integer skuCount; 
    /** 1:正常状态;2-删除;3-已下单 */
	private Integer status; 
    /** 创建时间 */
	private Date createTime; 
    /** 更新时间 */
	private Date updateTime; 
    /** 创建人 */
	private String createUser; 
    /** 修改人 */
	private String updateUser; 
    /** 0:无效;1:有效 */
	private Integer yn; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
    
    /**
     * get 自增id
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 自增id
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 用户编号
     * 
     * @return the userNo
     */
    public String getUserNo(){
        return userNo;
    }
        
    /**
     * set 用户编号
     * 
     * @param userNo the userNo to set
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    
    /**
     * get 商品编号
     * 
     * @return the skuNo
     */
    public String getSkuNo(){
        return skuNo;
    }
        
    /**
     * set 商品编号
     * 
     * @param skuNo the skuNo to set
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }
    
    /**
     * get 商品数量
     * 
     * @return the skuCount
     */
    public Integer getSkuCount(){
        return skuCount;
    }
        
    /**
     * set 商品数量
     * 
     * @param skuCount the skuCount to set
     */
    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }
    
    /**
     * get 1:正常状态;2-删除;3-已下单
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 1:正常状态;2-删除;3-已下单
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * get 更新时间
     * 
     * @return the updateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }
        
    /**
     * set 更新时间
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
     * get 0:无效;1:有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 0:无效;1:有效
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
