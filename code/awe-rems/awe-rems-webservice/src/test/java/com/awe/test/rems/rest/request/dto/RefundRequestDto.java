package com.awe.test.rems.rest.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * RefundRequestDto：退款表请求参数
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
 * 
 */
public class RefundRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 售后单号:退货T开头;换货H开头;维修X开头 */
    private String serviceNo; 
    /** 订单号 */
    private String orderNo; 
    /** 商品分类编号 */
    private Long categoryId; 
    /** 商品编号 */
    private String productNo; 
    /** SKU编号 */
    private String skuNo; 
    /** SKU名称 */
    private String skuName; 
    /** 退款金额 */
    private Double refundAmount; 
    /** 退款账号 */
    private String accountNo; 
    /** 退款账户 */
    private String accountName; 
    /** 发起退款日期 */
    private Date refundDate; 
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
    /** 主表id */
    private Long returnExchangeId;
    /**用户id*/
    private Long userId;
    /**退款状态*/
    private Integer status;
    /**差额原因*/
    private String balanceReason;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getSkuNo() {
		return skuNo;
	}

	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBalanceReason() {
		return balanceReason;
	}

	public void setBalanceReason(String balanceReason) {
		this.balanceReason = balanceReason;
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
