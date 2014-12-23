package com.hbird.portal.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.portal.clients.sso.SsoUserClient;
import com.hbird.portal.service.SSOService;

/**
 * 单点登录服务实现类
 * 
 * @author ljz
 * 
 */
@Service
public class SSOServiceImpl implements SSOService {

    @Autowired
    private SsoUserClient ssoUserClient;

    private final static Logger log = LogManager.getLogger(SSOServiceImpl.class);

    @Profiled(tag = "SSOService.checkUser")
    public boolean checkUser(String name, String password) {
        boolean resultFlag = false;
        try {
            resultFlag = ssoUserClient.checkUser(name, password);
        } catch (Exception e) {
            log.error("SSOService checkUser has error,", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SSOService.encode")
    public String encode(String value) {
        String result = null;
        try {
            result = ssoUserClient.encode(value);
        } catch (Exception e) {
            log.error("SSOService encode has error,", e);
        }
        return result;
    }

    @Profiled(tag = "SSOService.decode")
    public String decode(String value) {
        String result = null;
        try {
            result = ssoUserClient.decode(value);
        } catch (Exception e) {
            log.error("SSOService decode has error,", e);
        }
        return result;
    }

}
