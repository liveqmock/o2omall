package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
/**
 * @description 我的订单
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("myorder")
public class MyOrderController extends BaseController {

	private static final Log LOG = LogFactory.getLog(MyOrderController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PRODUCT_ORDER_LIST_PAGE = "productOrderList";
	private static final String VIEW_SERVICE_ORDER_LIST_PAGE = "serviceOrderList";
	
	@RequestMapping("productorderlist")
	public String productOrderList(Model model){
		LOG.info("-- welcome to productOrderList index --");
		return VIEW_WORKSPACE + VIEW_PRODUCT_ORDER_LIST_PAGE;
	}
	
	@RequestMapping("serviceorderlist")
	public String serviceOrderList(Model model){
		LOG.info("-- welcome to serviceOrderList index --");
		return VIEW_WORKSPACE + VIEW_SERVICE_ORDER_LIST_PAGE;
	}
}
