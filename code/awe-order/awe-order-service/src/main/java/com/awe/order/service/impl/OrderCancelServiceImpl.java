package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.manager.OrderCancelManager;
import com.awe.order.service.OrderCancelService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * OrderCancelService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Service
public class OrderCancelServiceImpl implements OrderCancelService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrderCancelServiceImpl.class);

    @Autowired
    private OrderCancelManager orderCancelManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.batchInsert")
    public boolean insert(List<OrderCancel> orderCancelList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(orderCancelList)) {
                resultFlag = orderCancelManager.insert(orderCancelList);
            } else {
                LOG.warn("OrderCancelServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.insert")
    public boolean insert(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel) {
                if (orderCancelManager.exist(orderCancel)) {
                    throw new ExistedException();
                }
                resultFlag = orderCancelManager.insert(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrderCancelServiceImpl#insert failed, orderCancel has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.update")
    public boolean update(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel && null != orderCancel.getId()) {
                resultFlag = orderCancelManager.update(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.queryOrderCancelList")
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean) {
        List<OrderCancel> orderCancelList = null;
        try {
            orderCancelList = orderCancelManager.queryOrderCancelList(queryBean);
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#queryOrderCancelList has error.", e);
        }
        return orderCancelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.queryOrderCancelListWithPage")
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean, PageUtil pageUtil) {
        List<OrderCancel> orderCancelList = null;
        try {
            orderCancelList = orderCancelManager.queryOrderCancelListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#queryOrderCancelListWithPage has error.", e);
        }
        return orderCancelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.delete")
    public boolean delete(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel && null != orderCancel.getId()) {
                resultFlag = orderCancelManager.delete(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.batchDelete")
    public boolean delete(OrderCancel[] orderCancels) {
        boolean resultFlag = false;
        try {
            if (null != orderCancels && orderCancels.length > 0) {
                resultFlag = orderCancelManager.delete(orderCancels);
            } else {
                LOG.warn("OrderCancelServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.getOrderCancelById")
    public OrderCancel getOrderCancelById(Long id) {
        OrderCancel orderCancel = null;
        try {
            if (null != id) {
                orderCancel = orderCancelManager.getOrderCancelById(id);
            } else {
                LOG.warn("OrderCancelServiceImpl#getOrderCancelById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#getOrderCancelById has error.", e);
        }
        return orderCancel;
    }
}

