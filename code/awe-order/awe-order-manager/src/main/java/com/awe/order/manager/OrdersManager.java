package com.awe.order.manager;

import java.util.List;

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * OrdersManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public interface OrdersManager {

    /**
     * 批量增加对象信息
     * 
     * @param ordersList
     * @return
     */
    public boolean insert(List<Orders> ordersList);

    /**
     * 单个增加对象信息
     * 
     * @param orders
     * @return
     */
    public boolean insert(Orders orders);

    /**
     * 更新 对象信息
     * 
     * @param orders
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Orders orders);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Orders> queryOrdersList(OrdersQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryOrdersCount(OrdersQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param orders
     *            　
     * @return
     */
    public boolean delete(Orders orders);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Orders getOrdersById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param orderss
     *            Orders集合
     * @return
     */
    public boolean delete(Orders[] orderss);

    /**
     * 判断是否存在
     * 
     * @param orders
     * @return
     */
    public boolean exist(Orders orders);
}
