package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.OrderLogRequest;
import com.awe.order.sdk.request.dto.OrderLogRequestDto;
import com.awe.order.sdk.response.OrderLogResponse;
import com.awe.order.sdk.response.dto.OrderLogResponseDto;

/**
 * 订单日志服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrderLogClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(OrderLogClient.class);

    /**
     * 订单日志查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrderLogResponseDto 接口返回的数据对象
     */
    public OrderLogResponseDto getOrderLog(OrderLogRequestDto requestDto) {
        Assert.notNull(requestDto);

        OrderLogRequest request = new OrderLogRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderLog request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orderLog/getOrderLog";
        OrderLogResponse response = super.getRestTemplate().postForObject(url, request, OrderLogResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderLog url: " + url);
            LOG.debug("getOrderLog response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
