package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @description 用户中心
 * @author zyq
 * @date 2014-12-28
 * @version 1.0.0
 */
@Controller
@RequestMapping("usercenter")
public class UserCenterController {

	private static final Log LOG = LogFactory.getLog(UserCenterController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping("index")
	public String index(Model model){
		LOG.info("-- welcome to myorder index --");
		return VIEW_WORKSPACE + VIEW_INDEX;
	}
}
