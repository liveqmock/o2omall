package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
/**
 * @description 个人基本信息
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("profile")
public class ProfileController {

	private static final Log LOG = LogFactory.getLog(ProfileController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PAGE = " personalProfile";
//	private static final String VIEW_ADD_SUCCESS = "addCartSuccess";
	/**
	 * 打开个人基础资料首页面
	 */
	@RequestMapping("myprofile")
	public String profile(Model model){
		LOG.info("-- welcome to myProfile page --");
		return VIEW_WORKSPACE + VIEW_PAGE;
	}
	/**
	 * 编辑个人基本资料
	 * @param model
	 * @param profile
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Model model,UserProfileRequestDto profile){
		LOG.info("-- welcome to edit page --");
		return VIEW_WORKSPACE + VIEW_PAGE;
	}
	/**
	 * 完善个人基础资料
	 * @param model
	 * @param profile
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model,UserProfileRequestDto profile){
		return "";
	}
}
