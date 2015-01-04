package com.awe.mall.service.impl;

import org.perf4j.aop.Profiled;

import com.awe.mall.service.SmsService;

/**
 * 手机短信服务实现
 * 
 * @author ljz
 * @version 2015-1-4 上午9:30:33
 */
public class SmsServiceImpl implements SmsService {

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SmsService.send")
    public void send(String mobile, String content) {
        // TODO 手机短信服务，未实现

    }

}
