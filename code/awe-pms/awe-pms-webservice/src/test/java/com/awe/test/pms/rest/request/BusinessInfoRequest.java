package com.awe.test.pms.rest.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.test.pms.rest.request.dto.BusinessInfoRequestDto;

/**
 * BusinessInfoRequest：商家信息请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class BusinessInfoRequest extends HbirdSecureRequest<BusinessInfoRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public BusinessInfoRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public BusinessInfoRequest(String key, BusinessInfoRequestDto content) {
        super(key, content);
    }
}
