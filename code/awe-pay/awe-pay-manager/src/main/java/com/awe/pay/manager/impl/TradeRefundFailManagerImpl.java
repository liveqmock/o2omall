package com.awe.pay.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;
import com.awe.pay.dao.TradeRefundFailDao;
import com.awe.pay.manager.TradeRefundFailManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TradeRefundFailManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Component
public class TradeRefundFailManagerImpl extends BaseManager implements TradeRefundFailManager {
	
    @Autowired
    private TradeRefundFailDao tradeRefundFailDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TradeRefundFail> tradeRefundFailList) {
        boolean resultFlag = false;
        if (null != tradeRefundFailList && tradeRefundFailList.size() > 0) {
            for (TradeRefundFail tradeRefundFail : tradeRefundFailList) {
                resultFlag = tradeRefundFailDao.insert(tradeRefundFail);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TradeRefundFail tradeRefundFail) {
        return tradeRefundFailDao.insert(tradeRefundFail);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TradeRefundFail tradeRefundFail) {
        return tradeRefundFailDao.update(tradeRefundFail);
    }

    /**
     * {@inheritDoc}
     */
    public List<TradeRefundFail> queryTradeRefundFailList(TradeRefundFailQuery queryBean) {
        return tradeRefundFailDao.queryTradeRefundFailList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TradeRefundFail> queryTradeRefundFailListWithPage(TradeRefundFailQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TradeRefundFailQuery();
        }

        // 查询总数
        int totalItem = queryTradeRefundFailCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tradeRefundFailDao.queryTradeRefundFailListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTradeRefundFailCount(TradeRefundFailQuery queryBean) {
        return tradeRefundFailDao.queryTradeRefundFailCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TradeRefundFail tradeRefundFail) {
        return tradeRefundFailDao.delete(tradeRefundFail);
    }

    /**
     * {@inheritDoc}
     */
    public TradeRefundFail getTradeRefundFailById(Long id) {
        return tradeRefundFailDao.getTradeRefundFailById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TradeRefundFail[] tradeRefundFails) {
        boolean resultFlag = false;
        if (null != tradeRefundFails && tradeRefundFails.length > 0) {
            for (int i = 0; i < tradeRefundFails.length; i++) {
                resultFlag = delete(tradeRefundFails[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(TradeRefundFail tradeRefundFail) {
        return tradeRefundFailDao.exist(tradeRefundFail);
    }
}
