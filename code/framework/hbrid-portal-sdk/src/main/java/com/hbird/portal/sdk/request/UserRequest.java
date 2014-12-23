/**
 * 
 */
package com.hbird.portal.sdk.request;

import com.hbird.common.sdk.api.request.HbirdPageRequest;

/**
 * 用户查询请求参数<br/>
 * 支持分页
 * 
 * @author ljz
 * 
 */
public class UserRequest extends HbirdPageRequest {

    /**
     * 
     */
    private static final long serialVersionUID = -7225281084722711418L;

    /** 用户ID */
    private Long id;

    /** 登录账号 */
    private String name;

    /** 中文姓名 */
    private String cnName;

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

    /**
     * @return the cnName
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * @param cnName
     *            the cnName to set
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

}
