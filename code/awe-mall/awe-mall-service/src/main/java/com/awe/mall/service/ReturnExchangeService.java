package com.awe.mall.service;

import java.util.List;

import com.awe.rems.sdk.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.response.dto.ReturnExchangeResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 退换货服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
public interface ReturnExchangeService {
	/**
	 * 退换货查询服务
	 * @param requestDto
	 * @return
	 */
	public ReturnExchangeResponseDto getReturnExchange(ReturnExchangeRequestDto requestDto);
	/**
	 * 申请退换货
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> addReturnExchange(ReturnExchangeRequestDto requestDto);
	/**
	 * 我的退换货列表
	 * @param requestDto
	 * @param pageUtil
	 * @return
	 */
	public List<ReturnExchangeResponseDto> queryReturnExchangeListWithPage(ReturnExchangeRequestDto requestDto, PageUtil pageUtil);
}
