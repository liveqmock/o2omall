package com.hbird.portal.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hbird.common.utils.serialize.CustomerDateSerializer;

/**
 * User: ljz Date: 2014-04-09 Time: 10:39:34
 */
public class Dep implements java.io.Serializable {

    private static final long serialVersionUID = -7865031984935951240L;

    /** 自增ID */
    private Long id;

    /** 部门编号 */
    private String code;

    /** 部门名称 */
    private String name;

    /** 上级部门编号 */
    private String parentNum;

    /** 是否有子节点 */
    private Integer hasChild;

    /** 层级 */
    private Integer level;

    /** 优先级(顺序) */
    private Integer priority;

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

    /** 备注 */
    private String remark;

    /** 状态（对应集团系统是否有效） */
    private Integer effect;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentNum() {
        return parentNum;
    }

    public void setParentNum(String parentNum) {
        this.parentNum = parentNum;
    }

    public Integer getHasChild() {
        return hasChild;
    }

    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEffect() {
        return effect;
    }

    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    @JsonSerialize(using = CustomerDateSerializer.class)
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
