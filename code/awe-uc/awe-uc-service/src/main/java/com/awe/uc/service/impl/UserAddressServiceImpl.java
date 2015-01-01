package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
import com.awe.uc.manager.UserAddressManager;
import com.awe.uc.service.UserAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * UserAddressService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(UserAddressServiceImpl.class);

    @Autowired
    private UserAddressManager userAddressManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.batchInsert")
    public boolean insert(List<UserAddress> userAddressList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(userAddressList)) {
                resultFlag = userAddressManager.insert(userAddressList);
            } else {
                LOG.warn("UserAddressServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.insert")
    public boolean insert(UserAddress userAddress) {
        boolean resultFlag = false;
        try {
            if (null != userAddress) {
                if (userAddressManager.exist(userAddress)) {
                    throw new ExistedException();
                }
                resultFlag = userAddressManager.insert(userAddress);
                if(resultFlag&&userAddress.getIsdefault()==1){
                	userAddressManager.updateDefault(userAddress);
                }
            } else {
                LOG.warn("UserAddressServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("UserAddressServiceImpl#insert failed, userAddress has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.update")
    public boolean update(UserAddress userAddress) {
        boolean resultFlag = false;
        try {
            if (null != userAddress && null != userAddress.getId()) {
                resultFlag = userAddressManager.update(userAddress);
                if(resultFlag&&userAddress.getIsdefault()==1){
                	userAddressManager.updateDefault(userAddress);
                }
            } else {
                LOG.warn("UserAddressServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.queryUserAddressList")
    public List<UserAddress> queryUserAddressList(UserAddressQuery queryBean) {
        List<UserAddress> userAddressList = null;
        try {
            userAddressList = userAddressManager.queryUserAddressList(queryBean);
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#queryUserAddressList has error.", e);
        }
        return userAddressList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.queryUserAddressListWithPage")
    public List<UserAddress> queryUserAddressListWithPage(UserAddressQuery queryBean, PageUtil pageUtil) {
        List<UserAddress> userAddressList = null;
        try {
            userAddressList = userAddressManager.queryUserAddressListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#queryUserAddressListWithPage has error.", e);
        }
        return userAddressList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.delete")
    public boolean delete(UserAddress userAddress) {
        boolean resultFlag = false;
        try {
            if (null != userAddress && null != userAddress.getId()) {
                resultFlag = userAddressManager.delete(userAddress);
            } else {
                LOG.warn("UserAddressServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.batchDelete")
    public boolean delete(UserAddress[] userAddresss) {
        boolean resultFlag = false;
        try {
            if (null != userAddresss && userAddresss.length > 0) {
                resultFlag = userAddressManager.delete(userAddresss);
            } else {
                LOG.warn("UserAddressServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "UserAddressService.getUserAddressById")
    public UserAddress getUserAddressById(Long id) {
        UserAddress userAddress = null;
        try {
            if (null != id) {
                userAddress = userAddressManager.getUserAddressById(id);
            } else {
                LOG.warn("UserAddressServiceImpl#getUserAddressById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("UserAddressServiceImpl#getUserAddressById has error.", e);
        }
        return userAddress;
    }
}

