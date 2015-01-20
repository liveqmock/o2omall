package com.awe.mall.service;

import com.awe.pay.sdk.request.dto.TradeRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 正向交易服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-20
 */
public interface PayTradeService {
	/**
	 * 查询正向交易信息
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> getTrade(TradeRequestDto requestDto);
	/**
	 * 正向交易接口
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> addTrade(TradeRequestDto requestDto);
}
