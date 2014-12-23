package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.dao.OrderCancelDao;
import com.awe.order.manager.OrderCancelManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderCancelManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Component
public class OrderCancelManagerImpl extends BaseManager implements OrderCancelManager {
	
    @Autowired
    private OrderCancelDao orderCancelDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<OrderCancel> orderCancelList) {
        boolean resultFlag = false;
        if (null != orderCancelList && orderCancelList.size() > 0) {
            for (OrderCancel orderCancel : orderCancelList) {
                resultFlag = orderCancelDao.insert(orderCancel);
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
    public boolean insert(OrderCancel orderCancel) {
        return orderCancelDao.insert(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final OrderCancel orderCancel) {
        return orderCancelDao.update(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean) {
        return orderCancelDao.queryOrderCancelList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrderCancelQuery();
        }

        // 查询总数
        int totalItem = queryOrderCancelCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return orderCancelDao.queryOrderCancelListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderCancelCount(OrderCancelQuery queryBean) {
        return orderCancelDao.queryOrderCancelCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderCancel orderCancel) {
        return orderCancelDao.delete(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public OrderCancel getOrderCancelById(Long id) {
        return orderCancelDao.getOrderCancelById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final OrderCancel[] orderCancels) {
        boolean resultFlag = false;
        if (null != orderCancels && orderCancels.length > 0) {
            for (int i = 0; i < orderCancels.length; i++) {
                resultFlag = delete(orderCancels[i]);
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
    public boolean exist(OrderCancel orderCancel) {
        return orderCancelDao.exist(orderCancel);
    }
}
