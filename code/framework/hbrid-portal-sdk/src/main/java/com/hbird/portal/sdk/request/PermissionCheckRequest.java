package com.hbird.portal.sdk.request;

import com.hbird.common.sdk.api.request.HbirdRequest;

/**
 * 权限验证请求参数
 * 
 * @author ljz
 * @version 2014-11-21 上午10:36:36
 */
public class PermissionCheckRequest extends HbirdRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1920146021261193438L;
    /** 用户ID */
    private Long userId;
    /** 资源码 */
    private String resourceCode;
    /** 资源Url */
    private String resourceUrl;

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
     * @return the resourceCode
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * @param resourceCode
     *            the resourceCode to set
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    /**
     * @return the resourceUrl
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl
     *            the resourceUrl to set
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

}
