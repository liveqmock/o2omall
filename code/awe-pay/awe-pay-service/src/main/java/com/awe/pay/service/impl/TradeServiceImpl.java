package com.awe.pay.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;
import com.awe.pay.manager.TradeManager;
import com.awe.pay.service.TradeService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TradeService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Service
public class TradeServiceImpl implements TradeService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TradeServiceImpl.class);

    @Autowired
    private TradeManager tradeManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.batchInsert")
    public boolean insert(List<Trade> tradeList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tradeList)) {
                resultFlag = tradeManager.insert(tradeList);
            } else {
                LOG.warn("TradeServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.insert")
    public boolean insert(Trade trade) {
        boolean resultFlag = false;
        try {
            if (null != trade) {
                if (tradeManager.exist(trade)) {
                    throw new ExistedException();
                }
                resultFlag = tradeManager.insert(trade);
            } else {
                LOG.warn("TradeServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TradeServiceImpl#insert failed, trade has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.update")
    public boolean update(Trade trade) {
        boolean resultFlag = false;
        try {
            if (null != trade && null != trade.getId()) {
                resultFlag = tradeManager.update(trade);
            } else {
                LOG.warn("TradeServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.queryTradeList")
    public List<Trade> queryTradeList(TradeQuery queryBean) {
        List<Trade> tradeList = null;
        try {
            tradeList = tradeManager.queryTradeList(queryBean);
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#queryTradeList has error.", e);
        }
        return tradeList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.queryTradeListWithPage")
    public List<Trade> queryTradeListWithPage(TradeQuery queryBean, PageUtil pageUtil) {
        List<Trade> tradeList = null;
        try {
            tradeList = tradeManager.queryTradeListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#queryTradeListWithPage has error.", e);
        }
        return tradeList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.delete")
    public boolean delete(Trade trade) {
        boolean resultFlag = false;
        try {
            if (null != trade && null != trade.getId()) {
                resultFlag = tradeManager.delete(trade);
            } else {
                LOG.warn("TradeServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.batchDelete")
    public boolean delete(Trade[] trades) {
        boolean resultFlag = false;
        try {
            if (null != trades && trades.length > 0) {
                resultFlag = tradeManager.delete(trades);
            } else {
                LOG.warn("TradeServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeService.getTradeById")
    public Trade getTradeById(Long id) {
        Trade trade = null;
        try {
            if (null != id) {
                trade = tradeManager.getTradeById(id);
            } else {
                LOG.warn("TradeServiceImpl#getTradeById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeServiceImpl#getTradeById has error.", e);
        }
        return trade;
    }
}

