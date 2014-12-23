package com.awe.pay.dao;

import java.util.List;

import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;
/**
 * TradeRefundFailDao接口<br/>
 * 对'正向交易及逆向退款失败表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public interface TradeRefundFailDao {
    
    /**
     * 新增对象
     * 
     * @param tradeRefundFail 
     * @return
     */
    public boolean insert(TradeRefundFail tradeRefundFail);

    /**
     * 更新对象
     * 
     * @param tradeRefundFail
     * @return
     */
    public boolean update(TradeRefundFail tradeRefundFail);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TradeRefundFail> queryTradeRefundFailList(TradeRefundFailQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTradeRefundFailCount(TradeRefundFailQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TradeRefundFail> queryTradeRefundFailListWithPage(TradeRefundFailQuery queryBean);

    /**
     * 删除记录
     * 
     * @param tradeRefundFail
     * @return
     */
    public boolean delete(TradeRefundFail tradeRefundFail);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TradeRefundFail getTradeRefundFailById(Long id);

    /**
     * 判断是否存在
     * 
     * @param tradeRefundFail
     * @return
     */
    public boolean exist(TradeRefundFail tradeRefundFail);

}
