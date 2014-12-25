package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.BusinessInfoRequest;
import com.awe.pms.sdk.request.dto.BusinessInfoRequestDto;
import com.awe.pms.sdk.response.BusinessInfoResponse;
import com.awe.pms.sdk.response.dto.BusinessInfoResponseDto;

/**
 * 商家信息服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class BusinessInfoClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(BusinessInfoClient.class);

    /**
     * 商家信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return BusinessInfoResponseDto 接口返回的数据对象
     */
    public BusinessInfoResponseDto getBusinessInfo(BusinessInfoRequestDto requestDto) {
        Assert.notNull(requestDto);

        BusinessInfoRequest request = new BusinessInfoRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getBusinessInfo request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/businessInfo/getBusinessInfo";
        BusinessInfoResponse response = super.getRestTemplate().postForObject(url, request, BusinessInfoResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getBusinessInfo url: " + url);
            LOG.debug("getBusinessInfo response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
