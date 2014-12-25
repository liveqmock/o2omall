package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.UserAddressRequest;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.UserAddressResponse;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;

/**
 * 收货地址服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:48:01
 * 
 */
public class UserAddressClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(UserAddressClient.class);

    /**
     * 收货地址查询服务
     * 
     * @param request
     *            查询请求对象
     * @return UserAddressResponseDto 接口返回的数据对象
     */
    public UserAddressResponseDto getUserAddress(UserAddressRequestDto requestDto) {
        Assert.notNull(requestDto);

        UserAddressRequest request = new UserAddressRequest(super.getKey(), requestDto);
        
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
