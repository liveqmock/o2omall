package com.awe.rems.sdk.response;

import java.util.List;

import com.hbird.common.sdk.api.response.HbirdResponse;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;

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
