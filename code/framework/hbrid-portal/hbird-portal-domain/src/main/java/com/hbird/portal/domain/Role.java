package com.hbird.portal.domain;

import com.hbird.common.utils.serialize.CustomerDateSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * User: ljz Date: 2014-04-09 Time: 10:39:34
 */
public class Role implements java.io.Serializable {

    private static final long serialVersionUID = -4517981147038738992L;

    /** id自增 */
    private Long id;

    /** 业务系统表示 */
    private Long sysId;

    /** 角色名称 */
    private String name;

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

    /**
     * 是否删除 0:否 1:是
     */
    private Integer yn = 0;

    /**
     * 角色编码
     */
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @JsonSerialize(using = CustomerDateSerializer.class)
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

    @JsonSerialize(using = CustomerDateSerializer.class)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
