package com.awe.mall.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.UserAddressService;
import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * @description 填写并核对订单信息
 * @author js
 * @date 2014-1-3
 * @version 1.0.0
 */
@Controller
@RequestMapping("orderinfo")
@SuppressWarnings("all")
public class OrderInfoController extends BaseController{
	
	private static final Log LOG = LogFactory.getLog(OrderInfoController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_order_info = "orderinfo";
	
	@Autowired
	private UserAddressService userAddressService;
	
	@RequestMapping("info")
	public String orderInfo(Model model){
		LOG.info("-- welcome to orderInfo index --");
		return VIEW_WORKSPACE + VIEW_order_info;
	}
	
	
	 @RequestMapping("address")
	    public Wrapper<?> modifyPassword(Model model, HttpServletRequest request, String username, String oldPassword,
	            String newPassword, String smsCode, String checkCode) {
	        try {
	            PasswordModifyRequestDto requestDto = new PasswordModifyRequestDto();
	            requestDto.setUsername(username);
	            requestDto.setOldPassword(oldPassword);
	            requestDto.setNewPassword(newPassword);
	            requestDto.setMobile(username);
	            Wrapper<?> wrapper = null;//userAccountService.modifyPassword(requestDto);
	            if (null != wrapper) {
	                return wrapper;
	            } else {
	                logger.error("modifyPassword fail.");
	                return WrapMapper.error();
	            }
	        } catch (Exception e) {
	            logger.error("modifyPassword has error,", e);
	            return WrapMapper.error();
	        }
	    }
	
	
	
}
