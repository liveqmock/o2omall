package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.service.PasswordService;
import com.awe.uc.sdk.request.dto.UserAccountRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * @description 改密
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("password")
public class PasswordController {
private static final Log LOG = LogFactory.getLog(AdressController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_LOGIN_PASSWORD_PAGE = "modifyLoginPassword";
	private static final String VIEW_PAY_PASSWORD_PAGE = "modifyPayPassword";
	
	@Autowired
	private PasswordService passwordService;
	
	@RequestMapping("editlogin")
	public String editLogin(Model model){
		LOG.info("-- welcome to editLogin page --");
		return VIEW_WORKSPACE + VIEW_LOGIN_PASSWORD_PAGE;
	}
	
	@RequestMapping("editpay")
	public String editPay(Model model){
		LOG.info("-- welcome to editPay page --");
		return VIEW_WORKSPACE + VIEW_PAY_PASSWORD_PAGE;
	}
	
	public Wrapper<?> modifyLoginPwd(Model model,String username,String smCode,String newPassword,String renewPassword,String randomVerifyCode){
		Wrapper<?> wrapper = null;
		//少逻辑后补
		try {
			UserAccountRequestDto requestDto = new UserAccountRequestDto();
			requestDto.setPassword(newPassword);
			requestDto.setUsername(username);
			passwordService.modifyLoginPwd(requestDto);
		} catch (Exception e) {
			LOG.error("#PasswordController.modifyLoginPwd#" + e);
		}
		return wrapper;
	}
	
	
}
