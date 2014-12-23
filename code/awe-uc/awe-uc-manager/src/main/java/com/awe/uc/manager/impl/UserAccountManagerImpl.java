package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.awe.uc.dao.UserAccountDao;
import com.awe.uc.manager.UserAccountManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserAccountManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Component
public class UserAccountManagerImpl extends BaseManager implements UserAccountManager {
	
    @Autowired
    private UserAccountDao userAccountDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserAccount> userAccountList) {
        boolean resultFlag = false;
        if (null != userAccountList && userAccountList.size() > 0) {
            for (UserAccount userAccount : userAccountList) {
                resultFlag = userAccountDao.insert(userAccount);
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
    public boolean insert(UserAccount userAccount) {
        return userAccountDao.insert(userAccount);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserAccount userAccount) {
        return userAccountDao.update(userAccount);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAccount> queryUserAccountList(UserAccountQuery queryBean) {
        return userAccountDao.queryUserAccountList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAccount> queryUserAccountListWithPage(UserAccountQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserAccountQuery();
        }

        // 查询总数
        int totalItem = queryUserAccountCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userAccountDao.queryUserAccountListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserAccountCount(UserAccountQuery queryBean) {
        return userAccountDao.queryUserAccountCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserAccount userAccount) {
        return userAccountDao.delete(userAccount);
    }

    /**
     * {@inheritDoc}
     */
    public UserAccount getUserAccountById(Long id) {
        return userAccountDao.getUserAccountById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserAccount[] userAccounts) {
        boolean resultFlag = false;
        if (null != userAccounts && userAccounts.length > 0) {
            for (int i = 0; i < userAccounts.length; i++) {
                resultFlag = delete(userAccounts[i]);
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
    public boolean exist(UserAccount userAccount) {
        return userAccountDao.exist(userAccount);
    }
}
