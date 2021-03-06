package com.awe.order.service;

import java.util.List;
import java.util.Map;

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.sdk.api.request.dto.OrdersRequestDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrdersService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public interface OrdersService {

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
     * 根据orderNO 获取订单对象信息
     * Date:2014年12月26日下午2:52:15
     * user:js
     * @param orderNo
     * @return
     */
	public Orders getOrdersByOrderNO(String orderNo);
	/**
	 * 前端商城-我的订单-根据查询Bean获取集合，带翻页
	 * @param queryBean
	 * @param pageUtil
	 * @return
	 */
	public List<Orders> queryFrontOrdersListWithPage(FrontOrdersQuery queryBean,PageUtil pageUtil);

	/**
	 * 前台商城,提交订单
	 * Date:2015年1月7日上午10:52:16
	 * user:js
	 * @param orderDetails
	 * @return
	 */
	public Wrapper<?> insertDetails(Orders orders,Map<String,String> mapSC,String ip);

	/**
	 * 订单取消
	 * Date:2015年1月16日下午3:40:08
	 * user:js
	 * @param orders
	 * @return
	 */
	public boolean cancelOrders(Orders orders);

	/**
	 * 批量修改订单状态
	 * Date:2015年1月27日下午3:18:39
	 * user:js
	 * @param requestDto
	 * @return
	 */
	public boolean updateOrder(OrdersRequestDto requestDto);

}
