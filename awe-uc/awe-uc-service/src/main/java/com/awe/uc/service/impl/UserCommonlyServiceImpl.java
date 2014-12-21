package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
import com.awe.uc.manager.UserCommonlyManager;
import com.awe.uc.service.UserCommonlyService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserCommonlyService接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Service
public class UserCommonlyServiceImpl implements UserCommonlyService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserCommonlyServiceImpl.class);

    @Autowired
    private UserCommonlyManager userCommonlyManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.batchInsert")
    public boolean insert(List<UserCommonly> userCommonlyList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userCommonlyList)) {
                resultFlag = userCommonlyManager.insert(userCommonlyList);
            } else {
                LOG.warn("UserCommonlyServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.insert")
    public boolean insert(UserCommonly userCommonly) {
        boolean resultFlag = false;
        try {
            if (null != userCommonly) {
                if (userCommonlyManager.exist(userCommonly)) {
                    throw new ExistedException();
                }
                resultFlag = userCommonlyManager.insert(userCommonly);
            } else {
                LOG.warn("UserCommonlyServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserCommonlyServiceImpl#insert failed, userCommonly has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.update")
    public boolean update(UserCommonly userCommonly) {
        boolean resultFlag = false;
        try {
            if (null != userCommonly && null != userCommonly.getId()) {
                resultFlag = userCommonlyManager.update(userCommonly);
            } else {
                LOG.warn("UserCommonlyServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.queryUserCommonlyList")
    public List<UserCommonly> queryUserCommonlyList(UserCommonlyQuery queryBean) {
        List<UserCommonly> userCommonlyList = null;
        try {
            userCommonlyList = userCommonlyManager.queryUserCommonlyList(queryBean);
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#queryUserCommonlyList has error.", e);
        }
        return userCommonlyList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.queryUserCommonlyListWithPage")
    public List<UserCommonly> queryUserCommonlyListWithPage(UserCommonlyQuery queryBean, PageUtil pageUtil) {
        List<UserCommonly> userCommonlyList = null;
        try {
            userCommonlyList = userCommonlyManager.queryUserCommonlyListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#queryUserCommonlyListWithPage has error.", e);
        }
        return userCommonlyList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.delete")
    public boolean delete(UserCommonly userCommonly) {
        boolean resultFlag = false;
        try {
            if (null != userCommonly && null != userCommonly.getId()) {
                resultFlag = userCommonlyManager.delete(userCommonly);
            } else {
                LOG.warn("UserCommonlyServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.batchDelete")
    public boolean delete(UserCommonly[] userCommonlys) {
        boolean resultFlag = false;
        try {
            if (null != userCommonlys && userCommonlys.length > 0) {
                resultFlag = userCommonlyManager.delete(userCommonlys);
            } else {
                LOG.warn("UserCommonlyServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserCommonlyService.getUserCommonlyById")
    public UserCommonly getUserCommonlyById(Long id) {
        UserCommonly userCommonly = null;
        try {
            if (null != id) {
                userCommonly = userCommonlyManager.getUserCommonlyById(id);
            } else {
                LOG.warn("UserCommonlyServiceImpl#getUserCommonlyById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserCommonlyServiceImpl#getUserCommonlyById has error.", e);
        }
        return userCommonly;
    }
}

