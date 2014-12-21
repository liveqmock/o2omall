package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * UserCommonlyQuery：用户-常用信息查询类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:30
 * 
 */
public class UserCommonlyQuery extends Query {
    
    /** id自增 */
	private Long id; 
    /** 用户名 */
	private String userUsername; 
    /** 密码 */
	private String userPassword; 
    /** 邮箱 */
	private String userEmail; 
    /** 姓名 */
	private String userName; 
    /** 移动电话 */
	private String userMobile; 
    /** 用户是否验证邮箱 */
	private Integer userValidated; 
    /** 登录次数 */
	private Integer userLogin; 
    /** 用户上次登录IP */
	private String userLastloginip; 
    /** 用户上次登录时间 */
	private Date userLastlogintime; 
    /** 创建人 */
	private String createName; 
    /** 修改人 */
	private String updateName; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改时间 */
	private Date updateTime; 
    /** 是否有效 */
	private Integer yn; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
	
    public Long getId(){
		return id;
	}
	    
    public void setId(Long id) {
		this.id = id;
	}
	
    public String getUserUsername(){
		return userUsername;
	}
	    
    public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
    public String getUserPassword(){
		return userPassword;
	}
	    
    public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
    public String getUserEmail(){
		return userEmail;
	}
	    
    public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
    public String getUserName(){
		return userName;
	}
	    
    public void setUserName(String userName) {
		this.userName = userName;
	}
	
    public String getUserMobile(){
		return userMobile;
	}
	    
    public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
    public Integer getUserValidated(){
		return userValidated;
	}
	    
    public void setUserValidated(Integer userValidated) {
		this.userValidated = userValidated;
	}
	
    public Integer getUserLogin(){
		return userLogin;
	}
	    
    public void setUserLogin(Integer userLogin) {
		this.userLogin = userLogin;
	}
	
    public String getUserLastloginip(){
		return userLastloginip;
	}
	    
    public void setUserLastloginip(String userLastloginip) {
		this.userLastloginip = userLastloginip;
	}
	
    public Date getUserLastlogintime(){
		return userLastlogintime;
	}
	    
    public void setUserLastlogintime(Date userLastlogintime) {
		this.userLastlogintime = userLastlogintime;
	}
	
    public String getCreateName(){
		return createName;
	}
	    
    public void setCreateName(String createName) {
		this.createName = createName;
	}
	
    public String getUpdateName(){
		return updateName;
	}
	    
    public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	
    public Date getCreateTime(){
		return createTime;
	}
	    
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    public Date getUpdateTime(){
		return updateTime;
	}
	    
    public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
    public Integer getYn(){
		return yn;
	}
	    
    public void setYn(Integer yn) {
		this.yn = yn;
	}

    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
