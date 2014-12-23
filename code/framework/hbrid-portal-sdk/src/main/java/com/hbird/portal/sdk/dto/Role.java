/**
 * 
 */
package com.hbird.portal.sdk.dto;

import com.hbird.common.sdk.api.HbirdObject;

/**
 * 角色对象
 * 
 * @author ljz
 * 
 */
public class Role implements HbirdObject {

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
