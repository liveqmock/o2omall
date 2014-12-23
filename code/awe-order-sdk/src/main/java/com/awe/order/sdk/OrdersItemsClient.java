package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.OrdersItemsRequest;
import com.awe.order.sdk.response.OrdersItemsResponse;
import com.awe.order.sdk.response.dto.OrdersItemsResponseDto;

/**
 * 订单明细服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class OrdersItemsClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(OrdersItemsClient.class);

    /**
     * 订单明细查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrdersItemsDto 对象
     */
    public OrdersItemsResponseDto getOrdersItems(OrdersItemsRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrdersItems request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/ordersItems/getOrdersItems";
        OrdersItemsResponse response = super.getRestTemplate().postForObject(url, request, OrdersItemsResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrdersItems url: " + url);
            LOG.debug("getOrdersItems response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
