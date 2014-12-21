package com.awe.uc.sdk.request;

import com.hbird.common.sdk.api.request.HbirdRequest;
import java.util.Date;

/**
 * UserBasicRequest：用户基本信息请求参数
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class UserBasicRequest extends HbirdRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 用户ID */
    private Long userId; 
    /** 性别 */
    private Integer userSex; 
    /** 生日 */
    private Date userBirthday; 
    /** 地区-省份-名称 */
    private String userProvinceName; 
    /** 地区-省份-编号 */
    private String userProvinceNo; 
    /** 地区-市-名称 */
    private String userCityName; 
    /** 地区-市-编号 */
    private String userCityNo; 
    /** 地区-区-名称 */
    private String userAreaName; 
    /** 地区-区-编号 */
    private String userAreaNo; 
    /** 联系地址 */
    private String userAddress; 
    /** 固定电话 */
    private String userTelephone; 
    /** 安全问题 */
    private String userSafeques; 
    /** 安全问题答案 */
    private String userSafeanswer; 
    /** QQ */
    private String userQq; 
    /** 会员等级 */
    private Integer userGrade; 
    /** 当前账户余额 */
    private Double userBalance; 
    /** 我的剩余积分 */
    private Integer user integral; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createName; 
    /** 修改人 */
    private String updateName; 
    /** 是否有效 */
    private Integer yn; 
    
    public Long getId(){
        return id;
    }
        
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId(){
        return userId;
    }
        
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Integer getUserSex(){
        return userSex;
    }
        
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }
    
    public Date getUserBirthday(){
        return userBirthday;
    }
        
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
    
    public String getUserProvinceName(){
        return userProvinceName;
    }
        
    public void setUserProvinceName(String userProvinceName) {
        this.userProvinceName = userProvinceName;
    }
    
    public String getUserProvinceNo(){
        return userProvinceNo;
    }
        
    public void setUserProvinceNo(String userProvinceNo) {
        this.userProvinceNo = userProvinceNo;
    }
    
    public String getUserCityName(){
        return userCityName;
    }
        
    public void setUserCityName(String userCityName) {
        this.userCityName = userCityName;
    }
    
    public String getUserCityNo(){
        return userCityNo;
    }
        
    public void setUserCityNo(String userCityNo) {
        this.userCityNo = userCityNo;
    }
    
    public String getUserAreaName(){
        return userAreaName;
    }
        
    public void setUserAreaName(String userAreaName) {
        this.userAreaName = userAreaName;
    }
    
    public String getUserAreaNo(){
        return userAreaNo;
    }
        
    public void setUserAreaNo(String userAreaNo) {
        this.userAreaNo = userAreaNo;
    }
    
    public String getUserAddress(){
        return userAddress;
    }
        
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    
    public String getUserTelephone(){
        return userTelephone;
    }
        
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
    
    public String getUserSafeques(){
        return userSafeques;
    }
        
    public void setUserSafeques(String userSafeques) {
        this.userSafeques = userSafeques;
    }
    
    public String getUserSafeanswer(){
        return userSafeanswer;
    }
        
    public void setUserSafeanswer(String userSafeanswer) {
        this.userSafeanswer = userSafeanswer;
    }
    
    public String getUserQq(){
        return userQq;
    }
        
    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }
    
    public Integer getUserGrade(){
        return userGrade;
    }
        
    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }
    
    public Double getUserBalance(){
        return userBalance;
    }
        
    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }
    
    public Integer getUser integral(){
        return user integral;
    }
        
    public void setUser integral(Integer user integral) {
        this.user integral = user integral;
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
    
    public Integer getYn(){
        return yn;
    }
        
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
