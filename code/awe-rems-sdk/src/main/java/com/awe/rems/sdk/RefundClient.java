package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.RefundRequest;
import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.response.RefundResponse;
import com.awe.rems.sdk.response.dto.RefundResponseDto;

/**
 * 退款表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:54:00
 * 
 */
public class RefundClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(RefundClient.class);

    /**
     * 退款表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return RefundResponseDto 接口返回的数据对象
     */
    public RefundResponseDto getRefund(RefundRequestDto requestDto) {
        Assert.notNull(requestDto);

        RefundRequest request = new RefundRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getRefund request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/refund/getRefund";
        RefundResponse response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getRefund url: " + url);
            LOG.debug("getRefund response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
