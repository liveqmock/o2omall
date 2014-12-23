package com.awe.pay.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;
import com.awe.pay.manager.TradeRefundFailManager;
import com.awe.pay.service.TradeRefundFailService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TradeRefundFailService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Service
public class TradeRefundFailServiceImpl implements TradeRefundFailService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TradeRefundFailServiceImpl.class);

    @Autowired
    private TradeRefundFailManager tradeRefundFailManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.batchInsert")
    public boolean insert(List<TradeRefundFail> tradeRefundFailList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(tradeRefundFailList)) {
                resultFlag = tradeRefundFailManager.insert(tradeRefundFailList);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.insert")
    public boolean insert(TradeRefundFail tradeRefundFail) {
        boolean resultFlag = false;
        try {
            if (null != tradeRefundFail) {
                if (tradeRefundFailManager.exist(tradeRefundFail)) {
                    throw new ExistedException();
                }
                resultFlag = tradeRefundFailManager.insert(tradeRefundFail);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TradeRefundFailServiceImpl#insert failed, tradeRefundFail has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.update")
    public boolean update(TradeRefundFail tradeRefundFail) {
        boolean resultFlag = false;
        try {
            if (null != tradeRefundFail && null != tradeRefundFail.getId()) {
                resultFlag = tradeRefundFailManager.update(tradeRefundFail);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.queryTradeRefundFailList")
    public List<TradeRefundFail> queryTradeRefundFailList(TradeRefundFailQuery queryBean) {
        List<TradeRefundFail> tradeRefundFailList = null;
        try {
            tradeRefundFailList = tradeRefundFailManager.queryTradeRefundFailList(queryBean);
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#queryTradeRefundFailList has error.", e);
        }
        return tradeRefundFailList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.queryTradeRefundFailListWithPage")
    public List<TradeRefundFail> queryTradeRefundFailListWithPage(TradeRefundFailQuery queryBean, PageUtil pageUtil) {
        List<TradeRefundFail> tradeRefundFailList = null;
        try {
            tradeRefundFailList = tradeRefundFailManager.queryTradeRefundFailListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#queryTradeRefundFailListWithPage has error.", e);
        }
        return tradeRefundFailList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.delete")
    public boolean delete(TradeRefundFail tradeRefundFail) {
        boolean resultFlag = false;
        try {
            if (null != tradeRefundFail && null != tradeRefundFail.getId()) {
                resultFlag = tradeRefundFailManager.delete(tradeRefundFail);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.batchDelete")
    public boolean delete(TradeRefundFail[] tradeRefundFails) {
        boolean resultFlag = false;
        try {
            if (null != tradeRefundFails && tradeRefundFails.length > 0) {
                resultFlag = tradeRefundFailManager.delete(tradeRefundFails);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TradeRefundFailService.getTradeRefundFailById")
    public TradeRefundFail getTradeRefundFailById(Long id) {
        TradeRefundFail tradeRefundFail = null;
        try {
            if (null != id) {
                tradeRefundFail = tradeRefundFailManager.getTradeRefundFailById(id);
            } else {
                LOG.warn("TradeRefundFailServiceImpl#getTradeRefundFailById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TradeRefundFailServiceImpl#getTradeRefundFailById has error.", e);
        }
        return tradeRefundFail;
    }
}

