package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * OrderAddressService接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
public interface OrderAddressService {

    /**
     * 批量增加对象信息
     * 
     * @param orderAddressList
     * @return
     */
    public boolean insert(List<OrderAddress> orderAddressList);

    /**
     * 单个增加对象信息
     * 
     * @param orderAddress
     * @return
     */
    public boolean insert(OrderAddress orderAddress);

    /**
     * 更新 对象信息
     * 
     * @param orderAddress
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(OrderAddress orderAddress);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderAddress> queryOrderAddressList(OrderAddressQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<OrderAddress> queryOrderAddressListWithPage(OrderAddressQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param orderAddress
     *            　
     * @return
     */
    public boolean delete(OrderAddress orderAddress);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public OrderAddress getOrderAddressById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param orderAddresss
     *            OrderAddress集合
     * @return
     */
    public boolean delete(OrderAddress[] orderAddresss);
}
