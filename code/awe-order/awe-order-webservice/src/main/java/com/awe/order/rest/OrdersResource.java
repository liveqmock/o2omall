package com.awe.order.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.order.domain.OrderDetails;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.Orders;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.sdk.api.request.OrderDetailsRequest;
import com.awe.order.sdk.api.request.OrdersRequest;
import com.awe.order.sdk.api.request.dto.OrderDetailsRequestDto;
import com.awe.order.sdk.api.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.api.request.dto.OrdersRequestDto;
import com.awe.order.sdk.api.response.dto.OrdersResponseDto;
import com.awe.order.service.OrdersService;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.PageWrapMapper;
import com.hbird.common.utils.wrap.PageWrapper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 订单REST服务：提供有关订单的接口
 * 
 * @author ljz,zyq
 * @version 2014-12-23 10:58:09
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class OrdersResource {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private OrdersService ordersService;

	/**
	 * 查询订单信息
	 * 
	 * @param request
	 *            订单请求参数
	 * @return 订单返回对象
	 * 
	 */
	@POST
	@Path("/orders/getOrders")
	public Wrapper<?> getOrders(OrdersRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("getOrders 拒绝访问");
			return WrapMapper.forbidden();
		}

		OrdersRequestDto requestDto = request.getContent();
		if (null == requestDto || null == requestDto.getId()) {
			this.logger.error("getOrders 传入参数有误");
			return WrapMapper.illegalArgument();
		}

		try {
			Orders orders = ordersService.getOrdersById(requestDto.getId());
			OrdersResponseDto responseDto = convert(orders);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			this.logger.error("查询订单数据异常", e);
			return WrapMapper.error();
		}
	}

	/**
	 * 获取已下单订单列表
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@POST
	@Path("/orders/queryFrontOrdersListWithPage")
	public PageWrapper<?> queryFrontOrdersListWithPage(OrdersRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("queryFrontOrdersListWithPage 拒绝访问");
			return PageWrapMapper.error();
		}
		OrdersRequestDto requestDto = request.getContent();
		PageUtil page = request.getPageUtil();
		if (null == requestDto || null == requestDto.getOrderNo()) {
			this.logger.error("queryFrontOrdersListWithPage 传入参数有误");
			return PageWrapMapper.illegalArgument();
		}
		try {
			FrontOrdersQuery queryBean = new FrontOrdersQuery();
			BeanUtils.copyProperties(requestDto, queryBean);
			List<Orders> dataList = ordersService.queryFrontOrdersListWithPage(queryBean, page);
			List<OrdersResponseDto> responseDtoList = convertList(dataList);
			return PageWrapMapper.ok().result(responseDtoList).pageUtil(page);
		} catch (Exception e) {
			this.logger.error("查询订单数据异常", e);
			return PageWrapMapper.error();
		}
	}

	/**
	 * 订单取消
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/orders/cancelOrders")
	public Wrapper<?> cancelOrders(OrdersRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("cancelOrders 拒绝访问");
			return WrapMapper.forbidden();
		}

		OrdersRequestDto requestDto = request.getContent();
		if (null == requestDto || null == requestDto.getId()) {
			this.logger.error("cancelOrders 传入参数有误");
			return WrapMapper.illegalArgument();
		}
		try {
			Orders orders = new Orders();
			boolean ret = ordersService.update(orders);
			if (ret) {
				return WrapMapper.ok();
			} else {
				return WrapMapper.error();
			}
		} catch (Exception e) {
			this.logger.error("取消订单数据异常", e);
			return WrapMapper.error();
		}
	}

	/**
	 * 删除订单数据
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/orders/deleteOrders")
	public Wrapper<?> deleteOrders(OrdersRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("deleteOrders 拒绝访问");
			return WrapMapper.forbidden();
		}

		OrdersRequestDto requestDto = request.getContent();
		if (null == requestDto || null == requestDto.getId()) {
			this.logger.error("deleteOrders 传入参数有误");
			return WrapMapper.illegalArgument();
		}
		try {
			Orders orders = new Orders();
			boolean ret = ordersService.delete(orders);
			if (ret) {
				return WrapMapper.ok();
			} else {
				return WrapMapper.error();
			}
		} catch (Exception e) {
			this.logger.error("删除订单数据异常", e);
			return WrapMapper.error();
		}
	}

	/**
	 * 生成订单 Date:2015年1月7日上午10:17:44 user:js
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/ordersDetails/insert")
	public Wrapper<?> insert(OrderDetailsRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("deleteOrders 拒绝访问");
			return WrapMapper.forbidden();
		}
		OrderDetailsRequestDto requestDto = request.getContent();
		if (null == requestDto || null == requestDto.getOrdersRequestDto()
				|| null == requestDto.getOrdersRequestDto().getOrderNo()
				|| CollectionUtils.isEmpty(requestDto.getListOrdersItemsRequestDto())) {
			this.logger.error("insert 传入参数有误");
			return WrapMapper.illegalArgument();
		}
		try {
			Orders orders = convertOrders(requestDto.getOrdersRequestDto());
			List<OrdersItems> ordersItemsList = convertOrdersItemsList(requestDto.getListOrdersItemsRequestDto());
			OrderLog orderLog = convertLog(orders);
			OrderDetails orderDetails = new OrderDetails(orders, ordersItemsList, orderLog);
			boolean ret = ordersService.insertDetails(orderDetails);
			if (ret) {
				return WrapMapper.ok();
			} else {
				return WrapMapper.error();
			}
		} catch (Exception e) {
			this.logger.error("新增订单数据异常", e);
			return WrapMapper.error();
		}

	}

	private OrderLog convertLog(Orders orders) {
		OrderLog orderLog = new OrderLog();
		orderLog.setOrderNo(orders.getOrderNo());// 订单号
		orderLog.setStatus(orders.getOrderStatus());// 状态
		orderLog.setCreateUser(orders.getCreateUser());// 创建姓名
		return orderLog;
	}
	// ----------  dto to domain 
	// 数据转换
	private Orders convertOrders(OrdersRequestDto ordersResponseDto) {
		if (null == ordersResponseDto) {
			return null;
		}

		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersResponseDto, orders);
		return orders;
	}

	// 数据转换item
	private List<OrdersItems> convertOrdersItemsList(List<OrdersItemsRequestDto> ordersItemsRequestDtos) {
		if (CollectionUtils.isEmpty(ordersItemsRequestDtos)) {
			return null;
		}
		List<OrdersItems> list = new ArrayList<OrdersItems>(ordersItemsRequestDtos.size());
		for (OrdersItemsRequestDto ordersItemsRequestDto : ordersItemsRequestDtos) {
			list.add(convertItems(ordersItemsRequestDto));
		}
		return list;
	}

	private OrdersItems convertItems(OrdersItemsRequestDto ordersItemsRequestDto) {
		if (null == ordersItemsRequestDto) {
			return null;
		}
		OrdersItems ordersItem = new OrdersItems();
		BeanUtils.copyProperties(ordersItemsRequestDto, ordersItem);
		return ordersItem;
	}

	// ----------domain to dto
	// 数据转换
	private OrdersResponseDto convert(Orders orders) {
		if (null == orders) {
			return null;
		}

		OrdersResponseDto ordersResponseDto = new OrdersResponseDto();
		BeanUtils.copyProperties(orders, ordersResponseDto);
		return ordersResponseDto;
	}

	// 数据转换
	private List<OrdersResponseDto> convertList(List<Orders> orderss) {
		if (CollectionUtils.isEmpty(orderss)) {
			return null;
		}

		List<OrdersResponseDto> list = new ArrayList<OrdersResponseDto>(orderss.size());
		for (Orders orders : orderss) {
			list.add(convert(orders));
		}
		return list;
	}

}
