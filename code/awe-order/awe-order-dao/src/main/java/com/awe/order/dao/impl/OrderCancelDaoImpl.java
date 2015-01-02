package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.OrderCancelDao;
import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * OrderCancelDAO实现类<br/>
 * 对'订单取消'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
@Repository
public class OrderCancelDaoImpl extends BaseDao implements OrderCancelDao {
    /** namespace */
    private final String namespace = OrderCancelDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean) {
        return (List<OrderCancel>) queryForList(namespace +".queryOrderCancelList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(OrderCancel orderCancel) {
        return insert(namespace +".insert", orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(OrderCancel orderCancel) {
        return update(namespace +".update", orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderCancelCount(OrderCancelQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryOrderCancelCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean) {
        return (List<OrderCancel>) queryForList(namespace +".queryOrderCancelListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderCancel configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public OrderCancel getOrderCancelById(Long id) {
        return (OrderCancel) queryForObject(namespace +".getOrderCancelById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(OrderCancel orderCancel) {
        int count = (Integer) queryForObject(namespace +".exist", orderCancel);
        return count > 0;
    }

    /**
     * {@inheritDoc}
     */
	public boolean Cancelupdate(Map map) {
		return update(namespace +".Cancelupdate", map);
	}
}
