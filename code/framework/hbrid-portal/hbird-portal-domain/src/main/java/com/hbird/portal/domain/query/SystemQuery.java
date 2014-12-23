package com.hbird.portal.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * SystemQuery：业务系统查询类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public class SystemQuery extends Query {

    /** 自增ID */
    private Long id;
    /** 业务系统名称 */
    private String name;
    /** 业务系统编码 */
    private String code;
    /** 优先级 */
    private Integer priority;
    /** 备注 */
    private String remark;
    /** 创建时间 */
    private Date createTime;
    /** 创建人 */
    private String createUser;
    /** 更新时间 */
    private Date updateTime;
    /** 更新人 */
    private String updateUser;
    /** 是否删除 */
    private Integer yn;
    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
