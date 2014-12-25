package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.ECouponRequest;
import com.awe.order.sdk.request.dto.ECouponRequestDto;
import com.awe.order.sdk.response.ECouponResponse;
import com.awe.order.sdk.response.dto.ECouponResponseDto;

/**
 * 电子券服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class ECouponClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ECouponClient.class);

    /**
     * 电子券查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ECouponResponseDto 接口返回的数据对象
     */
    public ECouponResponseDto getECoupon(ECouponRequestDto requestDto) {
        Assert.notNull(requestDto);

        ECouponRequest request = new ECouponRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getECoupon request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/eCoupon/getECoupon";
        ECouponResponse response = super.getRestTemplate().postForObject(url, request, ECouponResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getECoupon url: " + url);
            LOG.debug("getECoupon response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
