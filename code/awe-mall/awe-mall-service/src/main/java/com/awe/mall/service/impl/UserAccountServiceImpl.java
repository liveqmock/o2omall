package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.UserAccountService;
import com.awe.uc.sdk.UserAccountClient;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 用户账号服务实现类
 * 
 * @author ljz
 * @version 2014-12-30 下午5:03:58
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountClient userAccountClient;

    private static final Log LOG = LogFactory.getLog(UserAccountServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.register")
    public Wrapper<?> register(String username, String password) {
        Wrapper<?> wrapper = null;

        try {
            wrapper = userAccountClient.register(username, password);
        } catch (Exception e) {
            LOG.warn("UserAccountService#register fail,", e);
        }
        return wrapper;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.login")
    public UserAccountResponseDto login(String username, String password) {
        UserAccountResponseDto responseDto = null;

        try {
            responseDto = userAccountClient.login(username, password);
        } catch (Exception e) {
            LOG.warn("UserAccountService#login fail,", e);
        }
        return responseDto;
    }

}
