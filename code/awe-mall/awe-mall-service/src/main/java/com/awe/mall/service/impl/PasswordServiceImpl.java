package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.PasswordService;
import com.awe.uc.sdk.UserAccountClient;
import com.awe.uc.sdk.request.dto.UserAccountRequestDto;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 修改登录密码、支付密码
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
@Service
public class PasswordServiceImpl implements PasswordService {

	private static final Log LOG = LogFactory.getLog(PasswordServiceImpl.class);
	
	@Autowired
    private UserAccountClient userAccountClient;
	
	public Wrapper<?> modifyLoginPwd(UserAccountRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAccountClient.modifyPwd(requestDto);
		} catch (Exception e) {
			LOG.error("#PasswordServiceImpl.modifyLoginPwd#" + e);
		}
		return wrapper;
	}

}
