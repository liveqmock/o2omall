package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.OrdersService;
import com.awe.order.sdk.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.hbird.common.utils.page.PageUtil;
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
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("productorderlist")
	public String productOrderList(Model model, PageUtil page, OrdersItemsRequestDto ordersItemRequestDto){
		LOG.info("-- welcome to productOrderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "productorderlist");//我的订单-左边菜单标志
		OrdersRequestDto requestDto = null;
		try {
			ordersService.queryFrontOrdersListWithPage(requestDto, page);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return VIEW_WORKSPACE + VIEW_PRODUCT_ORDER_LIST_PAGE;
	}
	
	@RequestMapping("serviceorderlist")
	public String serviceOrderList(Model model){
		LOG.info("-- welcome to serviceOrderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
        model.addAttribute("leftFlag", "serviceorderlist");//我的订单-左边菜单标志
		return VIEW_WORKSPACE + VIEW_SERVICE_ORDER_LIST_PAGE;
	}
}
