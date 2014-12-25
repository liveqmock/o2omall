package com.awe.pay.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pay.sdk.request.TradeRequest;
import com.awe.pay.sdk.request.dto.TradeRequestDto;
import com.awe.pay.sdk.response.TradeResponse;
import com.awe.pay.sdk.response.dto.TradeResponseDto;

/**
 * 正向交易服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class TradeClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(TradeClient.class);

    /**
     * 正向交易查询服务
     * 
     * @param request
     *            查询请求对象
     * @return TradeResponseDto 接口返回的数据对象
     */
    public TradeResponseDto getTrade(TradeRequestDto requestDto) {
        Assert.notNull(requestDto);

        TradeRequest request = new TradeRequest(super.getKey(), requestDto);
        
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
