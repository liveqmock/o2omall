package com.awe.pms.domain;

import java.util.Date;

/**
 * ProductDict：配置表实体类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
public class ProductDict implements java.io.Serializable {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /** 主键标识 */
    private Long id; 
    /** 类型 */
    private Integer type; 
    /** 属性 */
    private String attr; 
    /** 值 */
    private String value; 
    /** 备注 */
    private String remark; 
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
     * get 主键标识
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 主键标识
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * get 属性
     * 
     * @return the attr
     */
    public String getAttr(){
        return attr;
    }
        
    /**
     * set 属性
     * 
     * @param attr the attr to set
     */
    public void setAttr(String attr) {
        this.attr = attr;
    }
    
    /**
     * get 值
     * 
     * @return the value
     */
    public String getValue(){
        return value;
    }
        
    /**
     * set 值
     * 
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * get 备注
     * 
     * @return the remark
     */
    public String getRemark(){
        return remark;
    }
        
    /**
     * set 备注
     * 
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
