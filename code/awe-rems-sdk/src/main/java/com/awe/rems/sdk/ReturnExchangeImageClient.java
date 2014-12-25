package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.ReturnExchangeImageRequest;
import com.awe.rems.sdk.request.dto.ReturnExchangeImageRequestDto;
import com.awe.rems.sdk.response.ReturnExchangeImageResponse;
import com.awe.rems.sdk.response.dto.ReturnExchangeImageResponseDto;

/**
 * 退换货图片表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:54:00
 * 
 */
public class ReturnExchangeImageClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ReturnExchangeImageClient.class);

    /**
     * 退换货图片表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ReturnExchangeImageResponseDto 接口返回的数据对象
     */
    public ReturnExchangeImageResponseDto getReturnExchangeImage(ReturnExchangeImageRequestDto requestDto) {
        Assert.notNull(requestDto);

        ReturnExchangeImageRequest request = new ReturnExchangeImageRequest(super.getKey(), requestDto);
        
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
