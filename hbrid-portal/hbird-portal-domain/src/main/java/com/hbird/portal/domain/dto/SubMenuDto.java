package com.hbird.portal.domain.dto;

import java.io.Serializable;

/**
 * 子菜单（二级）对象
 * 
 * @author ljz
 * @version 2014-12-10 下午12:49:53
 */
public class SubMenuDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3060106837613141316L;
    /** 子菜单编码 */
    private String subMenuCode;
    /** 子菜单名称 */
    private String subMenuName;
    /** 子菜单图标 */
    private String subMenuIcon;
    /** 子菜单URL */
    private String subMenuUrl;

    /**
     * @return the subMenuCode
     */
    public String getSubMenuCode() {
        return subMenuCode;
    }

    /**
     * @param subMenuCode
     *            the subMenuCode to set
     */
    public void setSubMenuCode(String subMenuCode) {
        this.subMenuCode = subMenuCode;
    }

    /**
     * @return the subMenuName
     */
    public String getSubMenuName() {
        return subMenuName;
    }

    /**
     * @param subMenuName
     *            the subMenuName to set
     */
    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    /**
     * @return the subMenuIcon
     */
    public String getSubMenuIcon() {
        return subMenuIcon;
    }

    /**
     * @param subMenuIcon
     *            the subMenuIcon to set
     */
    public void setSubMenuIcon(String subMenuIcon) {
        this.subMenuIcon = subMenuIcon;
    }

    /**
     * @return the subMenuUrl
     */
    public String getSubMenuUrl() {
        return subMenuUrl;
    }

    /**
     * @param subMenuUrl
     *            the subMenuUrl to set
     */
    public void setSubMenuUrl(String subMenuUrl) {
        this.subMenuUrl = subMenuUrl;
    }

}
