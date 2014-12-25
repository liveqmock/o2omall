package com.awe.rems.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.rems.dao.ReturnExchangeDao;
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ReturnExchangeDAO实现类<br/>
 * 对'退换货'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
@Repository
public class ReturnExchangeDaoImpl extends BaseDao implements ReturnExchangeDao {
    /** namespace */
    private final String namespace = ReturnExchangeDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ReturnExchange> queryReturnExchangeList(ReturnExchangeQuery queryBean) {
        return (List<ReturnExchange>) queryForList(namespace +".queryReturnExchangeList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ReturnExchange returnExchange) {
        return insert(namespace +".insert", returnExchange);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ReturnExchange returnExchange) {
        return update(namespace +".update", returnExchange);
    }

    /**
     * {@inheritDoc}
     */
    public int queryReturnExchangeCount(ReturnExchangeQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryReturnExchangeCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchange> queryReturnExchangeListWithPage(ReturnExchangeQuery queryBean) {
        return (List<ReturnExchange>) queryForList(namespace +".queryReturnExchangeListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ReturnExchange configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ReturnExchange getReturnExchangeById(Long id) {
        return (ReturnExchange) queryForObject(namespace +".getReturnExchangeById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ReturnExchange returnExchange) {
        int count = (Integer) queryForObject(namespace +".exist", returnExchange);
        return count > 0;
    }
}
