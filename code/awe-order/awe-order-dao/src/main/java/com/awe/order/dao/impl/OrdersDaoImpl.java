package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.OrdersDao;
import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * OrdersDAO实现类<br/>
 * 对'订单'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
@Repository
public class OrdersDaoImpl extends BaseDao implements OrdersDao {
    /** namespace */
    private final String namespace = OrdersDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Orders> queryOrdersList(OrdersQuery queryBean) {
        return (List<Orders>) queryForList(namespace +".queryOrdersList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Orders orders) {
        return insert(namespace +".insert", orders);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Orders orders) {
        return update(namespace +".update", orders);
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrdersCount(OrdersQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryOrdersCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean) {
        return (List<Orders>) queryForList(namespace +".queryOrdersListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Orders configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Orders getOrdersById(Long id) {
        return (Orders) queryForObject(namespace +".getOrdersById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Orders orders) {
        int count = (Integer) queryForObject(namespace +".exist", orders);
        return count > 0;
    }
}
