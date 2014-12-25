package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.ReturnExchangeImageRequest;
import com.awe.rems.sdk.response.ReturnExchangeImageResponse;
import com.awe.rems.sdk.response.dto.ReturnExchangeImageResponseDto;

/**
 * 退换货图片表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ReturnExchangeImageClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ReturnExchangeImageClient.class);

    /**
     * 退换货图片表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ReturnExchangeImageDto 对象
     */
    public ReturnExchangeImageResponseDto getReturnExchangeImage(ReturnExchangeImageRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchangeImage request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/returnExchangeImage/getReturnExchangeImage";
        ReturnExchangeImageResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeImageResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchangeImage url: " + url);
            LOG.debug("getReturnExchangeImage response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
