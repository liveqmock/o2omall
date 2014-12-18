/**
 * 
 */
package com.hbird.portal.sdk.api.request;

import com.hbird.common.sdk.api.request.HbirdRequest;

/**
 * 资源查询请求参数
 * 
 * @author ljz
 * 
 */
public class ResourceRequest extends HbirdRequest {

    /**
     * 
     */
    private static final long serialVersionUID = -115478642398286158L;

    /** 用户名 */
    private String userName;

    /** 业务系统ID */
    private Integer systemId;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the systemId
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * @param systemId
     *            the systemId to set
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

}
