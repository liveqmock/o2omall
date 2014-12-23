package com.hbird.portal.service;

import com.hbird.portal.domain.User;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-15 上午11:25:59
 */
public interface SyncDataService {

    /**
     * 同步部门信息
     */
    void executeDep();

    /**
     * 同步所有用户账户信息
     */
    void executeUser();

    /**
     * 同步单个用户账号信息
     * 
     * @param username
     *            账号
     * @return
     */
    User syncUser(String username);
}
