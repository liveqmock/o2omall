package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
/**
 * OrderAddressDao接口<br/>
 * 对'收货地址表'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
public interface OrderAddressDao {
    
    /**
     * 新增对象
     * 
     * @param orderAddress 
     * @return
     */
    public boolean insert(OrderAddress orderAddress);

    /**
     * 更新对象
     * 
     * @param orderAddress
     * @return
     */
    public boolean update(OrderAddress orderAddress);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderAddress> queryOrderAddressList(OrderAddressQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryOrderAddressCount(OrderAddressQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderAddress> queryOrderAddressListWithPage(OrderAddressQuery queryBean);

    /**
     * 删除记录
     * 
     * @param orderAddress
     * @return
     */
    public boolean delete(OrderAddress orderAddress);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public OrderAddress getOrderAddressById(Long id);

    /**
     * 判断是否存在
     * 
     * @param orderAddress
     * @return
     */
    public boolean exist(OrderAddress orderAddress);

}
