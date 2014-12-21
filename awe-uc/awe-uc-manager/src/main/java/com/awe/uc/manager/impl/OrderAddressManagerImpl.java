package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
import com.awe.uc.dao.OrderAddressDao;
import com.awe.uc.manager.OrderAddressManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderAddressManager接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Component
public class OrderAddressManagerImpl extends BaseManager implements OrderAddressManager {
	
    @Autowired
    private OrderAddressDao orderAddressDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<OrderAddress> orderAddressList) {
        boolean resultFlag = false;
        if (null != orderAddressList && orderAddressList.size() > 0) {
            for (OrderAddress orderAddress : orderAddressList) {
                resultFlag = orderAddressDao.insert(orderAddress);
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
    public boolean insert(OrderAddress orderAddress) {
        return orderAddressDao.insert(orderAddress);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final OrderAddress orderAddress) {
        return orderAddressDao.update(orderAddress);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderAddress> queryOrderAddressList(OrderAddressQuery queryBean) {
        return orderAddressDao.queryOrderAddressList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderAddress> queryOrderAddressListWithPage(OrderAddressQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrderAddressQuery();
        }

        // 查询总数
        int totalItem = queryOrderAddressCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return orderAddressDao.queryOrderAddressListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderAddressCount(OrderAddressQuery queryBean) {
        return orderAddressDao.queryOrderAddressCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderAddress orderAddress) {
        return orderAddressDao.delete(orderAddress);
    }

    /**
     * {@inheritDoc}
     */
    public OrderAddress getOrderAddressById(Long id) {
        return orderAddressDao.getOrderAddressById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final OrderAddress[] orderAddresss) {
        boolean resultFlag = false;
        if (null != orderAddresss && orderAddresss.length > 0) {
            for (int i = 0; i < orderAddresss.length; i++) {
                resultFlag = delete(orderAddresss[i]);
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
    public boolean exist(OrderAddress orderAddress) {
        return orderAddressDao.exist(orderAddress);
    }
}
