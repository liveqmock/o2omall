package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.UserProfileRequest;
import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.response.UserProfileResponse;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;

/**
 * 用户基本信息服务的客户端
 * 
 * @author ljz
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
}
