package com.awe.pay.dao;

import java.util.List;

import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;
/**
 * TradeDao接口<br/>
 * 对'正向交易'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public interface TradeDao {
    
    /**
     * 新增对象
     * 
     * @param trade 
     * @return
     */
    public boolean insert(Trade trade);

    /**
     * 更新对象
     * 
     * @param trade
     * @return
     */
    public boolean update(Trade trade);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Trade> queryTradeList(TradeQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTradeCount(TradeQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Trade> queryTradeListWithPage(TradeQuery queryBean);

    /**
     * 删除记录
     * 
     * @param trade
     * @return
     */
    public boolean delete(Trade trade);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Trade getTradeById(Long id);

    /**
     * 判断是否存在
     * 
     * @param trade
     * @return
     */
    public boolean exist(Trade trade);

}
