/**
 * 
 */
package com.hbird.portal.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * 资源对象<br/>
 * 提供接口时方法的返回对象
 * 
 * @author ljz
 * 
 */
public class ResourceDto extends HbirdDto {

    /**
     * 
     */
    private static final long serialVersionUID = -3679244723766353832L;

    /** 业务系统编码 */
    private String sysCode;

    /** 1：菜单, 2：按钮 */
    private Integer type;

    /** 此资源的唯一标识，不可重复 */
    private String code;

    /** 资源名称 */
    private String name;

    /** 菜单使用 */
    private String url;

    /** 按钮使用 1：可以点击, 0：不可以点击 */
    private Integer isClick;

    /** 父ID */
    private Long parentId;

    /** 1：有, 0：没有 */
    private Integer hasChild;

    /** 层级 */
    private Integer level;

    /** 优先级(顺序) */
    private Integer priority;

    /** 图标 */
    private String icon;

    /**
     * @return the sysCode
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * @param sysCode
     *            the sysCode to set
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type) {
        this.type = type;
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

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the isClick
     */
    public Integer getIsClick() {
        return isClick;
    }

    /**
     * @param isClick
     *            the isClick to set
     */
    public void setIsClick(Integer isClick) {
        this.isClick = isClick;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the hasChild
     */
    public Integer getHasChild() {
        return hasChild;
    }

    /**
     * @param hasChild
     *            the hasChild to set
     */
    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
    }

    /**
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority
     *            the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     *            the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
