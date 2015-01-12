package com.awe.mall.service;

import java.util.List;

import com.awe.mall.domain.dto.OrderInfo;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.hbird.common.utils.wrap.Wrapper;



/**
 * 订单信息
 *OrderInfoService	
 *
 * @author js
 * @version：2015年1月9日 下午5:33:29
 */
public interface OrderInfoService {


	/**
	 * 根据skuno查询商品信息
	 * Date:2015年1月10日下午1:37:01
	 * user:js
	 * @param dataList
	 * @return
	 */
	List<OrderInfo> getOrderInfoBySkuNo(List<ShoppingCartRequestDto> dataList);

	/**
	 * 生成订单，同时写订单表，日志表，item表
	 * Date:2015年1月11日下午5:24:04
	 * user:js
	 * @param requestDto
	 * @param skuName
	 * @param skuCount
	 * @return
	 */
	Wrapper<?> addOrderDetails(OrdersRequestDto requestDto, String skuName, String skuNo,String skuCount);
	
	
}
