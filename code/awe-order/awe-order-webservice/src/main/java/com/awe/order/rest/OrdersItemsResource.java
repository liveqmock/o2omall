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
import com.awe.order.domain.OrdersItems;
import com.awe.order.sdk.api.request.OrdersItemsRequest;
import com.awe.order.sdk.api.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.api.response.dto.OrdersItemsResponseDto;
import com.awe.order.service.OrdersItemsService;

/**
 * 订单明细REST服务：提供有关订单明细的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class OrdersItemsResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private OrdersItemsService ordersItemsService; 

    /**
     * 查询订单明细信息
     * 
     * @param request
     *            订单明细请求参数
     * @return 订单明细返回对象
     * 
     */
    @POST
    @Path("/ordersItems/getOrdersItems")
    public Wrapper<?> getOrdersItems(OrdersItemsRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getOrdersItems 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        OrdersItemsRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getOrdersItems 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            OrdersItems ordersItems = ordersItemsService.getOrdersItemsById(requestDto.getId());
            OrdersItemsResponseDto responseDto = convert(ordersItems);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询订单明细数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private OrdersItemsResponseDto convert(OrdersItems ordersItems) {
        if (null == ordersItems) {
            return null;
        }

        OrdersItemsResponseDto ordersItemsResponseDto = new OrdersItemsResponseDto();
        BeanUtils.copyProperties(ordersItems, ordersItemsResponseDto);
        return ordersItemsResponseDto;
    }

    // 数据转换
    private List<OrdersItemsResponseDto> convertList(List<OrdersItems> ordersItemss) {
        if (CollectionUtils.isEmpty(ordersItemss)) {
            return null;
        }

        List<OrdersItemsResponseDto> list = new ArrayList<OrdersItemsResponseDto>(ordersItemss.size());
        for (OrdersItems ordersItems : ordersItemss) {
            list.add(convert(ordersItems));
        }
        return list;
    } 

}
