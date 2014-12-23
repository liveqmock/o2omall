package com.awe.order.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ECouponQuery：电子券查询类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
public class ECouponQuery extends Query {
    
    /** 自增id */
	private Long id; 
    /** 订单号 */
	private String orderNo; 
    /** 券号 */
	private String voucherNo; 
    /** 类型 */
	private Integer type; 
    /** 10:初始状态;20:使用;30:不使用 */
	private Integer status; 
    /** 有效期 */
	private Date effectiveTime; 
    /** 生成时间 */
	private Date generateTime; 
    /** 截止日期 */
	private Date deadline; 
    /** 创建人 */
	private String createName; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改人 */
	private String updateName; 
    /** 修改时间 */
	private Date updateTime; 
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
     * get 券号
     * 
     * @return the voucherNo
     */
    public String getVoucherNo(){
        return voucherNo;
    }
        
    /**
     * set 券号
     * 
     * @param voucherNo the voucherNo to set
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }
    
    /**
     * get 类型
     * 
     * @return the type
     */
    public Integer getType(){
        return type;
    }
        
    /**
     * set 类型
     * 
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * get 10:初始状态;20:使用;30:不使用
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 10:初始状态;20:使用;30:不使用
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * get 有效期
     * 
     * @return the effectiveTime
     */
    public Date getEffectiveTime(){
        return effectiveTime;
    }
        
    /**
     * set 有效期
     * 
     * @param effectiveTime the effectiveTime to set
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
    
    /**
     * get 生成时间
     * 
     * @return the generateTime
     */
    public Date getGenerateTime(){
        return generateTime;
    }
        
    /**
     * set 生成时间
     * 
     * @param generateTime the generateTime to set
     */
    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }
    
    /**
     * get 截止日期
     * 
     * @return the deadline
     */
    public Date getDeadline(){
        return deadline;
    }
        
    /**
     * set 截止日期
     * 
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    /**
     * get 创建人
     * 
     * @return the createName
     */
    public String getCreateName(){
        return createName;
    }
        
    /**
     * set 创建人
     * 
     * @param createName the createName to set
     */
    public void setCreateName(String createName) {
        this.createName = createName;
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
     * @return the updateName
     */
    public String getUpdateName(){
        return updateName;
    }
        
    /**
     * set 修改人
     * 
     * @param updateName the updateName to set
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
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
