package com.hbird.portal.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * User: ljz Date: 2014-04-09 Time: 10:23:24
 */
public class SysLogQuery extends Query {
    /** 操作人 */
    private String userId;

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

    /** 创建人 */
    private String createUser;

    /** 更新人 */
    private String updateUser;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 删除标识 */
    private int yn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }
}
