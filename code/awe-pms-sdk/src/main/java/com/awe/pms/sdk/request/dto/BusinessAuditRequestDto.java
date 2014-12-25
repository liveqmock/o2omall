package com.awe.pms.sdk.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * BusinessAuditRequestDto：审核商家流水表请求参数
 * 
 * @author ljz
 * @version 2014-12-25 14:47:42
 * 
 */
public class BusinessAuditRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** 商家编号 */
    private String businessNo; 
    /** 商家名称 */
    private String businessName; 
    /** 操作人 */
    private String operator; 
    /** 操作时间 */
    private Date operateTime; 
    /** 审核结果 */
    private Integer checkResult; 
    /** 审核描述 */
    private String features; 
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
     * get 商家编号
     * 
     * @return the businessNo
     */
    public String getBusinessNo(){
        return businessNo;
    }
        
    /**
     * set 商家编号
     * 
     * @param businessNo the businessNo to set
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
    
    /**
     * get 商家名称
     * 
     * @return the businessName
     */
    public String getBusinessName(){
        return businessName;
    }
        
    /**
     * set 商家名称
     * 
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    
    /**
     * get 操作人
     * 
     * @return the operator
     */
    public String getOperator(){
        return operator;
    }
        
    /**
     * set 操作人
     * 
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    /**
     * get 操作时间
     * 
     * @return the operateTime
     */
    public Date getOperateTime(){
        return operateTime;
    }
        
    /**
     * set 操作时间
     * 
     * @param operateTime the operateTime to set
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
    
    /**
     * get 审核结果
     * 
     * @return the checkResult
     */
    public Integer getCheckResult(){
        return checkResult;
    }
        
    /**
     * set 审核结果
     * 
     * @param checkResult the checkResult to set
     */
    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }
    
    /**
     * get 审核描述
     * 
     * @return the features
     */
    public String getFeatures(){
        return features;
    }
        
    /**
     * set 审核描述
     * 
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
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
}
