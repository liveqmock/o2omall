package com.hbird.portal.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdRequest;

/**
 * 权限查询请求参数
 * 
 * @author ljz
 * @version 2014-11-21 上午10:36:36
 */
public class PermissionQueryRequest extends HbirdRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1920146021261193438L;
    /** 用户ID */
    private Long userId;
    /** 父资源码 */
    private String parentResourceCode;

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
     * @return the parentResourceCode
     */
    public String getParentResourceCode() {
        return parentResourceCode;
    }

    /**
     * @param parentResourceCode
     *            the parentResourceCode to set
     */
    public void setParentResourceCode(String parentResourceCode) {
        this.parentResourceCode = parentResourceCode;
    }

}
