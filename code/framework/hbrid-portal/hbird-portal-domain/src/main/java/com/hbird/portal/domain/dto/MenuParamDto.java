/**
 * 
 */
package com.hbird.portal.domain.dto;

import java.io.Serializable;

/**
 * @author ljz
 * 
 */
public class MenuParamDto implements Serializable {

    private static final long serialVersionUID = -8805106252721918472L;
    private String menuCode;
    private String menuName;
    private String url;
    private String parentMenuCode;
    private String parentMenuName;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

}
