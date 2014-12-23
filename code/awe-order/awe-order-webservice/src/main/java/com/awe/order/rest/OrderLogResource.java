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

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.order.domain.OrderLog;
import com.awe.order.sdk.api.request.OrderLogRequest;
import com.awe.order.sdk.api.request.dto.OrderLogRequestDto;
import com.awe.order.sdk.api.response.dto.OrderLogResponseDto;
import com.awe.order.service.OrderLogService;

/**
 * 订单日志REST服务：提供有关订单日志的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:37
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class OrderLogResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private OrderLogService orderLogService; 

    /**
     * 查询订单日志信息
     * 
     * @param request
     *            订单日志请求参数
     * @return 订单日志返回对象
     * 
     */
    @POST
    @Path("/orderLog/getOrderLog")
    public Wrapper<?> getOrderLog(OrderLogRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getOrderLog 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        OrderLogRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getOrderLog 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            OrderLog orderLog = orderLogService.getOrderLogById(requestDto.getId());
            OrderLogResponseDto responseDto = convert(orderLog);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询订单日志数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private OrderLogResponseDto convert(OrderLog orderLog) {
        if (null == orderLog) {
            return null;
        }

        OrderLogResponseDto orderLogResponseDto = new OrderLogResponseDto();
        BeanUtils.copyProperties(orderLog, orderLogResponseDto);
        return orderLogResponseDto;
    }

    // 数据转换
    private List<OrderLogResponseDto> convertList(List<OrderLog> orderLogs) {
        if (CollectionUtils.isEmpty(orderLogs)) {
            return null;
        }

        List<OrderLogResponseDto> list = new ArrayList<OrderLogResponseDto>(orderLogs.size());
        for (OrderLog orderLog : orderLogs) {
            list.add(convert(orderLog));
        }
        return list;
    } 

}
