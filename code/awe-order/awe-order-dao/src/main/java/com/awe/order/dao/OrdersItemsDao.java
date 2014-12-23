package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;
/**
 * OrdersItemsDao接口<br/>
 * 对'订单明细'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
public interface OrdersItemsDao {
    
    /**
     * 新增对象
     * 
     * @param ordersItems 
     * @return
     */
    public boolean insert(OrdersItems ordersItems);

    /**
     * 更新对象
     * 
     * @param ordersItems
     * @return
     */
    public boolean update(OrdersItems ordersItems);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrdersItems> queryOrdersItemsList(OrdersItemsQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryOrdersItemsCount(OrdersItemsQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrdersItems> queryOrdersItemsListWithPage(OrdersItemsQuery queryBean);

    /**
     * 删除记录
     * 
     * @param ordersItems
     * @return
     */
    public boolean delete(OrdersItems ordersItems);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public OrdersItems getOrdersItemsById(Long id);

    /**
     * 判断是否存在
     * 
     * @param ordersItems
     * @return
     */
    public boolean exist(OrdersItems ordersItems);

}
