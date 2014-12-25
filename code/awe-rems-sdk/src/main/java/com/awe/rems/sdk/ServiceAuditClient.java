package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.ServiceAuditRequest;
import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.response.ServiceAuditResponse;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;

/**
 * 退换货审核流表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:54:00
 * 
 */
public class ServiceAuditClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ServiceAuditClient.class);

    /**
     * 退换货审核流表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ServiceAuditResponseDto 接口返回的数据对象
     */
    public ServiceAuditResponseDto getServiceAudit(ServiceAuditRequestDto requestDto) {
        Assert.notNull(requestDto);

        ServiceAuditRequest request = new ServiceAuditRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getServiceAudit request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/serviceAudit/getServiceAudit";
        ServiceAuditResponse response = super.getRestTemplate().postForObject(url, request, ServiceAuditResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getServiceAudit url: " + url);
            LOG.debug("getServiceAudit response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
