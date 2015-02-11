package com.hbird.common.ws.wap.request;

import javax.ws.rs.HeaderParam;

import com.hbird.common.sdk.api.HbirdObject;
import com.hbird.common.utils.security.SignatureUtil;

/**
 * WAP请求基类
 * 
 * @author ljz
 * @version 2015-2-10 上午11:11:23
 */
public abstract class HbirdFormRequest implements HbirdObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /** 调用方的秘钥 */
    private String key = "WAP";

    /** 安全认证的token */
    @HeaderParam("token")
    private String token;

    /** 用户ID */
    @HeaderParam("userId")
    private Long userId;

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 校验签名
     * 
     * @return 通过true；不通过false
     */
    public boolean checkSign() {
        return SignatureUtil.checkSign(String.valueOf(userId), key, token);
    }

}
