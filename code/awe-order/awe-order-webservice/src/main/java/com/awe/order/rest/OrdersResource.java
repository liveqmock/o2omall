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

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.sdk.api.request.OrdersRequest;
import com.awe.order.sdk.api.request.dto.OrdersRequestDto;
import com.awe.order.sdk.api.response.dto.OrdersResponseDto;
import com.awe.order.service.OrdersService;
import com.hbird.common.utils.page.PageUtil;
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
     * @param request
     * @param page
     * @return
     */
    @POST
    @Path("/orders/queryFrontOrdersListWithPage")
    public Wrapper<?> queryFrontOrdersListWithPage(OrdersRequest request,PageUtil page){
    	if (null == request || !request.checkSign()) {
            this.logger.error("queryFrontOrdersListWithPage 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        OrdersRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("queryFrontOrdersListWithPage 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	FrontOrdersQuery queryBean = new FrontOrdersQuery();
        	queryBean.setUserId(requestDto.getUserId());
        	queryBean.setOrderStatus(requestDto.getOrderStatus());
        	queryBean.setCreateTime(requestDto.getCreateTime());
        	List<Orders> dataList  = ordersService.queryFrontOrdersListWithPage(queryBean, page);
        	List<OrdersResponseDto> responseDto = convertList(dataList);
        	return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			 this.logger.error("查询订单数据异常", e);
	         return WrapMapper.error();
		}
    }
    /**
     * 订单取消
     * @param request
     * @return
     */
    @POST
    @Path("/orders/cancelOrders")
    public Wrapper<?> cancelOrders(OrdersRequest request){
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
        	if(ret){
        		return WrapMapper.ok();
        	}else{
        		return WrapMapper.error();
        	}
		} catch (Exception e) {
			 this.logger.error("取消订单数据异常", e);
	         return WrapMapper.error();
		}
    }
    /**
     * 删除订单数据
     * @param request
     * @return
     */
    @POST
    @Path("/orders/deleteOrders")
    public Wrapper<?> deleteOrders(OrdersRequest request){
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
        	if(ret){
        		return WrapMapper.ok();
        	}else{
        		return WrapMapper.error();
        	}
		} catch (Exception e) {
			this.logger.error("删除订单数据异常", e);
	        return WrapMapper.error();
		}
    }
    
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
