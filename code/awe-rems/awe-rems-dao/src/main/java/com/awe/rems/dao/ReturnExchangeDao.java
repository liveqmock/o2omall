package com.awe.rems.dao;

import java.util.List;

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
/**
 * ReturnExchangeDao接口<br/>
 * 对'退换货'表进行基本的操作
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
public interface ReturnExchangeDao {
    
    /**
     * 新增对象
     * 
     * @param returnExchange 
     * @return
     */
    public boolean insert(ReturnExchange returnExchange);

    /**
     * 更新对象
     * 
     * @param returnExchange
     * @return
     */
    public boolean update(ReturnExchange returnExchange);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchange> queryReturnExchangeList(ReturnExchangeQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryReturnExchangeCount(ReturnExchangeQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchange> queryReturnExchangeListWithPage(ReturnExchangeQuery queryBean);

    /**
     * 删除记录
     * 
     * @param returnExchange
     * @return
     */
    public boolean delete(ReturnExchange returnExchange);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ReturnExchange getReturnExchangeById(Long id);

    /**
     * 判断是否存在
     * 
     * @param returnExchange
     * @return
     */
    public boolean exist(ReturnExchange returnExchange);

}
