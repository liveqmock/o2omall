package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.BusinessAuditRequest;
import com.awe.pms.sdk.response.BusinessAuditResponse;
import com.awe.pms.sdk.response.dto.BusinessAuditResponseDto;

/**
 * 审核商家流水表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 14:47:42
 * 
 */
public class BusinessAuditClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(BusinessAuditClient.class);

    /**
     * 审核商家流水表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return BusinessAuditDto 对象
     */
    public BusinessAuditResponseDto getBusinessAudit(BusinessAuditRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getBusinessAudit request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/businessAudit/getBusinessAudit";
        BusinessAuditResponse response = super.getRestTemplate().postForObject(url, request, BusinessAuditResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getBusinessAudit url: " + url);
            LOG.debug("getBusinessAudit response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
