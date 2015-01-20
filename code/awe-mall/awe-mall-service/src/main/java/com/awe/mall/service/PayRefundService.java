package com.awe.mall.service;

import com.awe.pay.sdk.request.dto.RefundRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 逆向退款服务
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-20
 */
public interface PayRefundService {
	/**
	 * 查询逆向退款信息
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> getRefund(RefundRequestDto requestDto);
	/**
	 * 逆向退款
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> addRefund(RefundRequestDto requestDto);
}
