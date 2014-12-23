package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.OrderLogDao;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * OrderLogDAO实现类<br/>
 * 对'订单日志'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
@Repository
public class OrderLogDaoImpl extends BaseDao implements OrderLogDao {
    /** namespace */
    private final String namespace = OrderLogDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<OrderLog> queryOrderLogList(OrderLogQuery queryBean) {
        return (List<OrderLog>) queryForList(namespace +".queryOrderLogList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(OrderLog orderLog) {
        return insert(namespace +".insert", orderLog);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(OrderLog orderLog) {
        return update(namespace +".update", orderLog);
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderLogCount(OrderLogQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryOrderLogCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderLog> queryOrderLogListWithPage(OrderLogQuery queryBean) {
        return (List<OrderLog>) queryForList(namespace +".queryOrderLogListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderLog configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public OrderLog getOrderLogById(Long id) {
        return (OrderLog) queryForObject(namespace +".getOrderLogById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(OrderLog orderLog) {
        int count = (Integer) queryForObject(namespace +".exist", orderLog);
        return count > 0;
    }
}
