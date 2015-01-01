package com.awe.mall.service;

import com.awe.uc.sdk.request.dto.UserAccountRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 修改登录密码、支付密码
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
public interface PasswordService {
	/**
	 * 修改登录密码
	 * @param account
	 * @return
	 */
	public Wrapper<?> modifyLoginPwd(UserAccountRequestDto requestDto);
	
}
