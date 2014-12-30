package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 送货地址
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("address")
public class AdressController {

	private static final Log LOG = LogFactory.getLog(AdressController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PAGE = "deliveryAddress";
	
	@RequestMapping("list")
	public String list(Model model){
		LOG.info("-- welcome to list page --");
		return VIEW_WORKSPACE + VIEW_PAGE;
	}
	
	@RequestMapping("edit")
	public String edit(Model model){
		LOG.info("-- welcome to edit page --");
		return VIEW_WORKSPACE + VIEW_PAGE;
	}
}
