package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
import com.awe.uc.dao.UserCommonlyDao;
import com.awe.uc.manager.UserCommonlyManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserCommonlyManager接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Component
public class UserCommonlyManagerImpl extends BaseManager implements UserCommonlyManager {
	
    @Autowired
    private UserCommonlyDao userCommonlyDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserCommonly> userCommonlyList) {
        boolean resultFlag = false;
        if (null != userCommonlyList && userCommonlyList.size() > 0) {
            for (UserCommonly userCommonly : userCommonlyList) {
                resultFlag = userCommonlyDao.insert(userCommonly);
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
    public boolean insert(UserCommonly userCommonly) {
        return userCommonlyDao.insert(userCommonly);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserCommonly userCommonly) {
        return userCommonlyDao.update(userCommonly);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserCommonly> queryUserCommonlyList(UserCommonlyQuery queryBean) {
        return userCommonlyDao.queryUserCommonlyList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserCommonly> queryUserCommonlyListWithPage(UserCommonlyQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserCommonlyQuery();
        }

        // 查询总数
        int totalItem = queryUserCommonlyCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userCommonlyDao.queryUserCommonlyListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserCommonlyCount(UserCommonlyQuery queryBean) {
        return userCommonlyDao.queryUserCommonlyCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserCommonly userCommonly) {
        return userCommonlyDao.delete(userCommonly);
    }

    /**
     * {@inheritDoc}
     */
    public UserCommonly getUserCommonlyById(Long id) {
        return userCommonlyDao.getUserCommonlyById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserCommonly[] userCommonlys) {
        boolean resultFlag = false;
        if (null != userCommonlys && userCommonlys.length > 0) {
            for (int i = 0; i < userCommonlys.length; i++) {
                resultFlag = delete(userCommonlys[i]);
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
    public boolean exist(UserCommonly userCommonly) {
        return userCommonlyDao.exist(userCommonly);
    }
}
