package com.awe.pay.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pay.sdk.request.TradeRefundFailRequest;
import com.awe.pay.sdk.request.dto.TradeRefundFailRequestDto;
import com.awe.pay.sdk.response.TradeRefundFailResponse;
import com.awe.pay.sdk.response.dto.TradeRefundFailResponseDto;

/**
 * 正向交易及逆向退款失败表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class TradeRefundFailClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(TradeRefundFailClient.class);

    /**
     * 正向交易及逆向退款失败表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return TradeRefundFailResponseDto 接口返回的数据对象
     */
    public TradeRefundFailResponseDto getTradeRefundFail(TradeRefundFailRequestDto requestDto) {
        Assert.notNull(requestDto);

        TradeRefundFailRequest request = new TradeRefundFailRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getTradeRefundFail request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/tradeRefundFail/getTradeRefundFail";
        TradeRefundFailResponse response = super.getRestTemplate().postForObject(url, request, TradeRefundFailResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getTradeRefundFail url: " + url);
            LOG.debug("getTradeRefundFail response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
