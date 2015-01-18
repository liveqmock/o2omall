package com.awe.rems.sdk.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ServiceAuditResponseDto：退换货审核流表返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ServiceAuditResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 主表id */
    private Long returnExchangeId; 
    /** 售后单号:退货T开头;换货H开头;维修X开头 */
    private String serviceNo; 
    /** 订单号 */
    private String orderNo; 
    /** 服务单状态:10:客户提交:20:售后审核;30:售后收货;40:退款;50:完成 */
    private Integer status; 
    /** 审核备注 */
    private String comment; 
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
    /**用户id*/
    private Long userId;
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
     * get 主表id
     * 
     * @return the returnExchangeId
     */
    public Long getReturnExchangeId(){
        return returnExchangeId;
    }
        
    /**
     * set 主表id
     * 
     * @param returnExchangeId the returnExchangeId to set
     */
    public void setReturnExchangeId(Long returnExchangeId) {
        this.returnExchangeId = returnExchangeId;
    }
    
    /**
     * get 售后单号:退货T开头;换货H开头;维修X开头
     * 
     * @return the serviceNo
     */
    public String getServiceNo(){
        return serviceNo;
    }
        
    /**
     * set 售后单号:退货T开头;换货H开头;维修X开头
     * 
     * @param serviceNo the serviceNo to set
     */
    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }
    
    /**
     * get 订单号
     * 
     * @return the orderNo
     */
    public String getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单号
     * 
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    /**
     * get 服务单状态:10:客户提交:20:售后审核;30:售后收货;40:退款;50:完成
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 服务单状态:10:客户提交:20:售后审核;30:售后收货;40:退款;50:完成
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * get 审核备注
     * 
     * @return the comment
     */
    public String getComment(){
        return comment;
    }
        
    /**
     * set 审核备注
     * 
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}
