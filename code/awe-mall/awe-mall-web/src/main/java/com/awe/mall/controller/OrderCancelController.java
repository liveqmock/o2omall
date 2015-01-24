package com.awe.mall.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.OrderCancelService;
import com.awe.order.enums.OrderCancelStatusEnum;
import com.awe.order.sdk.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.web.context.UserContext;
/**
 * @description 我的取消订单列表
 * @author zyq
 * @date 2015-1-17
 * @version 1.0.0
 */
@Controller
@RequestMapping("order")
public class OrderCancelController extends BaseController{
private static final Log LOG = LogFactory.getLog(MyOrderController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_CANCEL_ORDER_LIST_PAGE = "cancelOrderList";
	
	@Autowired
	private OrderCancelService orderCancelService;
	
	@RequestMapping("cancelOrderList")
	public String cancelOrderList(Model model, PageUtil pageUtil, OrderCancelRequestDto requestDto){
		LOG.info("-- welcome to cancelOrderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "cancelOrderList");//我的订单-左边菜单标志
		List<OrderCancelResponseDto> dataList = null;
		try {
			requestDto.setUserId(UserContext.get().getUserId());
			dataList = orderCancelService.queryFrontOrderCancelListWithPage(requestDto, pageUtil);
			if(null == dataList){
				dataList = new ArrayList<OrderCancelResponseDto>();
			}
			model.addAttribute("OrderCancelStatusMap",OrderCancelStatusEnum.getMap());
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#OrderCancelController.cancelOrderList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_CANCEL_ORDER_LIST_PAGE;
	}
}
