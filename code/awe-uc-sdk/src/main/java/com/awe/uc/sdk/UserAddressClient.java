package com.awe.uc.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.UserAddressRequest;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.UserAddressListResponse;
import com.awe.uc.sdk.response.UserAddressResponse;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

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
    
    /**
     * 查询收货地址列表
     * @param requestDto
     * @return
     */
    public List<UserAddressResponseDto> queryUserAddressList(UserAddressRequestDto requestDto){
    	Assert.notNull(requestDto);
    	UserAddressRequest request = new UserAddressRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("queryUserAddressList request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAddress/queryUserAddressList";
        UserAddressListResponse response = super.getRestTemplate().postForObject(url, request, UserAddressListResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("queryUserAddressList url: " + url);
            LOG.debug("queryUserAddressList response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 添加收货地址
     * @param requestDto
     * @return
     */
    public Wrapper<?> insert(UserAddressRequestDto requestDto){
    	Assert.notNull(requestDto);

        UserAddressRequest request = new UserAddressRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("insert request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAddress/insert";
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("insert url: " + url);
            LOG.debug("insert response: " + JsonHelper.toJson(response));
        }
        if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    
    /**
     * 编辑收货地址
     * @param requestDto
     * @return
     */
    public Wrapper<?> update(UserAddressRequestDto requestDto){
    	Assert.notNull(requestDto);

        UserAddressRequest request = new UserAddressRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("update request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAddress/update";
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("update url: " + url);
            LOG.debug("update response: " + JsonHelper.toJson(response));
        }
        if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 删除收货地址
     * @param requestDto
     * @return
     */
    public Wrapper<?> delete(UserAddressRequestDto requestDto){
    	Assert.notNull(requestDto);

        UserAddressRequest request = new UserAddressRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("delete request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/userAddress/delete";
        UserAddressResponse response = super.getRestTemplate().postForObject(url, request, UserAddressResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("delete url: " + url);
            LOG.debug("delete response: " + JsonHelper.toJson(response));
        }
        if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    
}
