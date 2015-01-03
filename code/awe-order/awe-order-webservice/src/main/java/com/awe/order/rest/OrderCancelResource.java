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

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.FrontOrderCancelQuery;
import com.awe.order.sdk.api.request.OrderCancelRequest;
import com.awe.order.sdk.api.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.api.response.dto.OrderCancelResponseDto;
import com.awe.order.service.OrderCancelService;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 订单取消REST服务：提供有关订单取消的接口
 * 
 * @author ljz,zyq
 * @version 2015-1-2
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class OrderCancelResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private OrderCancelService orderCancelService; 

    /**
     * 查询订单取消信息
     * 
     * @param request
     *            订单取消请求参数
     * @return 订单取消返回对象
     * 
     */
    @POST
    @Path("/orderCancel/getOrderCancel")
    public Wrapper<?> getOrderCancel(OrderCancelRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getOrderCancel 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        OrderCancelRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getOrderCancel 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            OrderCancel orderCancel = orderCancelService.getOrderCancelById(requestDto.getId());
            OrderCancelResponseDto responseDto = convert(orderCancel);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询订单取消数据异常", e);
            return WrapMapper.error();
        }
    } 

    /**
     * 获取取消了的订单列表
     * @param page
     * @param request
     * @return
     */
    @POST
    @Path("/orderCancel/queryFrontOrderCancelListWithPage")
    public Wrapper<?> queryFrontOrderCancelListWithPage(OrderCancelRequest request,PageUtil pageUtil){
    	if (null == request || !request.checkSign()) {
            this.logger.error("queryFrontOrderCancelListWithPage 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        OrderCancelRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("queryFrontOrderCancelListWithPage 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	FrontOrderCancelQuery queryBean = new FrontOrderCancelQuery();
        	queryBean.setUserId(requestDto.getUserId());
        	List<OrderCancel> dataList = orderCancelService.queryFrontOrderCancelListWithPage(queryBean, pageUtil);
        	List<OrderCancelResponseDto> responseDtoList = convertList(dataList);
        	return WrapMapper.ok().result(responseDtoList);
		} catch (Exception e) {
			this.logger.error("#OrderCancelResource.queryFrontOrderCancelListWithPage# Error:" + e);
			return WrapMapper.error();
		}
    }
    
    
    // 数据转换
    private OrderCancelResponseDto convert(OrderCancel orderCancel) {
        if (null == orderCancel) {
            return null;
        }

        OrderCancelResponseDto orderCancelResponseDto = new OrderCancelResponseDto();
        BeanUtils.copyProperties(orderCancel, orderCancelResponseDto);
        return orderCancelResponseDto;
    }

    // 数据转换
    private List<OrderCancelResponseDto> convertList(List<OrderCancel> orderCancels) {
        if (CollectionUtils.isEmpty(orderCancels)) {
            return null;
        }

        List<OrderCancelResponseDto> list = new ArrayList<OrderCancelResponseDto>(orderCancels.size());
        for (OrderCancel orderCancel : orderCancels) {
            list.add(convert(orderCancel));
        }
        return list;
    } 

}
