package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
import com.awe.uc.manager.UserImgManager;
import com.awe.uc.service.UserImgService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserImgService接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Service
public class UserImgServiceImpl implements UserImgService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserImgServiceImpl.class);

    @Autowired
    private UserImgManager userImgManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.batchInsert")
    public boolean insert(List<UserImg> userImgList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userImgList)) {
                resultFlag = userImgManager.insert(userImgList);
            } else {
                LOG.warn("UserImgServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.insert")
    public boolean insert(UserImg userImg) {
        boolean resultFlag = false;
        try {
            if (null != userImg) {
                if (userImgManager.exist(userImg)) {
                    throw new ExistedException();
                }
                resultFlag = userImgManager.insert(userImg);
            } else {
                LOG.warn("UserImgServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserImgServiceImpl#insert failed, userImg has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.update")
    public boolean update(UserImg userImg) {
        boolean resultFlag = false;
        try {
            if (null != userImg && null != userImg.getId()) {
                resultFlag = userImgManager.update(userImg);
            } else {
                LOG.warn("UserImgServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.queryUserImgList")
    public List<UserImg> queryUserImgList(UserImgQuery queryBean) {
        List<UserImg> userImgList = null;
        try {
            userImgList = userImgManager.queryUserImgList(queryBean);
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#queryUserImgList has error.", e);
        }
        return userImgList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.queryUserImgListWithPage")
    public List<UserImg> queryUserImgListWithPage(UserImgQuery queryBean, PageUtil pageUtil) {
        List<UserImg> userImgList = null;
        try {
            userImgList = userImgManager.queryUserImgListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#queryUserImgListWithPage has error.", e);
        }
        return userImgList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.delete")
    public boolean delete(UserImg userImg) {
        boolean resultFlag = false;
        try {
            if (null != userImg && null != userImg.getId()) {
                resultFlag = userImgManager.delete(userImg);
            } else {
                LOG.warn("UserImgServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.batchDelete")
    public boolean delete(UserImg[] userImgs) {
        boolean resultFlag = false;
        try {
            if (null != userImgs && userImgs.length > 0) {
                resultFlag = userImgManager.delete(userImgs);
            } else {
                LOG.warn("UserImgServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserImgService.getUserImgById")
    public UserImg getUserImgById(Long id) {
        UserImg userImg = null;
        try {
            if (null != id) {
                userImg = userImgManager.getUserImgById(id);
            } else {
                LOG.warn("UserImgServiceImpl#getUserImgById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserImgServiceImpl#getUserImgById has error.", e);
        }
        return userImg;
    }
}

