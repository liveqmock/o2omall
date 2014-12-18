package com.hbird.portal.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * ResourceQuery：资源表查询类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public class ResourceQuery extends Query {

    /** 自增ID */
    private Long id;
    /** 业务系统编码 */
    private String sysCode;
    /** 资源类型 */
    private Integer type;
    /** 资源编码 */
    private String code;
    /** 资源名称 */
    private String name;
    /** 菜单URL */
    private String url;
    /** 是否可点击 */
    private Integer isClick;
    /** 父资源ID */
    private Long parentId;
    /** 是否有子资源 */
    private Integer hasChild;
    /** 层级 */
    private Integer level;
    /** 优先级 */
    private Integer priority;
    /** 图标 */
    private String icon;
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

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsClick() {
        return isClick;
    }

    public void setIsClick(Integer isClick) {
        this.isClick = isClick;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
