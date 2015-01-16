package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ReturnExchangeService;
import com.awe.rems.sdk.ReturnExchangeClient;
import com.awe.rems.sdk.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.response.dto.ReturnExchangeResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 退换货服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
@Service
public class ReturnExchangeServiceImpl implements ReturnExchangeService {
	
	private static final Log LOG = LogFactory.getLog(ReturnExchangeServiceImpl.class);
	@Autowired
	private ReturnExchangeClient returnExchangeClient;
	
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getReturnExchange(ReturnExchangeRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			ReturnExchangeResponseDto responseDto = returnExchangeClient.getReturnExchange(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeServiceImpl.getReturnExchange# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> addReturnExchange(ReturnExchangeRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = returnExchangeClient.addReturnExchange(requestDto);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeServiceImpl.addReturnExchange# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public List<ReturnExchangeResponseDto> queryReturnExchangeListWithPage(ReturnExchangeRequestDto requestDto, PageUtil pageUtil) {
		List<ReturnExchangeResponseDto> responseDtoList = null;
		try {
			responseDtoList = returnExchangeClient.queryReturnExchangeListWithPage(requestDto,pageUtil);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeServiceImpl.queryReturnExchangeListWithPage# Error:" + e);
		}
		return responseDtoList;
	}

}
