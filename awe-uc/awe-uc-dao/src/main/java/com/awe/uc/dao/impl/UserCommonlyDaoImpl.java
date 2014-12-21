package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserCommonlyDao;
import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserCommonlyDAO实现类<br/>
 * 对'用户-常用信息'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
@Repository
public class UserCommonlyDaoImpl extends BaseDao implements UserCommonlyDao {
    /** namespace */
    private final String namespace = UserCommonlyDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserCommonly> queryUserCommonlyList(UserCommonlyQuery queryBean) {
        return (List<UserCommonly>) queryForList(namespace +".queryUserCommonlyList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserCommonly userCommonly) {
        return insert(namespace +".insert", userCommonly);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserCommonly userCommonly) {
        return update(namespace +".update", userCommonly);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserCommonlyCount(UserCommonlyQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserCommonlyCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserCommonly> queryUserCommonlyListWithPage(UserCommonlyQuery queryBean) {
        return (List<UserCommonly>) queryForList(namespace +".queryUserCommonlyListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserCommonly configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserCommonly getUserCommonlyById(Long id) {
        return (UserCommonly) queryForObject(namespace +".getUserCommonlyById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserCommonly userCommonly) {
        int count = (Integer) queryForObject(namespace +".exist", userCommonly);
        return count > 0;
    }
}
