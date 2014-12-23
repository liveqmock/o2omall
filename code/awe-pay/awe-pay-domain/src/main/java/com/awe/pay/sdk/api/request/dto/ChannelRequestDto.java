package com.awe.pay.sdk.api.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ChannelRequestDto：支付通道请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public class ChannelRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 通道编号 */
    private Long channelNo; 
    /** 通道名称 */
    private String channelName; 
    /** 通道分类编号 */
    private Long channelCategoryNo; 
    /** 通道分类名称 */
    private String channelCategoryName; 
    /** 是否默认 */
    private Integer isDefault; 
    /** 优先级 */
    private Integer priority; 
    /** 创建时间 */
    private Date createTime; 
    /** 更新时间 */
    private Date updateTime; 
    /** 创建人id */
    private Long createUserId; 
    /** 创建人 */
    private String createUser; 
    /** 更新人id */
    private Long updateUserId; 
    /** 更新人 */
    private String updateUser; 
    /** 是否有效:1有效;0:无效 */
    private Integer yn; 
    
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
     * get 通道编号
     * 
     * @return the channelNo
     */
    public Long getChannelNo(){
        return channelNo;
    }
        
    /**
     * set 通道编号
     * 
     * @param channelNo the channelNo to set
     */
    public void setChannelNo(Long channelNo) {
        this.channelNo = channelNo;
    }
    
    /**
     * get 通道名称
     * 
     * @return the channelName
     */
    public String getChannelName(){
        return channelName;
    }
        
    /**
     * set 通道名称
     * 
     * @param channelName the channelName to set
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    
    /**
     * get 通道分类编号
     * 
     * @return the channelCategoryNo
     */
    public Long getChannelCategoryNo(){
        return channelCategoryNo;
    }
        
    /**
     * set 通道分类编号
     * 
     * @param channelCategoryNo the channelCategoryNo to set
     */
    public void setChannelCategoryNo(Long channelCategoryNo) {
        this.channelCategoryNo = channelCategoryNo;
    }
    
    /**
     * get 通道分类名称
     * 
     * @return the channelCategoryName
     */
    public String getChannelCategoryName(){
        return channelCategoryName;
    }
        
    /**
     * set 通道分类名称
     * 
     * @param channelCategoryName the channelCategoryName to set
     */
    public void setChannelCategoryName(String channelCategoryName) {
        this.channelCategoryName = channelCategoryName;
    }
    
    /**
     * get 是否默认
     * 
     * @return the isDefault
     */
    public Integer getIsDefault(){
        return isDefault;
    }
        
    /**
     * set 是否默认
     * 
     * @param isDefault the isDefault to set
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
     * get 创建人id
     * 
     * @return the createUserId
     */
    public Long getCreateUserId(){
        return createUserId;
    }
        
    /**
     * set 创建人id
     * 
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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
     * get 更新人id
     * 
     * @return the updateUserId
     */
    public Long getUpdateUserId(){
        return updateUserId;
    }
        
    /**
     * set 更新人id
     * 
     * @param updateUserId the updateUserId to set
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
    
    /**
     * get 更新人
     * 
     * @return the updateUser
     */
    public String getUpdateUser(){
        return updateUser;
    }
        
    /**
     * set 更新人
     * 
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    /**
     * get 是否有效:1有效;0:无效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效:1有效;0:无效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
