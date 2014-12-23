package com.hbird.portal.service;

/**
 * 单点登录服务接口
 * 
 * @author ljz
 * 
 */
public interface SSOService {

    /**
     * 用户账号密码验证
     * 
     * @param name
     * @param password
     * @return
     */
    boolean checkUser(String name, String password);

    /**
     * 加密
     * 
     * @param value
     * @return
     */
    String encode(String value);

    /**
     * 解密
     * 
     * @param value
     * @return
     */
    String decode(String value);
}
