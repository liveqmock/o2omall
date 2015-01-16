package com.awe.mall.service;

import java.util.List;

import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.response.dto.RefundResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 退换货退款服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
public interface RefundService {
	/**
	 * 退款表查询服务
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> getRefund(RefundRequestDto requestDto);
	/**
	 * 查询退款列表
	 * @param requestDto
	 * @param pageUtil
	 * @return
	 */
	public List<RefundResponseDto> queryRefundListWithPage(RefundRequestDto requestDto, PageUtil pageUtil);
	
}
