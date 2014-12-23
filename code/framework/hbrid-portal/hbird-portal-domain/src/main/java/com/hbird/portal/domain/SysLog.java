package com.hbird.portal.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hbird.common.utils.serialize.CustomerDateSerializer;

/**
 * User: ljz Date: 2014-04-09 Time: 10:39:34
 */
public class SysLog implements java.io.Serializable {

    private static final long serialVersionUID = -3663400576334093357L;

    /** 自增主键 */
    private Long id;

    /** 操作人 */
    private String userId;

    /** 资源ID */
    private Long rId;

    /** 资源名称 */
    private String rName;

    /** 访问地址 */
    private String url;

    /** 访问内容 */
    private String content;

    /** 访问IP */
    private String ip;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRId() {
        return rId;
    }

    public void setRId(Long rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
