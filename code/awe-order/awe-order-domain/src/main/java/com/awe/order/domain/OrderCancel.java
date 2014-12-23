package com.awe.order.domain;

import java.util.Date;

/**
 * OrderCancel：订单取消实体类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
public class OrderCancel implements java.io.Serializable {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /** 自增id */
    private Long id; 
    /** 退款单号 */
    private String refund; 
    /** 501:待审核;502:退款中;503:已退款;503:审核驳回;504:退款失败; */
    private Integer status; 
    /** 订单编号 */
    private String orderNo; 
    /** 退款金额 */
    private Double refundAmount; 
    /** 取消原因 */
    private String cancelReason; 
    /** 取消类型 */
    private Integer cancelType; 
    /** 审核人姓名 */
    private String currentAuditName; 
    /** 审核人编号 */
    private String currentAuditNo; 
    /** 0：不通过；1：通过 */
    private Long isAuditing; 
    /** 审核时间 */
    private Date auditingTime; 
    /** 退款完成时间 */
    private Date finishTime; 
    /** 审核意见 */
    private String remark; 
    /** 0:不需要;1需要 */
    private Integer isRefund; 
    /** 创建人姓名 */
    private String createName; 
    /** 修改人姓名 */
    private String updateName; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 1:有效;0:无效 */
    private Integer yn; 
    
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
     * get 退款单号
     * 
     * @return the refund
     */
    public String getRefund(){
        return refund;
    }
        
    /**
     * set 退款单号
     * 
     * @param refund the refund to set
     */
    public void setRefund(String refund) {
        this.refund = refund;
    }
    
    /**
     * get 501:待审核;502:退款中;503:已退款;503:审核驳回;504:退款失败;
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 501:待审核;502:退款中;503:已退款;503:审核驳回;504:退款失败;
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * get 订单编号
     * 
     * @return the orderNo
     */
    public String getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单编号
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
     * get 取消原因
     * 
     * @return the cancelReason
     */
    public String getCancelReason(){
        return cancelReason;
    }
        
    /**
     * set 取消原因
     * 
     * @param cancelReason the cancelReason to set
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
    
    /**
     * get 取消类型
     * 
     * @return the cancelType
     */
    public Integer getCancelType(){
        return cancelType;
    }
        
    /**
     * set 取消类型
     * 
     * @param cancelType the cancelType to set
     */
    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }
    
    /**
     * get 审核人姓名
     * 
     * @return the currentAuditName
     */
    public String getCurrentAuditName(){
        return currentAuditName;
    }
        
    /**
     * set 审核人姓名
     * 
     * @param currentAuditName the currentAuditName to set
     */
    public void setCurrentAuditName(String currentAuditName) {
        this.currentAuditName = currentAuditName;
    }
    
    /**
     * get 审核人编号
     * 
     * @return the currentAuditNo
     */
    public String getCurrentAuditNo(){
        return currentAuditNo;
    }
        
    /**
     * set 审核人编号
     * 
     * @param currentAuditNo the currentAuditNo to set
     */
    public void setCurrentAuditNo(String currentAuditNo) {
        this.currentAuditNo = currentAuditNo;
    }
    
    /**
     * get 0：不通过；1：通过
     * 
     * @return the isAuditing
     */
    public Long getIsAuditing(){
        return isAuditing;
    }
        
    /**
     * set 0：不通过；1：通过
     * 
     * @param isAuditing the isAuditing to set
     */
    public void setIsAuditing(Long isAuditing) {
        this.isAuditing = isAuditing;
    }
    
    /**
     * get 审核时间
     * 
     * @return the auditingTime
     */
    public Date getAuditingTime(){
        return auditingTime;
    }
        
    /**
     * set 审核时间
     * 
     * @param auditingTime the auditingTime to set
     */
    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }
    
    /**
     * get 退款完成时间
     * 
     * @return the finishTime
     */
    public Date getFinishTime(){
        return finishTime;
    }
        
    /**
     * set 退款完成时间
     * 
     * @param finishTime the finishTime to set
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    
    /**
     * get 审核意见
     * 
     * @return the remark
     */
    public String getRemark(){
        return remark;
    }
        
    /**
     * set 审核意见
     * 
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * get 0:不需要;1需要
     * 
     * @return the isRefund
     */
    public Integer getIsRefund(){
        return isRefund;
    }
        
    /**
     * set 0:不需要;1需要
     * 
     * @param isRefund the isRefund to set
     */
    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
    }
    
    /**
     * get 创建人姓名
     * 
     * @return the createName
     */
    public String getCreateName(){
        return createName;
    }
        
    /**
     * set 创建人姓名
     * 
     * @param createName the createName to set
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    
    /**
     * get 修改人姓名
     * 
     * @return the updateName
     */
    public String getUpdateName(){
        return updateName;
    }
        
    /**
     * set 修改人姓名
     * 
     * @param updateName the updateName to set
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
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
     * get 1:有效;0:无效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 1:有效;0:无效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
