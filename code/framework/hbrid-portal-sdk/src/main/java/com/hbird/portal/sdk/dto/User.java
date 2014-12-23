/**
 * 
 */
package com.hbird.portal.sdk.dto;

import com.hbird.common.sdk.api.HbirdObject;

/**
 * 用户对象<br/>
 * 
 * @author ljz
 * 
 */
public class User implements HbirdObject {

    /**
     * 
     */
    private static final long serialVersionUID = 6408783076375914877L;

    /** 用户ID */
    private Long id;

    /** 登录账号 */
    private String name;

    /** 中文姓名 */
    private String cnName;

    /** 邮箱 */
    private String email;

    /** 部门名称 */
    private String depName;

    /** 联系方式 */
    private String phoneNo;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cnName
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * @param cnName
     *            the cnName to set
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the depName
     */
    public String getDepName() {
        return depName;
    }

    /**
     * @param depName
     *            the depName to set
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo
     *            the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
