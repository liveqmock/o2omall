package com.awe.test.rems.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.rems.rest.request.dto.ServiceAuditRequestDto;

/**
 * ServiceAuditRequest：退换货审核流表请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:18
 * 
 */
public class ServiceAuditRequest extends HbirdSecureRequest<ServiceAuditRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ServiceAuditRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public ServiceAuditRequest(String key, ServiceAuditRequestDto content) {
        super(key, content);
    }
}
