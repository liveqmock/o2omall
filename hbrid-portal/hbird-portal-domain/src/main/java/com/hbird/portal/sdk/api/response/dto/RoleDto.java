/**
 * 
 */
package com.hbird.portal.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * 角色对象<br/>
 * 提供接口时方法的返回对象
 * 
 * @author ljz
 * 
 */
public class RoleDto extends HbirdDto {

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
