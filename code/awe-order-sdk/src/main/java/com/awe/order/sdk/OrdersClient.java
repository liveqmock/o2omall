package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.OrdersRequest;
import com.awe.order.sdk.response.OrdersResponse;
import com.awe.order.sdk.response.dto.OrdersResponseDto;

/**
 * 订单服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class OrdersClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(OrdersClient.class);

    /**
     * 订单查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrdersDto 对象
     */
    public OrdersResponseDto getOrders(OrdersRequest request) {
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
