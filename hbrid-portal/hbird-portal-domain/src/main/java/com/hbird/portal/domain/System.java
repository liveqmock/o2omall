package com.hbird.portal.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hbird.common.utils.serialize.CustomerDateSerializer;

/**
 * System：业务系统实体类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public class System implements java.io.Serializable {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

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

    @JsonSerialize(using = CustomerDateSerializer.class)
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

    @JsonSerialize(using = CustomerDateSerializer.class)
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
}
