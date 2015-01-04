package com.awe.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.UserAddressService;
import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
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
		model.addAttribute("userId", getLoginUserId());
		return VIEW_WORKSPACE + VIEW_order_info;
	}
	
	
	/**
	  * 加载用户配送地址 
	  * Date:2015年1月4日下午4:30:03
	  * user:js
	  * @param model
	  * @param request
	  * @return
	  */
	 @RequestMapping("address")
	 @ResponseBody
     public Wrapper<?> modifyPassword(Model model, UserAddressRequestDto requestDto) {
		 List<UserAddressResponseDto> ret = null;
        try {
        	ret = userAddressService.queryUserAddressList(requestDto);
        	if (!CollectionUtils.isEmpty(ret)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, ret);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "没有查询到信息！");
            }
        } catch (Exception e) {
            logger.error("modifyPassword has error,", e);
            return WrapMapper.error();
        }
    }
	
	
	
}
