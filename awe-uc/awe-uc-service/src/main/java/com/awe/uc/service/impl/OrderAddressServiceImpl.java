package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
import com.awe.uc.manager.OrderAddressManager;
import com.awe.uc.service.OrderAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * OrderAddressService接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Service
public class OrderAddressServiceImpl implements OrderAddressService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrderAddressServiceImpl.class);

    @Autowired
    private OrderAddressManager orderAddressManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.batchInsert")
    public boolean insert(List<OrderAddress> orderAddressList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(orderAddressList)) {
                resultFlag = orderAddressManager.insert(orderAddressList);
            } else {
                LOG.warn("OrderAddressServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.insert")
    public boolean insert(OrderAddress orderAddress) {
        boolean resultFlag = false;
        try {
            if (null != orderAddress) {
                if (orderAddressManager.exist(orderAddress)) {
                    throw new ExistedException();
                }
                resultFlag = orderAddressManager.insert(orderAddress);
            } else {
                LOG.warn("OrderAddressServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrderAddressServiceImpl#insert failed, orderAddress has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.update")
    public boolean update(OrderAddress orderAddress) {
        boolean resultFlag = false;
        try {
            if (null != orderAddress && null != orderAddress.getId()) {
                resultFlag = orderAddressManager.update(orderAddress);
            } else {
                LOG.warn("OrderAddressServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.queryOrderAddressList")
    public List<OrderAddress> queryOrderAddressList(OrderAddressQuery queryBean) {
        List<OrderAddress> orderAddressList = null;
        try {
            orderAddressList = orderAddressManager.queryOrderAddressList(queryBean);
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#queryOrderAddressList has error.", e);
        }
        return orderAddressList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.queryOrderAddressListWithPage")
    public List<OrderAddress> queryOrderAddressListWithPage(OrderAddressQuery queryBean, PageUtil pageUtil) {
        List<OrderAddress> orderAddressList = null;
        try {
            orderAddressList = orderAddressManager.queryOrderAddressListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#queryOrderAddressListWithPage has error.", e);
        }
        return orderAddressList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.delete")
    public boolean delete(OrderAddress orderAddress) {
        boolean resultFlag = false;
        try {
            if (null != orderAddress && null != orderAddress.getId()) {
                resultFlag = orderAddressManager.delete(orderAddress);
            } else {
                LOG.warn("OrderAddressServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.batchDelete")
    public boolean delete(OrderAddress[] orderAddresss) {
        boolean resultFlag = false;
        try {
            if (null != orderAddresss && orderAddresss.length > 0) {
                resultFlag = orderAddressManager.delete(orderAddresss);
            } else {
                LOG.warn("OrderAddressServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderAddressService.getOrderAddressById")
    public OrderAddress getOrderAddressById(Long id) {
        OrderAddress orderAddress = null;
        try {
            if (null != id) {
                orderAddress = orderAddressManager.getOrderAddressById(id);
            } else {
                LOG.warn("OrderAddressServiceImpl#getOrderAddressById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderAddressServiceImpl#getOrderAddressById has error.", e);
        }
        return orderAddress;
    }
}

