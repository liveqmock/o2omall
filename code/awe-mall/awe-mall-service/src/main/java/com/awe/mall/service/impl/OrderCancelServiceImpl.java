package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.OrderCancelService;
import com.awe.order.sdk.OrderCancelClient;
import com.awe.order.sdk.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 我的订单取消
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
@Service
public class OrderCancelServiceImpl implements OrderCancelService {

	private static final Log LOG = LogFactory.getLog(OrderCancelServiceImpl.class);
	@Autowired
	private OrderCancelClient orderCancelClient;
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getOrderCancel(OrderCancelRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			OrderCancelResponseDto responseDto = orderCancelClient.getOrderCancel(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#OrderCancelServiceImpl.getOrderCancel# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public List<OrderCancelResponseDto> queryFrontOrderCancelListWithPage(OrderCancelRequestDto requestDto,PageUtil pageUtil) {
		List<OrderCancelResponseDto> responseDtoList = null;
		try {
			responseDtoList = orderCancelClient.queryFrontOrderCancelListWithPage(requestDto,pageUtil);
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.queryFrontOrderCancelListWithPage# Error:" + e);
		}
		return responseDtoList;
	}

}
