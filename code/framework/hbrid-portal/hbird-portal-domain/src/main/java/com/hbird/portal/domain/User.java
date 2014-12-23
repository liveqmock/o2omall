package com.hbird.portal.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hbird.common.utils.serialize.CustomerDateSerializer;

/**
 * User: ljz Date: 2014-04-09 Time: 10:39:34
 */
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 8737445547841038356L;

    /** Id自增 */
    private Long id;

    /** 登录账号 */
    private String name;

    /** 登录密码 */
    private String password;

    /** 中文姓名 */
    private String cnName;

    /** 邮箱 */
    private String email;

    /** 联系方式 */
    private String phoneNo;

    /** 岗位 */
    private String jobTitle;

    /** 状态（正常，离职，停职等） */
    private Integer status;

    /** 用户类型（内部，外派） */
    private Integer userType;

    /** 所属部门ID */
    private Long depId;

    /**
     * 所属部门
     */
    private Dep dep;
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

    /**
     * 员工编号
     */
    private String code;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonSerialize(using = CustomerDateSerializer.class)
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

}
