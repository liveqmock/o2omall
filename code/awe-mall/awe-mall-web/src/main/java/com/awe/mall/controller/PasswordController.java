package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
