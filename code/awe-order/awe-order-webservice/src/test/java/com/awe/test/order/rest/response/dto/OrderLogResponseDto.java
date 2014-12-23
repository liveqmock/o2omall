package com.awe.test.order.rest.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * OrderLogResponseDto：订单日志返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:06:38
 * 
 */
public class OrderLogResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 自增id */
    private Long id; 
    /** 订单编号 */
    private String orderNo; 
    /** 订单状态 */
    private Integer status; 
    /** 状态名称 */
    private String statusName; 
    /** 订单描述 */
    private String description; 
    /** 100:前台显示;200后台显示 */
    private Integer logType; 
    /** 创建时间 */
    private Date createTime; 
    /** 创建人 */
    private String createName; 
    /** 是否有效 */
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
     * get 订单状态
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 订单状态
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * get 状态名称
     * 
     * @return the statusName
     */
    public String getStatusName(){
        return statusName;
    }
        
    /**
     * set 状态名称
     * 
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    /**
     * get 订单描述
     * 
     * @return the description
     */
    public String getDescription(){
        return description;
    }
        
    /**
     * set 订单描述
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * get 100:前台显示;200后台显示
     * 
     * @return the logType
     */
    public Integer getLogType(){
        return logType;
    }
        
    /**
     * set 100:前台显示;200后台显示
     * 
     * @param logType the logType to set
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
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
