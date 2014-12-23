package com.awe.pay.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pay.dao.TradeRefundFailDao;
import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * TradeRefundFailDAO实现类<br/>
 * 对'正向交易及逆向退款失败表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Repository
public class TradeRefundFailDaoImpl extends BaseDao implements TradeRefundFailDao {
    /** namespace */
    private final String namespace = TradeRefundFailDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<TradeRefundFail> queryTradeRefundFailList(TradeRefundFailQuery queryBean) {
        return (List<TradeRefundFail>) queryForList(namespace +".queryTradeRefundFailList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TradeRefundFail tradeRefundFail) {
        return insert(namespace +".insert", tradeRefundFail);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(TradeRefundFail tradeRefundFail) {
        return update(namespace +".update", tradeRefundFail);
    }

    /**
     * {@inheritDoc}
     */
    public int queryTradeRefundFailCount(TradeRefundFailQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryTradeRefundFailCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TradeRefundFail> queryTradeRefundFailListWithPage(TradeRefundFailQuery queryBean) {
        return (List<TradeRefundFail>) queryForList(namespace +".queryTradeRefundFailListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TradeRefundFail configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public TradeRefundFail getTradeRefundFailById(Long id) {
        return (TradeRefundFail) queryForObject(namespace +".getTradeRefundFailById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(TradeRefundFail tradeRefundFail) {
        int count = (Integer) queryForObject(namespace +".exist", tradeRefundFail);
        return count > 0;
    }
}
