package com.hbird.portal.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单（一级）对象
 * 
 * @author ljz
 * @version 2014-12-10 下午12:50:04
 */
public class MenuDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 353975192662199168L;
    /** 菜单编码 */
    private String menuCode;
    /** 菜单名称 */
    private String menuName;
    /** 菜单图标 */
    private String menuIcon;
    /** 子菜单的集合 */
    private List<SubMenuDto> subMenus;

    /**
     * @return the menuCode
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode
     *            the menuCode to set
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     *            the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return the menuIcon
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * @param menuIcon
     *            the menuIcon to set
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * @return the subMenus
     */
    public List<SubMenuDto> getSubMenus() {
        return subMenus;
    }

    /**
     * @param subMenus
     *            the subMenus to set
     */
    public void setSubMenus(List<SubMenuDto> subMenus) {
        this.subMenus = subMenus;
    }

}
