package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @description 个人基本信息
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("profile")
public class ProfileController {

private static final Log LOG = LogFactory.getLog(CartController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PAGE = " personalProfile";
	private static final String VIEW_ADD_SUCCESS = "addCartSuccess";
	
	@RequestMapping("myprofile")
	public String profile(Model model){
		LOG.info("-- welcome to myProfile page --");
		return VIEW_WORKSPACE + VIEW_PAGE;
	}
}
