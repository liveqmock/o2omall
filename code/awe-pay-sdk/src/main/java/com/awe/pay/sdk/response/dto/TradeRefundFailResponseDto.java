package com.awe.pay.sdk.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * TradeRefundFailResponseDto：正向交易及逆向退款失败表返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeRefundFailResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 订单号 */
    private Long orderNo; 
    /** 交易类型10:正向交易;20:逆向退款 */
    private Integer payType; 
    /** 执行状态 */
    private Integer status; 
    /** 执行次数 */
    private Integer executeCount; 
    /** 创建时间 */
    private Date createTime; 
    /** 更新时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
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
     * get 订单号
     * 
     * @return the orderNo
     */
    public Long getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单号
     * 
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }
    
    /**
     * get 交易类型10:正向交易;20:逆向退款
     * 
     * @return the payType
     */
    public Integer getPayType(){
        return payType;
    }
        
    /**
     * set 交易类型10:正向交易;20:逆向退款
     * 
     * @param payType the payType to set
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    /**
     * get 执行状态
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 执行状态
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * get 执行次数
     * 
     * @return the executeCount
     */
    public Integer getExecuteCount(){
        return executeCount;
    }
        
    /**
     * set 执行次数
     * 
     * @param executeCount the executeCount to set
     */
    public void setExecuteCount(Integer executeCount) {
        this.executeCount = executeCount;
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
