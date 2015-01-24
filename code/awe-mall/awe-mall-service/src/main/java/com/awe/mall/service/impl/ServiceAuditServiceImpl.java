package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ServiceAuditService;
import com.awe.rems.sdk.ServiceAuditClient;
import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;
/**
 * 退换货审核
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-24
 */
@Service
public class ServiceAuditServiceImpl implements ServiceAuditService {
	
	private static final Log LOG = LogFactory.getLog(ServiceAuditServiceImpl.class);
	@Autowired
	private ServiceAuditClient serviceAuditClient;
	/**
	 * 退换货及退款审核列表
	 * @param requestDto
	 * @return
	 */
	public List<ServiceAuditResponseDto> queryServiceAuditList(ServiceAuditRequestDto requestDto) {
		List<ServiceAuditResponseDto> responseDtoList = null;
		try {
			responseDtoList = serviceAuditClient.queryServiceAuditList(requestDto);
		} catch (Exception e) {
			LOG.error("#ServiceAuditServiceImpl.queryServiceAuditList# Error:" + e);
		}
		return responseDtoList;
	}

}
