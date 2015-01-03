package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.OrdersDao;
import com.awe.order.domain.Orders;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.dto.OrdersDto;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * OrdersDAO实现类<br/>
 * 对'订单'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
@Repository
@SuppressWarnings("all")
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

    /**
     * {@inheritDoc}
     */
	public Orders getOrdersByOrderNO(String orderNo) {
		 return (Orders) queryForObject(namespace +".getOrdersByOrderNO", orderNo);
	}

	/**
     * {@inheritDoc}
     */
	public boolean orderAudit(Map map) {
		return update(namespace +".orderAudit", map);
	}
	/**
     * {@inheritDoc}
     */
	public List<OrdersDto> queryFrontOrdersListWithPage(FrontOrdersQuery queryBean) {
		return (List<OrdersDto>) queryForList(namespace +".queryFrontOrdersListWithPage", queryBean);
	}
	/**
     * {@inheritDoc}
     */
	public int queryFrontOrdersCount(FrontOrdersQuery queryBean) {
		return (Integer) queryForObject(namespace +".queryFrontOrdersCount", queryBean);
	}
	
	
}
