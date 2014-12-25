package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.BusinessInfoRequest;
import com.awe.pms.sdk.response.BusinessInfoResponse;
import com.awe.pms.sdk.response.dto.BusinessInfoResponseDto;

/**
 * 商家信息服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 14:47:42
 * 
 */
public class BusinessInfoClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(BusinessInfoClient.class);

    /**
     * 商家信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return BusinessInfoDto 对象
     */
    public BusinessInfoResponseDto getBusinessInfo(BusinessInfoRequest request) {
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
