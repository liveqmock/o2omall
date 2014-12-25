package com.awe.rems.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;

/**
 * ServiceAuditRequest：退换货审核流表请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
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
