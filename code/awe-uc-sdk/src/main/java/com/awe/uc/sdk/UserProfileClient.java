package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.UserProfileRequest;
import com.awe.uc.sdk.response.UserProfileResponse;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;

/**
 * 用户基本信息服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserProfileClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserProfileClient.class);

    /**
     * 用户基本信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserProfileDto 对象
     */
    public UserProfileResponseDto getUserProfile(UserProfileRequest request) {
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
