package com.hbird.portal.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午10:06:59
 */
public class UserRoleQuery extends Query {

    /**
     * 用户角色表ID
     */
    private Long id;

    /**
     * 用户表ID
     */
    private Long userId;

    /**
     * 角色表ID
     */
    private Long roleId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /**
     * 是否删除： 1，删除，无效； 0，不删除，有效
     */
    private Integer yn;

    public UserRoleQuery() {
        // TODO Auto-generated constructor stub
    }

    public UserRoleQuery(Long userId) {
        this.userId = userId;
    }

    private String[] userIds;

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
