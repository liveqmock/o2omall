package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
/**
 * @description 购物车
 * @author zyq
 * @date 2014-12-28
 * @version 1.0.0
 */
@Controller
@RequestMapping("cart")
public class CartController extends BaseController {

	private static final Log LOG = LogFactory.getLog(CartController.class);
	
	private static final String VIEW_WORKSPACE = "cart/";
	private static final String VIEW_CART = "myCart";
	private static final String VIEW_ADD_SUCCESS = "addCartSuccess";
	
	@RequestMapping("mycart")
	public String cart(Model model){
		LOG.info("-- welcome to myCart page --");
		return VIEW_WORKSPACE + VIEW_CART;
	}
	@RequestMapping("addcartsuccess")
	public String addCart(Model model){
		LOG.info("-- welcome to addCartSuccess page --");
		return VIEW_WORKSPACE + VIEW_ADD_SUCCESS;
	}
}
