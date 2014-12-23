package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;
import com.awe.uc.manager.UserProfileManager;
import com.awe.uc.service.UserProfileService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserProfileService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserProfileServiceImpl.class);

    @Autowired
    private UserProfileManager userProfileManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.batchInsert")
    public boolean insert(List<UserProfile> userProfileList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userProfileList)) {
                resultFlag = userProfileManager.insert(userProfileList);
            } else {
                LOG.warn("UserProfileServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.insert")
    public boolean insert(UserProfile userProfile) {
        boolean resultFlag = false;
        try {
            if (null != userProfile) {
                if (userProfileManager.exist(userProfile)) {
                    throw new ExistedException();
                }
                resultFlag = userProfileManager.insert(userProfile);
            } else {
                LOG.warn("UserProfileServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserProfileServiceImpl#insert failed, userProfile has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.update")
    public boolean update(UserProfile userProfile) {
        boolean resultFlag = false;
        try {
            if (null != userProfile && null != userProfile.getId()) {
                resultFlag = userProfileManager.update(userProfile);
            } else {
                LOG.warn("UserProfileServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.queryUserProfileList")
    public List<UserProfile> queryUserProfileList(UserProfileQuery queryBean) {
        List<UserProfile> userProfileList = null;
        try {
            userProfileList = userProfileManager.queryUserProfileList(queryBean);
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#queryUserProfileList has error.", e);
        }
        return userProfileList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.queryUserProfileListWithPage")
    public List<UserProfile> queryUserProfileListWithPage(UserProfileQuery queryBean, PageUtil pageUtil) {
        List<UserProfile> userProfileList = null;
        try {
            userProfileList = userProfileManager.queryUserProfileListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#queryUserProfileListWithPage has error.", e);
        }
        return userProfileList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.delete")
    public boolean delete(UserProfile userProfile) {
        boolean resultFlag = false;
        try {
            if (null != userProfile && null != userProfile.getId()) {
                resultFlag = userProfileManager.delete(userProfile);
            } else {
                LOG.warn("UserProfileServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.batchDelete")
    public boolean delete(UserProfile[] userProfiles) {
        boolean resultFlag = false;
        try {
            if (null != userProfiles && userProfiles.length > 0) {
                resultFlag = userProfileManager.delete(userProfiles);
            } else {
                LOG.warn("UserProfileServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserProfileService.getUserProfileById")
    public UserProfile getUserProfileById(Long id) {
        UserProfile userProfile = null;
        try {
            if (null != id) {
                userProfile = userProfileManager.getUserProfileById(id);
            } else {
                LOG.warn("UserProfileServiceImpl#getUserProfileById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserProfileServiceImpl#getUserProfileById has error.", e);
        }
        return userProfile;
    }
}

