package com.awe.uc.sdk.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * UserProfileResponseDto：用户基本信息返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserProfileResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 用户ID */
    private Long userId; 
    /** 姓名 */
    private String cnname; 
    /** 性别 */
    private Integer sex; 
    /** 昵称 */
    private String nickname; 
    /** 邮箱 */
    private String email; 
    /** 0为未验证;1为正在更换邮箱;2为已验证 */
    private Integer emailValidated; 
    /** 生日 */
    private Date birthday; 
    /** 星座 */
    private String constellation; 
    /** 用户头像 */
    private String userPhoto; 
    /** 自我介绍 */
    private String description; 
    /** 地区-省份-名称 */
    private String provinceName; 
    /** 地区-省份-编号 */
    private String provinceNo; 
    /** 地区-市-名称 */
    private String cityName; 
    /** 地区-市-编号 */
    private String cityNo; 
    /** 地区-县-名称 */
    private String countyName; 
    /** 地区-县-编号 */
    private String countyNo; 
    /** 联系地址 */
    private String address; 
    /** 移动电话 */
    private String mobile; 
    /** 固定电话 */
    private String phone; 
    /** 安全问题 */
    private String safeQuestion; 
    /** 安全问题答案 */
    private String safeAnswer; 
    /** QQ */
    private String qq; 
    /** 会员等级 */
    private Integer grade; 
    /** 支付密码 */
    private String payPassword; 
    /** 我的剩余积分 */
    private Integer score; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 是否有效: 1-有效, 0-无效 */
    private Integer yn; 
    
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
     * get 用户ID
     * 
     * @return the userId
     */
    public Long getUserId(){
        return userId;
    }
        
    /**
     * set 用户ID
     * 
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * get 姓名
     * 
     * @return the cnname
     */
    public String getCnname(){
        return cnname;
    }
        
    /**
     * set 姓名
     * 
     * @param cnname the cnname to set
     */
    public void setCnname(String cnname) {
        this.cnname = cnname;
    }
    
    /**
     * get 性别
     * 
     * @return the sex
     */
    public Integer getSex(){
        return sex;
    }
        
    /**
     * set 性别
     * 
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    /**
     * get 昵称
     * 
     * @return the nickname
     */
    public String getNickname(){
        return nickname;
    }
        
    /**
     * set 昵称
     * 
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * get 邮箱
     * 
     * @return the email
     */
    public String getEmail(){
        return email;
    }
        
    /**
     * set 邮箱
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * get 0为未验证;1为正在更换邮箱;2为已验证
     * 
     * @return the emailValidated
     */
    public Integer getEmailValidated(){
        return emailValidated;
    }
        
    /**
     * set 0为未验证;1为正在更换邮箱;2为已验证
     * 
     * @param emailValidated the emailValidated to set
     */
    public void setEmailValidated(Integer emailValidated) {
        this.emailValidated = emailValidated;
    }
    
    /**
     * get 生日
     * 
     * @return the birthday
     */
    public Date getBirthday(){
        return birthday;
    }
        
    /**
     * set 生日
     * 
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    /**
     * get 星座
     * 
     * @return the constellation
     */
    public String getConstellation(){
        return constellation;
    }
        
    /**
     * set 星座
     * 
     * @param constellation the constellation to set
     */
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
    
    /**
     * get 用户头像
     * 
     * @return the userPhoto
     */
    public String getUserPhoto(){
        return userPhoto;
    }
        
    /**
     * set 用户头像
     * 
     * @param userPhoto the userPhoto to set
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
    
    /**
     * get 自我介绍
     * 
     * @return the description
     */
    public String getDescription(){
        return description;
    }
        
    /**
     * set 自我介绍
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * get 地区-省份-名称
     * 
     * @return the provinceName
     */
    public String getProvinceName(){
        return provinceName;
    }
        
    /**
     * set 地区-省份-名称
     * 
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    /**
     * get 地区-省份-编号
     * 
     * @return the provinceNo
     */
    public String getProvinceNo(){
        return provinceNo;
    }
        
    /**
     * set 地区-省份-编号
     * 
     * @param provinceNo the provinceNo to set
     */
    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }
    
    /**
     * get 地区-市-名称
     * 
     * @return the cityName
     */
    public String getCityName(){
        return cityName;
    }
        
    /**
     * set 地区-市-名称
     * 
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * get 地区-市-编号
     * 
     * @return the cityNo
     */
    public String getCityNo(){
        return cityNo;
    }
        
    /**
     * set 地区-市-编号
     * 
     * @param cityNo the cityNo to set
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }
    
    /**
     * get 地区-县-名称
     * 
     * @return the countyName
     */
    public String getCountyName(){
        return countyName;
    }
        
    /**
     * set 地区-县-名称
     * 
     * @param countyName the countyName to set
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    
    /**
     * get 地区-县-编号
     * 
     * @return the countyNo
     */
    public String getCountyNo(){
        return countyNo;
    }
        
    /**
     * set 地区-县-编号
     * 
     * @param countyNo the countyNo to set
     */
    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }
    
    /**
     * get 联系地址
     * 
     * @return the address
     */
    public String getAddress(){
        return address;
    }
        
    /**
     * set 联系地址
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * get 移动电话
     * 
     * @return the mobile
     */
    public String getMobile(){
        return mobile;
    }
        
    /**
     * set 移动电话
     * 
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    /**
     * get 固定电话
     * 
     * @return the phone
     */
    public String getPhone(){
        return phone;
    }
        
    /**
     * set 固定电话
     * 
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * get 安全问题
     * 
     * @return the safeQuestion
     */
    public String getSafeQuestion(){
        return safeQuestion;
    }
        
    /**
     * set 安全问题
     * 
     * @param safeQuestion the safeQuestion to set
     */
    public void setSafeQuestion(String safeQuestion) {
        this.safeQuestion = safeQuestion;
    }
    
    /**
     * get 安全问题答案
     * 
     * @return the safeAnswer
     */
    public String getSafeAnswer(){
        return safeAnswer;
    }
        
    /**
     * set 安全问题答案
     * 
     * @param safeAnswer the safeAnswer to set
     */
    public void setSafeAnswer(String safeAnswer) {
        this.safeAnswer = safeAnswer;
    }
    
    /**
     * get QQ
     * 
     * @return the qq
     */
    public String getQq(){
        return qq;
    }
        
    /**
     * set QQ
     * 
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    /**
     * get 会员等级
     * 
     * @return the grade
     */
    public Integer getGrade(){
        return grade;
    }
        
    /**
     * set 会员等级
     * 
     * @param grade the grade to set
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    /**
     * get 支付密码
     * 
     * @return the payPassword
     */
    public String getPayPassword(){
        return payPassword;
    }
        
    /**
     * set 支付密码
     * 
     * @param payPassword the payPassword to set
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
    
    /**
     * get 我的剩余积分
     * 
     * @return the score
     */
    public Integer getScore(){
        return score;
    }
        
    /**
     * set 我的剩余积分
     * 
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }
    
    /**
     * get 创建时间
     * 
     * @return the createTime
     */
    public Date getCreateTime(){
        return createTime;
    }
        
    /**
     * set 创建时间
     * 
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * get 修改时间
     * 
     * @return the updateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }
        
    /**
     * set 修改时间
     * 
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * get 创建人
     * 
     * @return the createUser
     */
    public String getCreateUser(){
        return createUser;
    }
        
    /**
     * set 创建人
     * 
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    /**
     * get 修改人
     * 
     * @return the updateUser
     */
    public String getUpdateUser(){
        return updateUser;
    }
        
    /**
     * set 修改人
     * 
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    /**
     * get 是否有效: 1-有效, 0-无效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效: 1-有效, 0-无效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
