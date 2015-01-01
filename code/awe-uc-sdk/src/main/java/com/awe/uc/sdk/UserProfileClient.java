package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.uc.sdk.request.UserProfileRequest;
import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.response.UserProfileResponse;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;

/**
 * 用户基本信息服务的客户端
 * 
 * @author ljz,zyq
 * @version 2014-12-25 17:48:01
 * 
 */
public class UserProfileClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(UserProfileClient.class);

    /**
     * 用户基本信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserProfileResponseDto 接口返回的数据对象
     */
    public UserProfileResponseDto getUserProfile(UserProfileRequestDto requestDto) {
        Assert.notNull(requestDto);

        UserProfileRequest request = new UserProfileRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserProfile request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userProfile/getUserProfile";
        UserProfileResponse response = super.getRestTemplate().postForObject(url, request, UserProfileResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserProfile url: " + url);
            LOG.debug("getUserProfile response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    /**
     * 添加个人基本资料
     * @param requestDto
     * @return
     */
    public Wrapper<?> add(UserProfileRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("register request: " + JsonHelper.toJson(requestDto));
        }
    	UserProfileRequest request = new UserProfileRequest(super.getKey(), requestDto);
    	UserProfileResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/userProfile/add";
    	     response = super.getRestTemplate().postForObject(url, request, UserProfileResponse.class);
		} catch (Exception e) {
			LOG.error("#UserProfileClient.add# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("getUserProfile url: " + url);
            LOG.debug("getUserProfile response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 编辑个人基础资料
     * @param requestDto
     * @return
     */
    public Wrapper<?> edit(UserProfileRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("register request: " + JsonHelper.toJson(requestDto));
        }
    	UserProfileRequest request = new UserProfileRequest(super.getKey(), requestDto);
    	UserProfileResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/userProfile/edit";
    	     response = super.getRestTemplate().postForObject(url, request, UserProfileResponse.class);
		} catch (Exception e) {
			LOG.error("#UserProfileClient.add# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("getUserProfile url: " + url);
            LOG.debug("getUserProfile response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    
}
