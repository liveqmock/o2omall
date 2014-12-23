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

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.uc.domain.UserProfile;
import com.awe.uc.sdk.api.request.UserProfileRequest;
import com.awe.uc.sdk.api.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.api.response.dto.UserProfileResponseDto;
import com.awe.uc.service.UserProfileService;

/**
 * 用户基本信息REST服务：提供有关用户基本信息的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserProfileResource {

    private final Log logger = LogFactory.getLog(this.getClass());

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
            this.logger.error("getUserProfile 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        UserProfileRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getUserProfile 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserProfile userProfile = userProfileService.getUserProfileById(requestDto.getId());
            UserProfileResponseDto responseDto = convert(userProfile);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询用户基本信息数据异常", e);
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
