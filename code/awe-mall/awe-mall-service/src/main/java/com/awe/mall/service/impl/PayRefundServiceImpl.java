package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.awe.mall.service.PayRefundService;
import com.awe.pay.sdk.RefundClient;
import com.awe.pay.sdk.request.dto.RefundRequestDto;
import com.awe.pay.sdk.response.dto.RefundResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

public class PayRefundServiceImpl implements PayRefundService {
	
	private static final Log LOG = LogFactory.getLog(PayRefundServiceImpl.class);
	
	@Autowired
	private RefundClient payRefundClient;
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getRefund(RefundRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			RefundResponseDto responseDto = payRefundClient.getRefund(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#PayRefundServiceImpl.getRefund# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> addRefund(RefundRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = payRefundClient.addRefund(requestDto);
		} catch (Exception e) {
			LOG.error("#PayRefundServiceImpl.getRefund# Error:" + e);
		}
		return wrapper;
	}

}
