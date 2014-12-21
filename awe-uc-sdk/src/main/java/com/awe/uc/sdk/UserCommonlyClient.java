package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.response.dto.UserCommonlyDto;
import com.awe.uc.sdk.request.UserCommonlyRequest;
import com.awe.uc.sdk.response.UserCommonlyResponse;

/**
 * 用户-常用信息服务的客户端
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class UserCommonlyClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserCommonlyClient.class);

    /**
     * 用户-常用信息查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserCommonlyDto 对象
     */
    public UserCommonlyDto getUserCommonly(UserCommonlyRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserCommonly request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userCommonly/getUserCommonly";
        UserCommonlyResponse response = super.getRestTemplate().postForObject(url, request, UserCommonlyResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserCommonly url: " + url);
            LOG.debug("getUserCommonly response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
