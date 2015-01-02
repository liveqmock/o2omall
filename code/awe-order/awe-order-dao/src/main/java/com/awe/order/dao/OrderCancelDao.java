package com.awe.order.dao;

import java.util.List;
import java.util.Map;

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;
/**
 * OrderCancelDao接口<br/>
 * 对'订单取消'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
public interface OrderCancelDao {
    
    /**
     * 新增对象
     * 
     * @param orderCancel 
     * @return
     */
    public boolean insert(OrderCancel orderCancel);

    /**
     * 更新对象
     * 
     * @param orderCancel
     * @return
     */
    public boolean update(OrderCancel orderCancel);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryOrderCancelCount(OrderCancelQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean);

    /**
     * 删除记录
     * 
     * @param orderCancel
     * @return
     */
    public boolean delete(OrderCancel orderCancel);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public OrderCancel getOrderCancelById(Long id);

    /**
     * 判断是否存在
     * 
     * @param orderCancel
     * @return
     */
    public boolean exist(OrderCancel orderCancel);

    /**
     * 订单审核
     * @param map
     * @return
     */
	public boolean Cancelupdate(Map map);

}
