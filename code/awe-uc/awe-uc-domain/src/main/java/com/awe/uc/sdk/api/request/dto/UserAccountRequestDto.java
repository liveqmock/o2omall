package com.awe.uc.sdk.api.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * UserAccountRequestDto：用户账号请求参数
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserAccountRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** id自增 */
    private Long id;
    /** 账号 */
    private String username;
    /** 密码 */
    private String password;
    /**
     * get id自增
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set id自增
     * 
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get 账号
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set 账号
     * 
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get 密码
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set 密码
     * 
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
