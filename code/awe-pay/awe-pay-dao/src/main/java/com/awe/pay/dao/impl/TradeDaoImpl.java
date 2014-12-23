package com.awe.pay.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pay.dao.TradeDao;
import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TradeDAO实现类<br/>
 * 对'正向交易'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Repository
public class TradeDaoImpl extends BaseDao implements TradeDao {
    /** namespace */
    private final String namespace = TradeDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Trade> queryTradeList(TradeQuery queryBean) {
        return (List<Trade>) queryForList(namespace +".queryTradeList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Trade trade) {
        return insert(namespace +".insert", trade);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Trade trade) {
        return update(namespace +".update", trade);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTradeCount(TradeQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTradeCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Trade> queryTradeListWithPage(TradeQuery queryBean) {
        return (List<Trade>) queryForList(namespace +".queryTradeListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Trade configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Trade getTradeById(Long id) {
        return (Trade) queryForObject(namespace +".getTradeById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Trade trade) {
        int count = (Integer) queryForObject(namespace +".exist", trade);
        return count > 0;
    }
}
