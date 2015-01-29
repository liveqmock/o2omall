package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.TaskOrdersDao;
import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TaskOrdersDAO实现类<br/>
 * 对'作业表'表进行基本的操作
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
@Repository
public class TaskOrdersDaoImpl extends BaseDao implements TaskOrdersDao {
    /** namespace */
    private final String namespace = TaskOrdersDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TaskOrders> queryTaskOrdersList(TaskOrdersQuery queryBean) {
        return (List<TaskOrders>) queryForList(namespace +".queryTaskOrdersList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TaskOrders taskOrders) {
        return insert(namespace +".insert", taskOrders);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TaskOrders taskOrders) {
        return update(namespace +".update", taskOrders);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTaskOrdersCount(TaskOrdersQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTaskOrdersCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TaskOrders> queryTaskOrdersListWithPage(TaskOrdersQuery queryBean) {
        return (List<TaskOrders>) queryForList(namespace +".queryTaskOrdersListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TaskOrders configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TaskOrders getTaskOrdersById(Long id) {
        return (TaskOrders) queryForObject(namespace +".getTaskOrdersById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TaskOrders taskOrders) {
        int count = (Integer) queryForObject(namespace +".exist", taskOrders);
        return count > 0;
    }
}
