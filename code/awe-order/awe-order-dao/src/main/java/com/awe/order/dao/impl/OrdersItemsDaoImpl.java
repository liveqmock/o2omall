package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.OrdersItemsDao;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * OrdersItemsDAO实现类<br/>
 * 对'订单明细'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
@Repository
public class OrdersItemsDaoImpl extends BaseDao implements OrdersItemsDao {
    /** namespace */
    private final String namespace = OrdersItemsDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<OrdersItems> queryOrdersItemsList(OrdersItemsQuery queryBean) {
        return (List<OrdersItems>) queryForList(namespace +".queryOrdersItemsList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(OrdersItems ordersItems) {
        return insert(namespace +".insert", ordersItems);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(OrdersItems ordersItems) {
        return update(namespace +".update", ordersItems);
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrdersItemsCount(OrdersItemsQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryOrdersItemsCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrdersItems> queryOrdersItemsListWithPage(OrdersItemsQuery queryBean) {
        return (List<OrdersItems>) queryForList(namespace +".queryOrdersItemsListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrdersItems configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public OrdersItems getOrdersItemsById(Long id) {
        return (OrdersItems) queryForObject(namespace +".getOrdersItemsById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(OrdersItems ordersItems) {
        int count = (Integer) queryForObject(namespace +".exist", ordersItems);
        return count > 0;
    }
}
