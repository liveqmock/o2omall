package com.hbird.common.sdk.api.request;

import com.hbird.common.utils.security.SignatureUtil;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 安全请求对象
 * 
 * @author ljz
 * @version 2014-8-15 上午9:39:45
 */
public class HbirdSecureRequest<T> extends HbirdRequest {
    private static final long serialVersionUID = 1L;
    /**
     * 调用方的秘钥
     */
    private String key;
    /**
     * 安全验证码
     */
    private String sign;
    /**
     * 业务数据
     */
    private T content;

    /**
     * 
     */
    public HbirdSecureRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public HbirdSecureRequest(String key, T content) {
        this();
        this.key = key;
        this.content = content;
        String signature = SignatureUtil.generateSign(JsonHelper.toJson(content), key);
        setSign(signature);
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     *            the sign to set
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return the content
     */
    public T getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * 校验签名
     * 
     * @return 通过true；不通过false
     */
    public boolean checkSign() {
        return SignatureUtil.checkSign(JsonHelper.toJson(content), key, sign);
    }

}
