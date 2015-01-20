package com.awe.test.pay.rest.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * RefundResponseDto：逆向退款返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class RefundResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 售后单号:退货T开头;换货H开头;维修X开头 */
    private String serviceNo; 
    /** 订单号 */
    private String orderNo; 
    /** 退款金额 */
    private Double refundAmount; 
    /** 退款账号 */
    private String accountNo; 
    /** 退款账户 */
    private String accountName; 
    /** 发起退款日期 */
    private Date refundDate; 
    /** 交易流水号 */
    private String serialNo; 
    /** 退款交易状态 */
    private Integer status; 
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
    /**商家编号*/
    private String businessNo;
    /**商家名称*/
    private String businessName;
    
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
     * get 退款金额
     * 
     * @return the refundAmount
     */
    public Double getRefundAmount(){
        return refundAmount;
    }
        
    /**
     * set 退款金额
     * 
     * @param refundAmount the refundAmount to set
     */
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
    
    /**
     * get 退款账号
     * 
     * @return the accountNo
     */
    public String getAccountNo(){
        return accountNo;
    }
        
    /**
     * set 退款账号
     * 
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    /**
     * get 退款账户
     * 
     * @return the accountName
     */
    public String getAccountName(){
        return accountName;
    }
        
    /**
     * set 退款账户
     * 
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * get 发起退款日期
     * 
     * @return the refundDate
     */
    public Date getRefundDate(){
        return refundDate;
    }
        
    /**
     * set 发起退款日期
     * 
     * @param refundDate the refundDate to set
     */
    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }
    
    /**
     * get 交易流水号
     * 
     * @return the serialNo
     */
    public String getSerialNo(){
        return serialNo;
    }
        
    /**
     * set 交易流水号
     * 
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    
    /**
     * get 退款交易状态
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 退款交易状态
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

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
