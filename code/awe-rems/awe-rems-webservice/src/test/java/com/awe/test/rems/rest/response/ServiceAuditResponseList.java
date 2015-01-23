package com.awe.test.rems.rest.response;

import java.util.List;

import com.awe.test.rems.rest.response.dto.ServiceAuditResponseDto;
import com.hbird.common.sdk.api.response.HbirdResponse;

/**
 * ServiceAuditResponse：退换货审核流表返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ServiceAuditResponseList extends HbirdResponse<List<ServiceAuditResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
