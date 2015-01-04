package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.OrdersService;
import com.awe.order.sdk.OrdersClient;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 我的订单列表服务
 * @author zyq
 * @version 1.0.0.0
 * @since 2015-1-4
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	
	private static final Log LOG = LogFactory.getLog(OrdersServiceImpl.class);
	@Autowired
	private OrdersClient ordersClient;
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getOrders(OrdersRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			OrdersResponseDto responseDto = ordersClient.getOrders(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#OrdersServiceImpl.getOrders# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> queryFrontOrdersListWithPage(OrdersRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = ordersClient.queryFrontOrdersListWithPage(requestDto);
		} catch (Exception e) {
			LOG.error("#OrdersServiceImpl.queryFrontOrdersListWithPage# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> cancelOrders(OrdersRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = ordersClient.cancelOrders(requestDto);
		} catch (Exception e) {
			LOG.error("#OrdersServiceImpl.cancelOrders# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> deleteOrders(OrdersRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = ordersClient.deleteOrders(requestDto);
		} catch (Exception e) {
			LOG.error("#OrdersServiceImpl.deleteOrders# Error:" + e);
		}
		return wrapper;
	}

}
