/**
 * 
 */
package com.hbird.portal.sdk.request;

import com.hbird.common.sdk.api.request.HbirdRequest;

/**
 * 角色查询请求参数
 * 
 * @author ljz
 * 
 */
public class RoleRequest extends HbirdRequest {

    /**
     * 
     */
    private static final long serialVersionUID = 8668755180969092628L;

    /** 角色名称 */
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
