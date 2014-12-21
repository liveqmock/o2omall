package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.response.dto.UserImgDto;
import com.awe.uc.sdk.request.UserImgRequest;
import com.awe.uc.sdk.response.UserImgResponse;

/**
 * 用户关联图片服务的客户端
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class UserImgClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserImgClient.class);

    /**
     * 用户关联图片查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserImgDto 对象
     */
    public UserImgDto getUserImg(UserImgRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserImg request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userImg/getUserImg";
        UserImgResponse response = super.getRestTemplate().postForObject(url, request, UserImgResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserImg url: " + url);
            LOG.debug("getUserImg response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
