package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.UserAddressRequest;
import com.awe.uc.sdk.response.UserAddressResponse;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;

/**
 * 收货地址服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserAddressClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(UserAddressClient.class);

    /**
     * 收货地址查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserAddressDto 对象
     */
    public UserAddressResponseDto getUserAddress(UserAddressRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserAddress request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAddress/getUserAddress";
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUserAddress url: " + url);
            LOG.debug("getUserAddress response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
