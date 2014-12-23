package com.awe.pay.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;
import com.awe.pay.dao.TradeDao;
import com.awe.pay.manager.TradeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TradeManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Component
public class TradeManagerImpl extends BaseManager implements TradeManager {
	
    @Autowired
    private TradeDao tradeDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Trade> tradeList) {
        boolean resultFlag = false;
        if (null != tradeList && tradeList.size() > 0) {
            for (Trade trade : tradeList) {
                resultFlag = tradeDao.insert(trade);
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
    public boolean insert(Trade trade) {
        return tradeDao.insert(trade);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Trade trade) {
        return tradeDao.update(trade);
    }

    /**
     * {@inheritDoc}
     */
    public List<Trade> queryTradeList(TradeQuery queryBean) {
        return tradeDao.queryTradeList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Trade> queryTradeListWithPage(TradeQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TradeQuery();
        }

        // 查询总数
        int totalItem = queryTradeCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return tradeDao.queryTradeListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTradeCount(TradeQuery queryBean) {
        return tradeDao.queryTradeCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Trade trade) {
        return tradeDao.delete(trade);
    }

    /**
     * {@inheritDoc}
     */
    public Trade getTradeById(Long id) {
        return tradeDao.getTradeById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Trade[] trades) {
        boolean resultFlag = false;
        if (null != trades && trades.length > 0) {
            for (int i = 0; i < trades.length; i++) {
                resultFlag = delete(trades[i]);
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
    public boolean exist(Trade trade) {
        return tradeDao.exist(trade);
    }
}
