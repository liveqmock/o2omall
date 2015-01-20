package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.awe.mall.service.PayTradeService;
import com.awe.pay.sdk.TradeClient;
import com.awe.pay.sdk.request.dto.TradeRequestDto;
import com.awe.pay.sdk.response.dto.TradeResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

public class PayTradServiceImpl implements PayTradeService {
	
	private static final Log LOG = LogFactory.getLog(PayTradServiceImpl.class);
	
	@Autowired
	private TradeClient tradeClient;
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> getTrade(TradeRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			TradeResponseDto responseDto = tradeClient.getTrade(requestDto);
			return WrapMapper.ok().result(responseDto);
		} catch (Exception e) {
			LOG.error("#PayTradServiceImpl.getTrade# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> addTrade(TradeRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = tradeClient.addTrade(requestDto);
		} catch (Exception e) {
			LOG.error("#PayTradServiceImpl.getTrade# Error:" + e);
		}
		return wrapper;
	}

}
