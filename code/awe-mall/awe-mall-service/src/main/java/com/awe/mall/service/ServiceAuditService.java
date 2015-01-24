package com.awe.mall.service;

import java.util.List;

import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;

/**
 * 退换货审核
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-24
 */
public interface ServiceAuditService {
	/**
	 * 退换货及退款审核列表
	 * @param requestDto
	 * @return
	 */
	public List<ServiceAuditResponseDto> queryServiceAuditList(ServiceAuditRequestDto requestDto);
}
