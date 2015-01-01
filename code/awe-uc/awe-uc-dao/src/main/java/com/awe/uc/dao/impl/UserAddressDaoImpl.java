package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.UserAddressDao;
import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * UserAddressDAO实现类<br/>
 * 对'收货地址'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 15:38:38
 * 
 */
@Repository
public class UserAddressDaoImpl extends BaseDao implements UserAddressDao {
    /** namespace */
    private final String namespace = UserAddressDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<UserAddress> queryUserAddressList(UserAddressQuery queryBean) {
        return (List<UserAddress>) queryForList(namespace +".queryUserAddressList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserAddress userAddress) {
        return insert(namespace +".insert", userAddress);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UserAddress userAddress) {
        return update(namespace +".update", userAddress);
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserAddressCount(UserAddressQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryUserAddressCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAddress> queryUserAddressListWithPage(UserAddressQuery queryBean) {
        return (List<UserAddress>) queryForList(namespace +".queryUserAddressListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserAddress configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public UserAddress getUserAddressById(Long id) {
        return (UserAddress) queryForObject(namespace +".getUserAddressById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(UserAddress userAddress) {
        int count = (Integer) queryForObject(namespace +".exist", userAddress);
        return count > 0;
    }
    /**
     * {@inheritDoc}
     */
	public boolean updateDefault(UserAddress userAddress) {
		return update(namespace +".updateDefault", userAddress);
	}
}
