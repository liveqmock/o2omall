package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserProfileDao;
import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserProfileDAO实现类<br/>
 * 对'用户基本信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 15:38:38
 * 
 */
@Repository
public class UserProfileDaoImpl extends BaseDao implements UserProfileDao {
    /** namespace */
    private final String namespace = UserProfileDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserProfile> queryUserProfileList(UserProfileQuery queryBean) {
        return (List<UserProfile>) queryForList(namespace +".queryUserProfileList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserProfile userProfile) {
        return insert(namespace +".insert", userProfile);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserProfile userProfile) {
        return update(namespace +".update", userProfile);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserProfileCount(UserProfileQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserProfileCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserProfile> queryUserProfileListWithPage(UserProfileQuery queryBean) {
        return (List<UserProfile>) queryForList(namespace +".queryUserProfileListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserProfile configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserProfile getUserProfileById(Long id) {
        return (UserProfile) queryForObject(namespace +".getUserProfileById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserProfile userProfile) {
        int count = (Integer) queryForObject(namespace +".exist", userProfile);
        return count > 0;
    }

	public UserProfile getUserProfileByBean(UserProfile userProfile) {
		return (UserProfile) queryForObject(namespace +".getUserProfileByBean", userProfile);
	}
}
