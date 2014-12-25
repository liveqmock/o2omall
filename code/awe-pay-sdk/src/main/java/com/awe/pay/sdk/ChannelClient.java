package com.awe.pay.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pay.sdk.request.ChannelRequest;
import com.awe.pay.sdk.request.dto.ChannelRequestDto;
import com.awe.pay.sdk.response.ChannelResponse;
import com.awe.pay.sdk.response.dto.ChannelResponseDto;

/**
 * 支付通道服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class ChannelClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ChannelClient.class);

    /**
     * 支付通道查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ChannelResponseDto 接口返回的数据对象
     */
    public ChannelResponseDto getChannel(ChannelRequestDto requestDto) {
        Assert.notNull(requestDto);

        ChannelRequest request = new ChannelRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getChannel request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/channel/getChannel";
        ChannelResponse response = super.getRestTemplate().postForObject(url, request, ChannelResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getChannel url: " + url);
            LOG.debug("getChannel response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
