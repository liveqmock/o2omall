package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;
/**
 * OrdersDao接口<br/>
 * 对'订单'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
public interface OrdersDao {
    
    /**
     * 新增对象
     * 
     * @param orders 
     * @return
     */
    public boolean insert(Orders orders);

    /**
     * 更新对象
     * 
     * @param orders
     * @return
     */
    public boolean update(Orders orders);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Orders> queryOrdersList(OrdersQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryOrdersCount(OrdersQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean);

    /**
     * 删除记录
     * 
     * @param orders
     * @return
     */
    public boolean delete(Orders orders);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Orders getOrdersById(Long id);

    /**
     * 判断是否存在
     * 
     * @param orders
     * @return
     */
    public boolean exist(Orders orders);

}
