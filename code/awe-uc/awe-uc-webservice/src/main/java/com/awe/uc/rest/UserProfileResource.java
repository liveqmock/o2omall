package com.awe.uc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.uc.domain.UserProfile;
import com.awe.uc.sdk.api.request.UserProfileRequest;
import com.awe.uc.sdk.api.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.api.response.UserAccountResponse;
import com.awe.uc.sdk.api.response.UserProfileResponse;
import com.awe.uc.sdk.api.response.dto.UserProfileResponseDto;
import com.awe.uc.service.UserProfileService;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 用户基本信息REST服务：提供有关用户基本信息的接口
 * 
 * @author ljz,zyq
 * @version 2014-12-23 15:38:41
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserProfileResource {

    private static final Log LOG = LogFactory.getLog(UserProfileResource.class);

    @Autowired
    private UserProfileService userProfileService; 

    /**
     * 查询用户基本信息信息
     * 
     * @param request
     *            用户基本信息请求参数
     * @return 用户基本信息返回对象
     * 
     */
    @POST
    @Path("/userProfile/getUserProfile")
    public Wrapper<?> getUserProfile(UserProfileRequest request) {
        if (null == request || !request.checkSign()) {
        	LOG.error("getUserProfile 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        UserProfileRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getUserId()) {
        	LOG.error("getUserProfile 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserProfile userProfile = userProfileService.getUserProfileById(requestDto.getId());
            UserProfileResponseDto responseDto = convert(userProfile);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
        	LOG.error("查询用户基本信息数据异常", e);
            return WrapMapper.error();
        }
    } 
    
    /**
     * 查询用户基本信息信息根据Bean
     * 
     * @param request
     *            用户基本信息请求参数
     * @return 用户基本信息返回对象
     * 
     */
    @POST
    @Path("/userProfile/getUserProfileByBean")
    public Wrapper<?> getUserProfileByBean(UserProfileRequest request) {
        if (null == request || !request.checkSign()) {
        	LOG.error("getUserProfile 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        UserProfileRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getUserId()) {
        	LOG.error("getUserProfile 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	UserProfile bean = new UserProfile();
        	bean.setUserId(requestDto.getUserId());
            UserProfile userProfile = userProfileService.getUserProfileByBean(bean);
            UserProfileResponseDto responseDto = convert(userProfile);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
        	LOG.error("查询用户基本信息数据异常", e);
            return WrapMapper.error();
        }
    } 
    
    @POST
    @Path("/userProfile/add")
    public Wrapper<?> add(UserProfileRequest request){
    	if (null == request || !request.checkSign()) {
    		LOG.error("register 拒绝访问");
            return WrapMapper.forbidden();
        }
    	UserProfileRequestDto requestDto = request.getContent();
    	if (null == requestDto) {
    		LOG.error("add 传入参数有误");
            return WrapMapper.illegalArgument();
        }
    	try {
    		UserProfile userProfile = new UserProfile();
    		BeanUtils.copyProperties(requestDto, userProfile);
    		boolean ret = userProfileService.insert(userProfile);
    		if (ret) {
                return WrapMapper.ok();
            } else {
            	LOG.warn("添加基本资料 失败，未知错误， Nickname=" + requestDto.getNickname());
                return WrapMapper.wrap(UserProfileResponse.ERROR_CODE, UserAccountResponse.ERROR_MESSAGE);
            }
		} catch (Exception e) {
			LOG.warn("添加基本资料 失败，未知错误， Nickname=" + requestDto.getNickname() + ":" + e);
			return WrapMapper.error();
		}
    }
    @POST
    @Path("/userProfile/edit")
    public Wrapper<?> edit(UserProfileRequest request){
    	if (null == request || !request.checkSign()) {
    		LOG.error("register 拒绝访问");
            return WrapMapper.forbidden();
        }
    	UserProfileRequestDto requestDto = request.getContent();
    	if (null == requestDto) {
    		LOG.error("edit 传入参数有误");
            return WrapMapper.illegalArgument();
        }
    	try {
    		UserProfile bean = new UserProfile();
    		bean.setUserId(requestDto.getUserId());
    		UserProfile userProfile = userProfileService.getUserProfileByBean(bean);
    		userProfile.setCnName(requestDto.getCnName());
    		userProfile.setBirthday(requestDto.getBirthday());
    		userProfile.setProvinceName(requestDto.getProvinceName());
    		userProfile.setProvinceNo(requestDto.getProvinceNo());
    		userProfile.setCityName(requestDto.getCityName());
    		userProfile.setCityNo(requestDto.getCityNo());
    		userProfile.setCountyName(requestDto.getCountyName());
    		userProfile.setCountyNo(requestDto.getCountyNo());
    		userProfile.setAddress(requestDto.getAddress());
    		userProfile.setNickname(requestDto.getNickname());
    		userProfile.setSex(requestDto.getSex());
    		//BeanUtils.copyProperties(requestDto, userProfile);
    		boolean ret = userProfileService.update(userProfile);
    		if (ret) {
                return WrapMapper.ok();
            } else {
            	LOG.warn("编辑基本资料 失败，未知错误， Nickname=" + requestDto.getNickname() + ",UserId=" + requestDto.getUserId());
                return WrapMapper.wrap(UserProfileResponse.ERROR_CODE, UserAccountResponse.ERROR_MESSAGE);
            }
		} catch (Exception e) {
			LOG.warn("编辑基本资料 失败，未知错误， Nickname=" + requestDto.getNickname() + ",UserId=" + requestDto.getUserId());
			return WrapMapper.error();
		}
    }
    
    
    
    
    // 数据转换
    private UserProfileResponseDto convert(UserProfile userProfile) {
        if (null == userProfile) {
            return null;
        }

        UserProfileResponseDto userProfileResponseDto = new UserProfileResponseDto();
        BeanUtils.copyProperties(userProfile, userProfileResponseDto);
        return userProfileResponseDto;
    }

    // 数据转换
    private List<UserProfileResponseDto> convertList(List<UserProfile> userProfiles) {
        if (CollectionUtils.isEmpty(userProfiles)) {
            return null;
        }

        List<UserProfileResponseDto> list = new ArrayList<UserProfileResponseDto>(userProfiles.size());
        for (UserProfile userProfile : userProfiles) {
            list.add(convert(userProfile));
        }
        return list;
    } 

}
