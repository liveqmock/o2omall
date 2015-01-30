package com.awe.order.manager;

import java.util.List;
import java.util.Map;

import com.awe.order.domain.OrderDetails;
import com.awe.order.domain.Orders;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.dto.OrdersDto;
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

    /**
     * 根据orderNo查询order对象信息
     * Date:2014年12月26日下午2:53:57
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
	public List<OrdersDto> queryFrontOrdersListWithPage(FrontOrdersQuery queryBean,PageUtil pageUtil);
	/**
	 * 前端商城-我的订单-根据查询Bean获取总数
	 * @param queryBean
	 * @return
	 */
	public int queryFrontOrdersCount(FrontOrdersQuery queryBean);

	/**
	 * 前台商城-生成订单
	 * Date:2015年1月7日上午10:56:01
	 * user:js
	 * @param orders
	 */
	public boolean insertDetails(List<OrderDetails> orderDetails);

	/**
	 * 查询出下单未支付超过24小时的订单号
	 * Date:2015年1月13日下午4:36:33
	 * user:js
	 * @param yesTerDay
	 * @return
	 */
	public List<Orders> queryOrderListCancel(String yesTerDay);

	/**
	 * 下单未支付超过24小时的订单转无效
	 * Date:2015年1月13日下午5:13:43
	 * user:js
	 * @param orders
	 * @return
	 */
	public boolean updateorderCancel(Orders orders);

	/**
	 * 订单取消
	 * Date:2015年1月16日下午3:43:05
	 * user:js
	 * @param orders
	 * @return
	 */
	public boolean cancelOrders(Orders orders);

	/**
	 * 批量修改订单状态
	 * Date:2015年1月27日下午3:31:05
	 * user:js
	 * @param map
	 * @return
	 */
	public boolean updateOrder(Map<String, Object> map);

	/**
	 * 修改订单状态
	 * Date:2015年1月30日上午11:22:23
	 * user:js
	 * @param queryOrders
	 * @return
	 */
	public boolean updateOrderLog(Orders queryOrders);

}
