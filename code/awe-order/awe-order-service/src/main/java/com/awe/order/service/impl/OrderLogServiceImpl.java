package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
import com.awe.order.manager.OrderLogManager;
import com.awe.order.service.OrderLogService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * OrderLogService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Service
public class OrderLogServiceImpl implements OrderLogService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrderLogServiceImpl.class);

    @Autowired
    private OrderLogManager orderLogManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.batchInsert")
    public boolean insert(List<OrderLog> orderLogList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(orderLogList)) {
                resultFlag = orderLogManager.insert(orderLogList);
            } else {
                LOG.warn("OrderLogServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.insert")
    public boolean insert(OrderLog orderLog) {
        boolean resultFlag = false;
        try {
            if (null != orderLog) {
                if (orderLogManager.exist(orderLog)) {
                    throw new ExistedException();
                }
                resultFlag = orderLogManager.insert(orderLog);
            } else {
                LOG.warn("OrderLogServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrderLogServiceImpl#insert failed, orderLog has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.update")
    public boolean update(OrderLog orderLog) {
        boolean resultFlag = false;
        try {
            if (null != orderLog && null != orderLog.getId()) {
                resultFlag = orderLogManager.update(orderLog);
            } else {
                LOG.warn("OrderLogServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.queryOrderLogList")
    public List<OrderLog> queryOrderLogList(OrderLogQuery queryBean) {
        List<OrderLog> orderLogList = null;
        try {
            orderLogList = orderLogManager.queryOrderLogList(queryBean);
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#queryOrderLogList has error.", e);
        }
        return orderLogList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.queryOrderLogListWithPage")
    public List<OrderLog> queryOrderLogListWithPage(OrderLogQuery queryBean, PageUtil pageUtil) {
        List<OrderLog> orderLogList = null;
        try {
            orderLogList = orderLogManager.queryOrderLogListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#queryOrderLogListWithPage has error.", e);
        }
        return orderLogList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.delete")
    public boolean delete(OrderLog orderLog) {
        boolean resultFlag = false;
        try {
            if (null != orderLog && null != orderLog.getId()) {
                resultFlag = orderLogManager.delete(orderLog);
            } else {
                LOG.warn("OrderLogServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.batchDelete")
    public boolean delete(OrderLog[] orderLogs) {
        boolean resultFlag = false;
        try {
            if (null != orderLogs && orderLogs.length > 0) {
                resultFlag = orderLogManager.delete(orderLogs);
            } else {
                LOG.warn("OrderLogServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderLogService.getOrderLogById")
    public OrderLog getOrderLogById(Long id) {
        OrderLog orderLog = null;
        try {
            if (null != id) {
                orderLog = orderLogManager.getOrderLogById(id);
            } else {
                LOG.warn("OrderLogServiceImpl#getOrderLogById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderLogServiceImpl#getOrderLogById has error.", e);
        }
        return orderLog;
    }
}

