package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;
import com.awe.order.dao.OrdersItemsDao;
import com.awe.order.manager.OrdersItemsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrdersItemsManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Component
public class OrdersItemsManagerImpl extends BaseManager implements OrdersItemsManager {
	
    @Autowired
    private OrdersItemsDao ordersItemsDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<OrdersItems> ordersItemsList) {
        boolean resultFlag = false;
        if (null != ordersItemsList && ordersItemsList.size() > 0) {
            for (OrdersItems ordersItems : ordersItemsList) {
                resultFlag = ordersItemsDao.insert(ordersItems);
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
    public boolean insert(OrdersItems ordersItems) {
        return ordersItemsDao.insert(ordersItems);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final OrdersItems ordersItems) {
        return ordersItemsDao.update(ordersItems);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrdersItems> queryOrdersItemsList(OrdersItemsQuery queryBean) {
        return ordersItemsDao.queryOrdersItemsList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrdersItems> queryOrdersItemsListWithPage(OrdersItemsQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrdersItemsQuery();
        }

        // 查询总数
        int totalItem = queryOrdersItemsCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return ordersItemsDao.queryOrdersItemsListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrdersItemsCount(OrdersItemsQuery queryBean) {
        return ordersItemsDao.queryOrdersItemsCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrdersItems ordersItems) {
        return ordersItemsDao.delete(ordersItems);
    }

    /**
     * {@inheritDoc}
     */
    public OrdersItems getOrdersItemsById(Long id) {
        return ordersItemsDao.getOrdersItemsById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final OrdersItems[] ordersItemss) {
        boolean resultFlag = false;
        if (null != ordersItemss && ordersItemss.length > 0) {
            for (int i = 0; i < ordersItemss.length; i++) {
                resultFlag = delete(ordersItemss[i]);
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
    public boolean exist(OrdersItems ordersItems) {
        return ordersItemsDao.exist(ordersItems);
    }
}
