package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.ReturnExchangeRequest;
import com.awe.rems.sdk.response.ReturnExchangeResponse;
import com.awe.rems.sdk.response.dto.ReturnExchangeResponseDto;

/**
 * 退换货服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:18
 * 
 */
public class ReturnExchangeClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ReturnExchangeClient.class);

    /**
     * 退换货查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ReturnExchangeDto 对象
     */
    public ReturnExchangeResponseDto getReturnExchange(ReturnExchangeRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchange request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/returnExchange/getReturnExchange";
        ReturnExchangeResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchange url: " + url);
            LOG.debug("getReturnExchange response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
