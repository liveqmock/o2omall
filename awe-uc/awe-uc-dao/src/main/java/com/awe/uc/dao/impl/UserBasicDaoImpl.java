package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserBasicDao;
import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserBasicDAO实现类<br/>
 * 对'用户基本信息'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
@Repository
public class UserBasicDaoImpl extends BaseDao implements UserBasicDao {
    /** namespace */
    private final String namespace = UserBasicDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserBasic> queryUserBasicList(UserBasicQuery queryBean) {
        return (List<UserBasic>) queryForList(namespace +".queryUserBasicList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserBasic userBasic) {
        return insert(namespace +".insert", userBasic);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserBasic userBasic) {
        return update(namespace +".update", userBasic);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserBasicCount(UserBasicQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserBasicCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserBasic> queryUserBasicListWithPage(UserBasicQuery queryBean) {
        return (List<UserBasic>) queryForList(namespace +".queryUserBasicListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserBasic configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserBasic getUserBasicById(Long id) {
        return (UserBasic) queryForObject(namespace +".getUserBasicById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserBasic userBasic) {
        int count = (Integer) queryForObject(namespace +".exist", userBasic);
        return count > 0;
    }
}
