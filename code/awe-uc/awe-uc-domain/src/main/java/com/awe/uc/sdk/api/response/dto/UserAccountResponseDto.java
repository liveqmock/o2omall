package com.awe.uc.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * UserAccountResponseDto：用户账号返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserAccountResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 账号 */
    private String username; 
    /** 登录次数 */
    private Integer loginTimes; 
    /** 用户上次登录IP */
    private String lastLoginIp; 
    /** 用户上次登录时间 */
    private Date lastLoginTime; 
    /**
     * get id自增
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set id自增
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 账号
     * 
     * @return the username
     */
    public String getUsername(){
        return username;
    }
        
    /**
     * set 账号
     * 
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * get 登录次数
     * 
     * @return the loginTimes
     */
    public Integer getLoginTimes(){
        return loginTimes;
    }
        
    /**
     * set 登录次数
     * 
     * @param loginTimes the loginTimes to set
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }
    
    /**
     * get 用户上次登录IP
     * 
     * @return the lastLoginIp
     */
    public String getLastLoginIp(){
        return lastLoginIp;
    }
        
    /**
     * set 用户上次登录IP
     * 
     * @param lastLoginIp the lastLoginIp to set
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    
    /**
     * get 用户上次登录时间
     * 
     * @return the lastLoginTime
     */
    public Date getLastLoginTime(){
        return lastLoginTime;
    }
        
    /**
     * set 用户上次登录时间
     * 
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
