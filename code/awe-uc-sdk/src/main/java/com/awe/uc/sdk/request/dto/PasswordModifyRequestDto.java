package com.awe.uc.sdk.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * PasswordModifyRequestDto 用户密码修改的RequestDto
 * 
 * @author ljz
 * @version 2015-1-2 下午4:34:37
 */
public class PasswordModifyRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    /** 账号 */
    private String username;
    /** 手机号 */
    private String mobile;
    /** 原始密码 */
    private String oldPassword;
    /** 新密码 */
    private String newPassword;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword
     *            the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
