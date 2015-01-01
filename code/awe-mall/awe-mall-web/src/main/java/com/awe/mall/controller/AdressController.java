package com.awe.mall.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.UserAddressService;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * @description 送货地址
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("address")
public class AdressController extends BaseController{

	private static final Log LOG = LogFactory.getLog(AdressController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PAGE = "deliveryAddress";
	@Autowired
	private UserAddressService userAddressService;
	
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
	@RequestMapping("doAdd")
	public Wrapper<?> doAdd(Model model,UserAddressRequestDto requestDto){
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressService.insert(requestDto);
		} catch (Exception e) {
			LOG.error("#AdressController.doAdd# Error:" + e);
		}
		return wrapper;
	}
	@RequestMapping("doUpdate")
	public Wrapper<?> doUpdate(Model model,UserAddressRequestDto requestDto){
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressService.update(requestDto);
		} catch (Exception e) {
			LOG.error("#AdressController.doUpdate# Error:" + e);
		}
		return wrapper;
	}
	@RequestMapping("doDelete")
	public Wrapper<?> doDelete(Model model,UserAddressRequestDto requestDto){
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressService.delete(requestDto);
		} catch (Exception e) {
			LOG.error("#AdressController.doDelete# Error:" + e);
		}
		return wrapper;
	}
	@RequestMapping("queryUserAddressList")
	public void queryUserAddressList(Model model,UserAddressRequestDto requestDto){
		List<UserAddressResponseDto> ret = null;
		try {
			ret = userAddressService.queryUserAddressList(requestDto);
			model.addAttribute("dataList", ret);
		} catch (Exception e) {
			LOG.error("#AdressController.queryUserAddressList# Error:" + e);
		}
	}
}
