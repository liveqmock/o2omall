package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.awe.uc.manager.UserAccountManager;
import com.awe.uc.service.UserAccountService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserAccountService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserAccountServiceImpl.class);

    @Autowired
    private UserAccountManager userAccountManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.batchInsert")
    public boolean insert(List<UserAccount> userAccountList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userAccountList)) {
                resultFlag = userAccountManager.insert(userAccountList);
            } else {
                LOG.warn("UserAccountServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.insert")
    public boolean insert(UserAccount userAccount) {
        boolean resultFlag = false;
        try {
            if (null != userAccount) {
                if (userAccountManager.exist(userAccount)) {
                    throw new ExistedException();
                }
                resultFlag = userAccountManager.insert(userAccount);
            } else {
                LOG.warn("UserAccountServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserAccountServiceImpl#insert failed, userAccount has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.update")
    public boolean update(UserAccount userAccount) {
        boolean resultFlag = false;
        try {
            if (null != userAccount && null != userAccount.getId()) {
                resultFlag = userAccountManager.update(userAccount);
            } else {
                LOG.warn("UserAccountServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.queryUserAccountList")
    public List<UserAccount> queryUserAccountList(UserAccountQuery queryBean) {
        List<UserAccount> userAccountList = null;
        try {
            userAccountList = userAccountManager.queryUserAccountList(queryBean);
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#queryUserAccountList has error.", e);
        }
        return userAccountList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.queryUserAccountListWithPage")
    public List<UserAccount> queryUserAccountListWithPage(UserAccountQuery queryBean, PageUtil pageUtil) {
        List<UserAccount> userAccountList = null;
        try {
            userAccountList = userAccountManager.queryUserAccountListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#queryUserAccountListWithPage has error.", e);
        }
        return userAccountList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.delete")
    public boolean delete(UserAccount userAccount) {
        boolean resultFlag = false;
        try {
            if (null != userAccount && null != userAccount.getId()) {
                resultFlag = userAccountManager.delete(userAccount);
            } else {
                LOG.warn("UserAccountServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.batchDelete")
    public boolean delete(UserAccount[] userAccounts) {
        boolean resultFlag = false;
        try {
            if (null != userAccounts && userAccounts.length > 0) {
                resultFlag = userAccountManager.delete(userAccounts);
            } else {
                LOG.warn("UserAccountServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAccountService.getUserAccountById")
    public UserAccount getUserAccountById(Long id) {
        UserAccount userAccount = null;
        try {
            if (null != id) {
                userAccount = userAccountManager.getUserAccountById(id);
            } else {
                LOG.warn("UserAccountServiceImpl#getUserAccountById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAccountServiceImpl#getUserAccountById has error.", e);
        }
        return userAccount;
    }
}

