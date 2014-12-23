package com.hbird.common.web.context;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 登录用户信息
 * 
 * @author ljz
 * @version 2014-11-28 下午4:31:16
 */
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 3254397744596286299L;
    /** 登录用户的Id */
    private Long userId;

    /** 登录用户的账号 */
    private String userName;

    /** 登录用户的中文姓名 */
    private String cnName;

    /** 登录用户的所属部门Id */
    private Long depId;

    /** 登录用户的所属部门名称 */
    private String depName;

    public LoginUser() {
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return the depId
     */
    public Long getDepId() {
        return depId;
    }

    /**
     * @param depId
     *            the depId to set
     */
    public void setDepId(Long depId) {
        this.depId = depId;
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

    @Override
    public String toString() {
        return JsonHelper.toJson(this);
    }

    public static LoginUser parse(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JsonHelper.toBean(value, LoginUser.class);
    }

}
