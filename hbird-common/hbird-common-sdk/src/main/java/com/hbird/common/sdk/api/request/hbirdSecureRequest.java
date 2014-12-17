package com.hbird.common.sdk.api.request;

/**
 * 安全请求对象
 * 
 * @author lz
 * @version 2014-8-15 上午9:39:45
 */
public class hbirdSecureRequest<T> extends hbirdRequest {
    private static final long serialVersionUID = 1L;
    /**
     * 调用名称编码
     */
    private String partner;
    /**
     * 加密方式
     */
    private String sign_type;
    /**
     * 接口调用方法
     */
    private String service;
    /**
     * 安全验证码
     */
    private String sign;
    /**
     * 业务数据
     */
    private T content;

    /**
     * @return the partner
     */
    public String getPartner() {
        return partner;
    }

    /**
     * @param partner
     *            the partner to set
     */
    public void setPartner(String partner) {
        this.partner = partner;
    }

    /**
     * @return the sign_type
     */
    public String getSign_type() {
        return sign_type;
    }

    /**
     * @param sign_type
     *            the sign_type to set
     */
    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service
     *            the service to set
     */
    public void setService(String service) {
        this.service = service;
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

}
