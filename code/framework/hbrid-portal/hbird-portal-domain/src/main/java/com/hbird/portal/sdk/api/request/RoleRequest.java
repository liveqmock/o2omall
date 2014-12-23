/**
 * 
 */
package com.hbird.portal.sdk.api.request;

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

    /** 角色Id */
    private Long id;

    /** 角色编码 */
    private String code;

    /** 角色名称 */
    private String name;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

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
