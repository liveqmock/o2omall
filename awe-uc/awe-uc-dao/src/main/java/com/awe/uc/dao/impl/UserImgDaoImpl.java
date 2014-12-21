package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserImgDao;
import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserImgDAO实现类<br/>
 * 对'用户关联图片'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
@Repository
public class UserImgDaoImpl extends BaseDao implements UserImgDao {
    /** namespace */
    private final String namespace = UserImgDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserImg> queryUserImgList(UserImgQuery queryBean) {
        return (List<UserImg>) queryForList(namespace +".queryUserImgList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserImg userImg) {
        return insert(namespace +".insert", userImg);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserImg userImg) {
        return update(namespace +".update", userImg);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserImgCount(UserImgQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserImgCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserImg> queryUserImgListWithPage(UserImgQuery queryBean) {
        return (List<UserImg>) queryForList(namespace +".queryUserImgListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserImg configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserImg getUserImgById(Long id) {
        return (UserImg) queryForObject(namespace +".getUserImgById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserImg userImg) {
        int count = (Integer) queryForObject(namespace +".exist", userImg);
        return count > 0;
    }
}
