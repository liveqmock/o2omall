package com.awe.mall.service;

/**
 * 手机短信服务
 * 
 * @author ljz
 * @version 2015-1-4 上午9:28:18
 */
public interface SmsService {

    /**
     * 发送手机短信
     * 
     * @param mobile
     * @param content
     */
    void send(String mobile, String content);

}
