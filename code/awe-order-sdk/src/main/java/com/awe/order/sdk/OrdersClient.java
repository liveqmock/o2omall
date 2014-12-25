package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.OrdersRequest;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.OrdersResponse;
import com.awe.order.sdk.response.dto.OrdersResponseDto;

/**
 * 订单服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrdersClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(OrdersClient.class);

    /**
     * 订单查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrdersResponseDto 接口返回的数据对象
     */
    public OrdersResponseDto getOrders(OrdersRequestDto requestDto) {
        Assert.notNull(requestDto);

        OrdersRequest request = new OrdersRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrders request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orders/getOrders";
        OrdersResponse response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrders url: " + url);
            LOG.debug("getOrders response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
