package com.awe.uc.rest;

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
import com.awe.uc.domain.OrderAddress;
import com.awe.uc.sdk.api.request.OrderAddressRequest;
import com.awe.uc.sdk.api.response.OrderAddressResponse;
import com.awe.uc.service.OrderAddressService;

/**
 * 收货地址表REST服务：提供有关收货地址表的接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:54
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class OrderAddressResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private OrderAddressService orderAddressService; 

    /**
     * 查询收货地址表信息
     * 
     * @param request
     *            收货地址表请求参数
     * @return 收货地址表返回对象
     * 
     */
    @POST
    @Path("/orderAddress/getOrderAddress")
    public Wrapper<?> getOrderAddress(OrderAddressRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getOrderAddress 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            OrderAddress orderAddress = orderAddressService.getOrderAddressById(request.getId());
            OrderAddressResponse response = convert(orderAddress);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询收货地址表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private OrderAddressResponse convert(OrderAddress orderAddress) {
        if (null == orderAddress) {
            return null;
        }

        OrderAddressResponse orderAddressResponse = new OrderAddressResponse();
        BeanUtils.copyProperties(orderAddress, orderAddressResponse);
        return orderAddressResponse;
    }

    // 数据转换
    private List<OrderAddressResponse> convertList(List<OrderAddress> orderAddresss) {
        if (CollectionUtils.isEmpty(orderAddresss)) {
            return null;
        }

        List<OrderAddressResponse> list = new ArrayList<OrderAddressResponse>(orderAddresss.size());
        for (OrderAddress orderAddress : orderAddresss) {
            list.add(convert(orderAddress));
        }
        return list;
    } 

}
