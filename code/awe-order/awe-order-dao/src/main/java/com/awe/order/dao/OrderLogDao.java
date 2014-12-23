package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
/**
 * OrderLogDao接口<br/>
 * 对'订单日志'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
public interface OrderLogDao {
    
    /**
     * 新增对象
     * 
     * @param orderLog 
     * @return
     */
    public boolean insert(OrderLog orderLog);

    /**
     * 更新对象
     * 
     * @param orderLog
     * @return
     */
    public boolean update(OrderLog orderLog);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderLog> queryOrderLogList(OrderLogQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryOrderLogCount(OrderLogQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderLog> queryOrderLogListWithPage(OrderLogQuery queryBean);

    /**
     * 删除记录
     * 
     * @param orderLog
     * @return
     */
    public boolean delete(OrderLog orderLog);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public OrderLog getOrderLogById(Long id);

    /**
     * 判断是否存在
     * 
     * @param orderLog
     * @return
     */
    public boolean exist(OrderLog orderLog);

}
