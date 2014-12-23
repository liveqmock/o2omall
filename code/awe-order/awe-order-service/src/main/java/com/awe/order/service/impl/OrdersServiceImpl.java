package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.manager.OrdersManager;
import com.awe.order.service.OrdersService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * OrdersService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrdersServiceImpl.class);

    @Autowired
    private OrdersManager ordersManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.batchInsert")
    public boolean insert(List<Orders> ordersList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(ordersList)) {
                resultFlag = ordersManager.insert(ordersList);
            } else {
                LOG.warn("OrdersServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.insert")
    public boolean insert(Orders orders) {
        boolean resultFlag = false;
        try {
            if (null != orders) {
                if (ordersManager.exist(orders)) {
                    throw new ExistedException();
                }
                resultFlag = ordersManager.insert(orders);
            } else {
                LOG.warn("OrdersServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrdersServiceImpl#insert failed, orders has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.update")
    public boolean update(Orders orders) {
        boolean resultFlag = false;
        try {
            if (null != orders && null != orders.getId()) {
                resultFlag = ordersManager.update(orders);
            } else {
                LOG.warn("OrdersServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.queryOrdersList")
    public List<Orders> queryOrdersList(OrdersQuery queryBean) {
        List<Orders> ordersList = null;
        try {
            ordersList = ordersManager.queryOrdersList(queryBean);
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#queryOrdersList has error.", e);
        }
        return ordersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.queryOrdersListWithPage")
    public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean, PageUtil pageUtil) {
        List<Orders> ordersList = null;
        try {
            ordersList = ordersManager.queryOrdersListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#queryOrdersListWithPage has error.", e);
        }
        return ordersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.delete")
    public boolean delete(Orders orders) {
        boolean resultFlag = false;
        try {
            if (null != orders && null != orders.getId()) {
                resultFlag = ordersManager.delete(orders);
            } else {
                LOG.warn("OrdersServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.batchDelete")
    public boolean delete(Orders[] orderss) {
        boolean resultFlag = false;
        try {
            if (null != orderss && orderss.length > 0) {
                resultFlag = ordersManager.delete(orderss);
            } else {
                LOG.warn("OrdersServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersService.getOrdersById")
    public Orders getOrdersById(Long id) {
        Orders orders = null;
        try {
            if (null != id) {
                orders = ordersManager.getOrdersById(id);
            } else {
                LOG.warn("OrdersServiceImpl#getOrdersById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersServiceImpl#getOrdersById has error.", e);
        }
        return orders;
    }
}

