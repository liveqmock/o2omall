package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.response.dto.UserBasicDto;
import com.awe.uc.sdk.request.UserBasicRequest;
import com.awe.uc.sdk.response.UserBasicResponse;

/**
 * 用户基本信息服务的客户端
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class UserBasicClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserBasicClient.class);

    /**
     * 用户基本信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserBasicDto 对象
     */
    public UserBasicDto getUserBasic(UserBasicRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserBasic request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userBasic/getUserBasic";
        UserBasicResponse response = super.getRestTemplate().postForObject(url, request, UserBasicResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserBasic url: " + url);
            LOG.debug("getUserBasic response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
