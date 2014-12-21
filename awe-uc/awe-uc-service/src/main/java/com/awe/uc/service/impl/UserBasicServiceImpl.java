package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
import com.awe.uc.manager.UserBasicManager;
import com.awe.uc.service.UserBasicService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserBasicService接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Service
public class UserBasicServiceImpl implements UserBasicService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserBasicServiceImpl.class);

    @Autowired
    private UserBasicManager userBasicManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.batchInsert")
    public boolean insert(List<UserBasic> userBasicList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userBasicList)) {
                resultFlag = userBasicManager.insert(userBasicList);
            } else {
                LOG.warn("UserBasicServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.insert")
    public boolean insert(UserBasic userBasic) {
        boolean resultFlag = false;
        try {
            if (null != userBasic) {
                if (userBasicManager.exist(userBasic)) {
                    throw new ExistedException();
                }
                resultFlag = userBasicManager.insert(userBasic);
            } else {
                LOG.warn("UserBasicServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserBasicServiceImpl#insert failed, userBasic has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.update")
    public boolean update(UserBasic userBasic) {
        boolean resultFlag = false;
        try {
            if (null != userBasic && null != userBasic.getId()) {
                resultFlag = userBasicManager.update(userBasic);
            } else {
                LOG.warn("UserBasicServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.queryUserBasicList")
    public List<UserBasic> queryUserBasicList(UserBasicQuery queryBean) {
        List<UserBasic> userBasicList = null;
        try {
            userBasicList = userBasicManager.queryUserBasicList(queryBean);
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#queryUserBasicList has error.", e);
        }
        return userBasicList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.queryUserBasicListWithPage")
    public List<UserBasic> queryUserBasicListWithPage(UserBasicQuery queryBean, PageUtil pageUtil) {
        List<UserBasic> userBasicList = null;
        try {
            userBasicList = userBasicManager.queryUserBasicListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#queryUserBasicListWithPage has error.", e);
        }
        return userBasicList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.delete")
    public boolean delete(UserBasic userBasic) {
        boolean resultFlag = false;
        try {
            if (null != userBasic && null != userBasic.getId()) {
                resultFlag = userBasicManager.delete(userBasic);
            } else {
                LOG.warn("UserBasicServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.batchDelete")
    public boolean delete(UserBasic[] userBasics) {
        boolean resultFlag = false;
        try {
            if (null != userBasics && userBasics.length > 0) {
                resultFlag = userBasicManager.delete(userBasics);
            } else {
                LOG.warn("UserBasicServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserBasicService.getUserBasicById")
    public UserBasic getUserBasicById(Long id) {
        UserBasic userBasic = null;
        try {
            if (null != id) {
                userBasic = userBasicManager.getUserBasicById(id);
            } else {
                LOG.warn("UserBasicServiceImpl#getUserBasicById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserBasicServiceImpl#getUserBasicById has error.", e);
        }
        return userBasic;
    }
}

