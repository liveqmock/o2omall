package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.OrderAddressDao;
import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * OrderAddressDAO实现类<br/>
 * 对'收货地址表'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
@Repository
public class OrderAddressDaoImpl extends BaseDao implements OrderAddressDao {
    /** namespace */
    private final String namespace = OrderAddressDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<OrderAddress> queryOrderAddressList(OrderAddressQuery queryBean) {
        return (List<OrderAddress>) queryForList(namespace +".queryOrderAddressList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(OrderAddress orderAddress) {
        return insert(namespace +".insert", orderAddress);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(OrderAddress orderAddress) {
        return update(namespace +".update", orderAddress);
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderAddressCount(OrderAddressQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryOrderAddressCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderAddress> queryOrderAddressListWithPage(OrderAddressQuery queryBean) {
        return (List<OrderAddress>) queryForList(namespace +".queryOrderAddressListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderAddress configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public OrderAddress getOrderAddressById(Long id) {
        return (OrderAddress) queryForObject(namespace +".getOrderAddressById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(OrderAddress orderAddress) {
        int count = (Integer) queryForObject(namespace +".exist", orderAddress);
        return count > 0;
    }
}
