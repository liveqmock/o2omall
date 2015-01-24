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
import com.awe.mall.service.OrdersService;
import com.awe.mall.service.RefundService;
import com.awe.mall.service.ReturnExchangeService;
import com.awe.mall.service.ServiceAuditService;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.awe.rems.enums.AuditStatusEnum;
import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.response.dto.RefundResponseDto;
import com.awe.rems.sdk.response.dto.ReturnExchangeResponseDto;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.web.context.UserContext;

/**
 * 退换货控制器
 * @author zyq
 * @version 1.0.0.0
 * @since 2015-1-18
 */
@Controller
@RequestMapping("returnExchange")
public class ReturnExchangeController extends BaseController{

	private static final Log LOG = LogFactory.getLog(ReturnExchangeController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_RETURN_EXCHANGE_APPLY_LIST_PAGE = "returnExchangeApplyList";
	private static final String VIEW_RETURN_EXCHANGE_LIST_PAGE = "returnExchangeList";
	private static final String VIEW_RETURN_EXCHANGE_DETAIL_PAGE = "returnExchangeDetail";
	private static final String VIEW_REFUND_LIST_PAGE = "refundList";
	
	@Autowired
	private ReturnExchangeService returnExchangeService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private RefundService refundService;
	@Autowired
	private ServiceAuditService serviceAuditService;
	
	@RequestMapping("returnExchangeList")
	public String returnExchangeList(Model model, PageUtil pageUtil, ReturnExchangeRequestDto requestDto){
		LOG.info("-- welcome to returnExchangeList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "returnExchange");//我的订单-左边菜单标志
		List<ReturnExchangeResponseDto> dataList = null;
		try {
			requestDto.setUserId(UserContext.get().getUserId());
			dataList = returnExchangeService.queryReturnExchangeListWithPage(requestDto, pageUtil);
			if(null == dataList){
				dataList = new ArrayList<ReturnExchangeResponseDto>();
			}
			model.addAttribute("AuditStatusMap", AuditStatusEnum.getMap());
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeController.returnExchangeList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_RETURN_EXCHANGE_LIST_PAGE;
	}
	
	
	@RequestMapping("orderList")
	public String orderList(Model model, PageUtil page, OrdersRequestDto requestDto){
		LOG.info("-- welcome to orderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "returnExchange");//我的订单-左边菜单标志
		List<OrdersResponseDto> dataList = null;
		try {
			requestDto.setOrderType(100);
			requestDto.setUserId(UserContext.get().getUserId());
			dataList = ordersService.queryFrontOrdersListWithPage(requestDto, page);
			if(null == dataList){
				dataList = new ArrayList<OrdersResponseDto>();
			}
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeController.orderList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_RETURN_EXCHANGE_APPLY_LIST_PAGE;
	}
	
	@RequestMapping("refundList")
	public String refundList(Model model, PageUtil pageUtil, RefundRequestDto requestDto){
		LOG.info("-- welcome to refundList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "returnExchange");//我的订单-左边菜单标志
		List<RefundResponseDto> dataList = null;
		try {
			requestDto.setUserId(UserContext.get().getUserId());
			
			dataList = refundService.queryRefundListWithPage(requestDto, pageUtil);
			if(null == refundService){
				dataList = new ArrayList<RefundResponseDto>();
			}
			model.addAttribute("AuditStatusMap", AuditStatusEnum.getMap());
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeController.refundList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_REFUND_LIST_PAGE;
	}
	@RequestMapping("getReturnExchange")
	public String getReturnExchange(Model model, ReturnExchangeRequestDto requestDto){
		LOG.info("-- welcome to getReturnExchange index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "returnExchange");//我的订单-左边菜单标志
		ReturnExchangeResponseDto responseDto = null;
		try {
			requestDto.setUserId(UserContext.get().getUserId());
			requestDto.setServiceNo(requestDto.getServiceNo());
			responseDto = returnExchangeService.getReturnExchange(requestDto);
			ServiceAuditRequestDto auditRequestDto = new ServiceAuditRequestDto();
			auditRequestDto.setServiceNo(requestDto.getServiceNo());
			List<ServiceAuditResponseDto> responseDtoList = serviceAuditService.queryServiceAuditList(auditRequestDto);
			model.addAttribute("dataList", responseDtoList);
			model.addAttribute("AuditStatusMap", AuditStatusEnum.getMap());
			model.addAttribute("ReturnExchange", responseDto);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeController.getReturnExchange#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_RETURN_EXCHANGE_DETAIL_PAGE;
	}
}
