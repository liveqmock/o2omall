/**
 * 
 */
package com.hbird.portal.clients.sso.response.dto;

import java.io.Serializable;

/**
 * 单点登录用户验证返回结果-用户数据
 * 
 * @author ljz
 * 
 */
public class UserObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 用户名 */
    private String username;
    /** 姓名 */
    private String nickname;
    /** dn */
    private String dn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

}
