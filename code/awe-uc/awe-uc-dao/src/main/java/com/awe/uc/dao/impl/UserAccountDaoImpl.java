package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserAccountDao;
import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserAccountDAO实现类<br/>
 * 对'用户账号'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Repository
public class UserAccountDaoImpl extends BaseDao implements UserAccountDao {
    /** namespace */
    private final String namespace = UserAccountDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserAccount> queryUserAccountList(UserAccountQuery queryBean) {
        return (List<UserAccount>) queryForList(namespace +".queryUserAccountList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserAccount userAccount) {
        return insert(namespace +".insert", userAccount);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserAccount userAccount) {
        return update(namespace +".update", userAccount);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserAccountCount(UserAccountQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserAccountCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAccount> queryUserAccountListWithPage(UserAccountQuery queryBean) {
        return (List<UserAccount>) queryForList(namespace +".queryUserAccountListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserAccount configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserAccount getUserAccountById(Long id) {
        return (UserAccount) queryForObject(namespace +".getUserAccountById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserAccount userAccount) {
        int count = (Integer) queryForObject(namespace +".exist", userAccount);
        return count > 0;
    }
}
