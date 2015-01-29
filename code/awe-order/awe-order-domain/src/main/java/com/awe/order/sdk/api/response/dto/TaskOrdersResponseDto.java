package com.awe.order.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * TaskOrdersResponseDto：作业表返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
public class TaskOrdersResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 自增ID */
    private Long id; 
    /** 业务类型 */
    private String businesstype; 
    /** 业务主键 */
    private String businessno; 
    /** 业务关键字1 */
    private String keyword1; 
    /** 业务关键字2 */
    private String keyword2; 
    /** 业务关键字3 */
    private String keyword3; 
    /** 业务关键字4 */
    private String keyword4; 
    /** 业务关键字5 */
    private String keyword5; 
    /** 任务状态(1:初始;2:成功;3失败) */
    private Integer taskStatus; 
    /** 执行次数(最大执行6次) */
    private Integer executeCount; 
    /** 创建时间 */
    private Date createTime; 
    /** 创建人 */
    private String createUser; 
    /** 更新时间 */
    private Date updateTime; 
    /** 更新人 */
    private String updateUser; 
    /** 备注 */
    private String remark; 
    /** 是否有效(0:无效;1:有效) */
    private Integer yn; 
    
    /**
     * get 自增ID
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 自增ID
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 业务类型
     * 
     * @return the businesstype
     */
    public String getBusinesstype(){
        return businesstype;
    }
        
    /**
     * set 业务类型
     * 
     * @param businesstype the businesstype to set
     */
    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }
    
    /**
     * get 业务主键
     * 
     * @return the businessno
     */
    public String getBusinessno(){
        return businessno;
    }
        
    /**
     * set 业务主键
     * 
     * @param businessno the businessno to set
     */
    public void setBusinessno(String businessno) {
        this.businessno = businessno;
    }
    
    /**
     * get 业务关键字1
     * 
     * @return the keyword1
     */
    public String getKeyword1(){
        return keyword1;
    }
        
    /**
     * set 业务关键字1
     * 
     * @param keyword1 the keyword1 to set
     */
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }
    
    /**
     * get 业务关键字2
     * 
     * @return the keyword2
     */
    public String getKeyword2(){
        return keyword2;
    }
        
    /**
     * set 业务关键字2
     * 
     * @param keyword2 the keyword2 to set
     */
    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }
    
    /**
     * get 业务关键字3
     * 
     * @return the keyword3
     */
    public String getKeyword3(){
        return keyword3;
    }
        
    /**
     * set 业务关键字3
     * 
     * @param keyword3 the keyword3 to set
     */
    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }
    
    /**
     * get 业务关键字4
     * 
     * @return the keyword4
     */
    public String getKeyword4(){
        return keyword4;
    }
        
    /**
     * set 业务关键字4
     * 
     * @param keyword4 the keyword4 to set
     */
    public void setKeyword4(String keyword4) {
        this.keyword4 = keyword4;
    }
    
    /**
     * get 业务关键字5
     * 
     * @return the keyword5
     */
    public String getKeyword5(){
        return keyword5;
    }
        
    /**
     * set 业务关键字5
     * 
     * @param keyword5 the keyword5 to set
     */
    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5;
    }
    
    /**
     * get 任务状态(1:初始;2:成功;3失败)
     * 
     * @return the taskStatus
     */
    public Integer getTaskStatus(){
        return taskStatus;
    }
        
    /**
     * set 任务状态(1:初始;2:成功;3失败)
     * 
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    /**
     * get 执行次数(最大执行6次)
     * 
     * @return the executeCount
     */
    public Integer getExecuteCount(){
        return executeCount;
    }
        
    /**
     * set 执行次数(最大执行6次)
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
     * get 是否有效(0:无效;1:有效)
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效(0:无效;1:有效)
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
