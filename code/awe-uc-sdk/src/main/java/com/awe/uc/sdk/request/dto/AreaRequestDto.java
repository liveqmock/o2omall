package com.awe.uc.sdk.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * AreaRequestDto：三级地址请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class AreaRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** 自增ID */
    private Long id;
    /** 父编号 */
    private String parentCode;
    /** 编号 */
    private String code;
    /** 名称 */
    private String name;
    /** 级别 */
    private Integer level;

    /**
     * get 自增ID
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set 自增ID
     * 
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get 父编号
     * 
     * @return the parentCode
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * set 父编号
     * 
     * @param parentCode
     *            the parentCode to set
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * get 编号
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * set 编号
     * 
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get 名称
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * set 名称
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 级别
     * 
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * set 级别
     * 
     * @param level
     *            the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

}
