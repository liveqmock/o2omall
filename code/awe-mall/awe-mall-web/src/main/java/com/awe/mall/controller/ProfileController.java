package com.awe.mall.controller;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.ProfileService;
import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.common.web.context.UserContext;
/**
 * @description 个人基本信息
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("profile")
public class ProfileController extends BaseController{

	private static final Log LOG = LogFactory.getLog(ProfileController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PAGE = "personalProfile";
//	private static final String VIEW_ADD_SUCCESS = "addCartSuccess";
	
	@Autowired
	private ProfileService profileService;
	/**
	 * 打开个人基础资料首页面
	 */
	@RequestMapping("myprofile")
	public String profile(Model model){
		LOG.info("-- welcome to myProfile page --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
        model.addAttribute("leftFlag", "myprofile");//我的订单-左边菜单标志
        try {
        	UserProfileRequestDto profile = new UserProfileRequestDto();
        	profile.setUserId(UserContext.get().getUserId());
        	UserProfileResponseDto responseDto = profileService.getUserProfileByBean(profile);
        	model.addAttribute("UserProfile", responseDto);
		} catch (Exception e) {
			LOG.error("#ProfileController.profile#ERROR:" + e);
		}
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
	@ResponseBody
	public Wrapper<?> doAdd(Model model,UserProfileRequestDto requestDto,String birthdayStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Wrapper<?> wrapper = null;
		if(null == requestDto){
			return WrapMapper.illegalArgument();
		}
		try {
			if(null != requestDto.getId()){
				wrapper = profileService.edit(requestDto);
			}else{
				requestDto.setBirthday(sdf.parse(birthdayStr));
				requestDto.setUserId(UserContext.get().getUserId());
				wrapper = profileService.add(requestDto);
			}
			if(null != wrapper){
				return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
			}else{
				LOG.error("doAdd fail.");
				return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
			}
		} catch (Exception e) {
			LOG.error("#ProfileController.doAdd#ERROR:" + e);
			return WrapMapper.error();
		}
	}
}
