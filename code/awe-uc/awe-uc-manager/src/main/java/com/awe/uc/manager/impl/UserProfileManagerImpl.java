package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;
import com.awe.uc.dao.UserProfileDao;
import com.awe.uc.manager.UserProfileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserProfileManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Component
public class UserProfileManagerImpl extends BaseManager implements UserProfileManager {
	
    @Autowired
    private UserProfileDao userProfileDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserProfile> userProfileList) {
        boolean resultFlag = false;
        if (null != userProfileList && userProfileList.size() > 0) {
            for (UserProfile userProfile : userProfileList) {
                resultFlag = userProfileDao.insert(userProfile);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserProfile userProfile) {
        return userProfileDao.insert(userProfile);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserProfile userProfile) {
        return userProfileDao.update(userProfile);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserProfile> queryUserProfileList(UserProfileQuery queryBean) {
        return userProfileDao.queryUserProfileList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserProfile> queryUserProfileListWithPage(UserProfileQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserProfileQuery();
        }

        // 查询总数
        int totalItem = queryUserProfileCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userProfileDao.queryUserProfileListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserProfileCount(UserProfileQuery queryBean) {
        return userProfileDao.queryUserProfileCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserProfile userProfile) {
        return userProfileDao.delete(userProfile);
    }

    /**
     * {@inheritDoc}
     */
    public UserProfile getUserProfileById(Long id) {
        return userProfileDao.getUserProfileById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserProfile[] userProfiles) {
        boolean resultFlag = false;
        if (null != userProfiles && userProfiles.length > 0) {
            for (int i = 0; i < userProfiles.length; i++) {
                resultFlag = delete(userProfiles[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(UserProfile userProfile) {
        return userProfileDao.exist(userProfile);
    }
}
