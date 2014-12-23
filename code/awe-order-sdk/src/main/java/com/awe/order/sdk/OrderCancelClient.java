package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.OrderCancelRequest;
import com.awe.order.sdk.response.OrderCancelResponse;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;

/**
 * 订单取消服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:38
 * 
 */
public class OrderCancelClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(OrderCancelClient.class);

    /**
     * 订单取消查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrderCancelDto 对象
     */
    public OrderCancelResponseDto getOrderCancel(OrderCancelRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderCancel request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orderCancel/getOrderCancel";
        OrderCancelResponse response = super.getRestTemplate().postForObject(url, request, OrderCancelResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderCancel url: " + url);
            LOG.debug("getOrderCancel response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
