package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
import com.awe.uc.dao.UserAddressDao;
import com.awe.uc.manager.UserAddressManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserAddressManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
@Component
public class UserAddressManagerImpl extends BaseManager implements UserAddressManager {
	
    @Autowired
    private UserAddressDao userAddressDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserAddress> userAddressList) {
        boolean resultFlag = false;
        if (null != userAddressList && userAddressList.size() > 0) {
            for (UserAddress userAddress : userAddressList) {
                resultFlag = userAddressDao.insert(userAddress);
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
    public boolean insert(UserAddress userAddress) {
        return userAddressDao.insert(userAddress);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserAddress userAddress) {
        return userAddressDao.update(userAddress);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAddress> queryUserAddressList(UserAddressQuery queryBean) {
        return userAddressDao.queryUserAddressList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserAddress> queryUserAddressListWithPage(UserAddressQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserAddressQuery();
        }

        // 查询总数
        int totalItem = queryUserAddressCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userAddressDao.queryUserAddressListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserAddressCount(UserAddressQuery queryBean) {
        return userAddressDao.queryUserAddressCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserAddress userAddress) {
        return userAddressDao.delete(userAddress);
    }

    /**
     * {@inheritDoc}
     */
    public UserAddress getUserAddressById(Long id) {
        return userAddressDao.getUserAddressById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserAddress[] userAddresss) {
        boolean resultFlag = false;
        if (null != userAddresss && userAddresss.length > 0) {
            for (int i = 0; i < userAddresss.length; i++) {
                resultFlag = delete(userAddresss[i]);
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
    public boolean exist(UserAddress userAddress) {
        return userAddressDao.exist(userAddress);
    }
    /**
     * {@inheritDoc}
     */
	public boolean updateDefault(UserAddress userAddress) {
		return userAddressDao.updateDefault(userAddress);
	}
}
