package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.stereotype.Service;

import com.awe.mall.service.SmsService;

/**
 * 模拟简单的短信发送：输出到log
 * 
 * @author ljz
 * @version 2015-1-4 上午9:31:01
 */
@Service
public class SimpleSmsServiceImpl implements SmsService {
    private static final Log LOG = LogFactory.getLog(SimpleSmsServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SmsService.send")
    public void send(String mobile, String content) {
        LOG.info("发送短信到手机号：" + mobile);
        LOG.info("短信内容：" + content);
    }

}
