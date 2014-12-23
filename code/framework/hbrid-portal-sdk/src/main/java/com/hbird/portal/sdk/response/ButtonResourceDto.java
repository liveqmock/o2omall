package com.hbird.portal.sdk.response;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * ButtonResource返回DTO对象
 * 
 * @author ljz
 * @version 2014-12-1 下午8:14:32
 */
public class ButtonResourceDto extends HbirdDto {
    /**
     * 
     */
    private static final long serialVersionUID = 9219768603981233383L;
    /** 资源编码 */
    private String code;
    /** 按钮ID */
    private String buttonId;
    /** 按钮名称 */
    private String buttonName;
    /** 是否可以访问 */
    private boolean isPermitted;

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
     * @return the buttonId
     */
    public String getButtonId() {
        return buttonId;
    }

    /**
     * @param buttonId
     *            the buttonId to set
     */
    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    /**
     * @return the buttonName
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * @param buttonName
     *            the buttonName to set
     */
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * @return the isPermitted
     */
    public boolean getIsPermitted() {
        return isPermitted;
    }

    /**
     * @param isPermitted
     *            the isPermitted to set
     */
    public void setIsPermitted(boolean isPermitted) {
        this.isPermitted = isPermitted;
    }

}
