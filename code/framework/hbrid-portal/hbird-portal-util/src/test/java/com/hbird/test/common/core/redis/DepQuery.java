package com.hbird.test.common.core.redis;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * User: ljz Date: 2014-04-09 Time: 10:23:24
 */
public class DepQuery extends Query {
    /** 部门编号 */
    private String code;

    /** 部门名称 */
    private String name;

    /** 上级部门编号 */
    private String parentNum;

    /** 创建人 */
    private String createUser;

    /** 更新人 */
    private String updateUser;

    /** 备注 */
    private String remark;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 删除标识 */
    private int yn;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }
}
