package com.awe.rems.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.rems.sdk.request.ServiceAuditRequest;
import com.awe.rems.sdk.response.ServiceAuditResponse;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;

/**
 * 退换货审核流表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ServiceAuditClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ServiceAuditClient.class);

    /**
     * 退换货审核流表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ServiceAuditDto 对象
     */
    public ServiceAuditResponseDto getServiceAudit(ServiceAuditRequest request) {
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
