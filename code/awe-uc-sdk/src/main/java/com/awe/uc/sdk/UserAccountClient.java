package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.UserAccountRequest;
import com.awe.uc.sdk.response.UserAccountResponse;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;

/**
 * 用户账号服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserAccountClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserAccountClient.class);

    /**
     * 用户账号查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserAccountDto 对象
     */
    public UserAccountResponseDto getUserAccount(UserAccountRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserAccount request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAccount/getUserAccount";
        UserAccountResponse response = super.getRestTemplate().postForObject(url, request, UserAccountResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserAccount url: " + url);
            LOG.debug("getUserAccount response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
