package com.awe.mall.service;

import java.util.List;

import com.awe.order.sdk.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 我的订单取消
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
public interface OrderCancelService {
	/**
	 * 订单取消查询服务
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> getOrderCancel(OrderCancelRequestDto requestDto);
	/**
	 * 获取取消了的订单列表
	 * @param requestDto
	 * @param pageUtil
	 * @return
	 */
	public List<OrderCancelResponseDto> queryFrontOrderCancelListWithPage(OrderCancelRequestDto requestDto,PageUtil pageUtil);
}
