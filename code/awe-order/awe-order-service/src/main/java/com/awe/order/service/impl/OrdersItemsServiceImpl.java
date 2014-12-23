package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;
import com.awe.order.manager.OrdersItemsManager;
import com.awe.order.service.OrdersItemsService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * OrdersItemsService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Service
public class OrdersItemsServiceImpl implements OrdersItemsService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrdersItemsServiceImpl.class);

    @Autowired
    private OrdersItemsManager ordersItemsManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.batchInsert")
    public boolean insert(List<OrdersItems> ordersItemsList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(ordersItemsList)) {
                resultFlag = ordersItemsManager.insert(ordersItemsList);
            } else {
                LOG.warn("OrdersItemsServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.insert")
    public boolean insert(OrdersItems ordersItems) {
        boolean resultFlag = false;
        try {
            if (null != ordersItems) {
                if (ordersItemsManager.exist(ordersItems)) {
                    throw new ExistedException();
                }
                resultFlag = ordersItemsManager.insert(ordersItems);
            } else {
                LOG.warn("OrdersItemsServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrdersItemsServiceImpl#insert failed, ordersItems has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.update")
    public boolean update(OrdersItems ordersItems) {
        boolean resultFlag = false;
        try {
            if (null != ordersItems && null != ordersItems.getId()) {
                resultFlag = ordersItemsManager.update(ordersItems);
            } else {
                LOG.warn("OrdersItemsServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.queryOrdersItemsList")
    public List<OrdersItems> queryOrdersItemsList(OrdersItemsQuery queryBean) {
        List<OrdersItems> ordersItemsList = null;
        try {
            ordersItemsList = ordersItemsManager.queryOrdersItemsList(queryBean);
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#queryOrdersItemsList has error.", e);
        }
        return ordersItemsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.queryOrdersItemsListWithPage")
    public List<OrdersItems> queryOrdersItemsListWithPage(OrdersItemsQuery queryBean, PageUtil pageUtil) {
        List<OrdersItems> ordersItemsList = null;
        try {
            ordersItemsList = ordersItemsManager.queryOrdersItemsListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#queryOrdersItemsListWithPage has error.", e);
        }
        return ordersItemsList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.delete")
    public boolean delete(OrdersItems ordersItems) {
        boolean resultFlag = false;
        try {
            if (null != ordersItems && null != ordersItems.getId()) {
                resultFlag = ordersItemsManager.delete(ordersItems);
            } else {
                LOG.warn("OrdersItemsServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.batchDelete")
    public boolean delete(OrdersItems[] ordersItemss) {
        boolean resultFlag = false;
        try {
            if (null != ordersItemss && ordersItemss.length > 0) {
                resultFlag = ordersItemsManager.delete(ordersItemss);
            } else {
                LOG.warn("OrdersItemsServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrdersItemsService.getOrdersItemsById")
    public OrdersItems getOrdersItemsById(Long id) {
        OrdersItems ordersItems = null;
        try {
            if (null != id) {
                ordersItems = ordersItemsManager.getOrdersItemsById(id);
            } else {
                LOG.warn("OrdersItemsServiceImpl#getOrdersItemsById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrdersItemsServiceImpl#getOrdersItemsById has error.", e);
        }
        return ordersItems;
    }
}

