package com.awe.order.manager;

import java.util.List;
import java.util.Map;

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.FrontOrderCancelQuery;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.dto.OrderCancelDto;
import com.hbird.common.utils.page.PageUtil;
/**
 * OrderCancelManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public interface OrderCancelManager {

    /**
     * 批量增加对象信息
     * 
     * @param orderCancelList
     * @return
     */
    public boolean insert(List<OrderCancel> orderCancelList);

    /**
     * 单个增加对象信息
     * 
     * @param orderCancel
     * @return
     */
    public boolean insert(OrderCancel orderCancel);

    /**
     * 更新 对象信息
     * 
     * @param orderCancel
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(OrderCancel orderCancel);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryOrderCancelCount(OrderCancelQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param orderCancel
     *            　
     * @return
     */
    public boolean delete(OrderCancel orderCancel);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public OrderCancel getOrderCancelById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param orderCancels
     *            OrderCancel集合
     * @return
     */
    public boolean delete(OrderCancel[] orderCancels);

    /**
     * 判断是否存在
     * 
     * @param orderCancel
     * @return
     */
    public boolean exist(OrderCancel orderCancel);

    /**
     * 订单审核
     * @param orderCancel
     * @return
     */
	public boolean Cancelupdate(Map map);
	/**
	 * 商城-取消订单列表，带翻页
	 * @param queryBean
	 * @param pageUtil
	 * @return
	 */
	public List<OrderCancelDto> queryFrontOrderCancelListWithPage(FrontOrderCancelQuery queryBean,PageUtil pageUtil);
	/**
	 * 商城-根据查询Bean获取总数
	 * @param queryBean
	 * @return
	 */
	public int queryFrontOrderCancelCount(FrontOrderCancelQuery queryBean);
}
