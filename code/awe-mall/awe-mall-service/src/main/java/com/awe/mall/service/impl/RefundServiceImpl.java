package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.RefundService;
import com.awe.rems.sdk.RefundClient;
import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.response.dto.RefundResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 退换货退款服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
@Service
public class RefundServiceImpl implements RefundService {

	private static final Log LOG = LogFactory.getLog(RefundServiceImpl.class);
	@Autowired
	private RefundClient refundClient;
	
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getRefund(RefundRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			RefundResponseDto responseDto = refundClient.getRefund(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#RefundServiceImpl.getRefund# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public List<RefundResponseDto> queryRefundListWithPage(RefundRequestDto requestDto, PageUtil pageUtil) {
		List<RefundResponseDto> responseDtoList = null;
		try {
			responseDtoList = refundClient.queryRefundListWithPage(requestDto,pageUtil);
		} catch (Exception e) {
			LOG.error("#RefundServiceImpl.queryRefundListWithPage# Error:" + e);
		}
		return responseDtoList;
	}

}
