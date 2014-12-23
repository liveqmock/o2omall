package com.awe.pay.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pay.sdk.request.TradeRequest;
import com.awe.pay.sdk.response.TradeResponse;
import com.awe.pay.sdk.response.dto.TradeResponseDto;

/**
 * 正向交易服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(TradeClient.class);

    /**
     * 正向交易查询服务
     * 
     * @param request
     *            查询请求对象
     * @return TradeDto 对象
     */
    public TradeResponseDto getTrade(TradeRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getTrade request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/trade/getTrade";
        TradeResponse response = super.getRestTemplate().postForObject(url, request, TradeResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getTrade url: " + url);
            LOG.debug("getTrade response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
