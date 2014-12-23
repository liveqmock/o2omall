package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * UserAddressQuery：收货地址查询类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
public class UserAddressQuery extends Query {
    
    /** 自增Id */
	private Long id; 
    /** 用户ID */
	private Long userId; 
    /** 收货人姓名 */
	private String name; 
    /** 省份名称 */
	private String provinceName; 
    /** 省份编码 */
	private String provinceNo; 
    /** 市名称 */
	private String cityName; 
    /** 市编号 */
	private String cityNo; 
    /** 县名称 */
	private String countyName; 
    /** 县编码 */
	private String countyNo; 
    /** 详细地址 */
	private String address; 
    /** 移动电话 */
	private String mobile; 
    /** 固定电话 */
	private String phone; 
    /** 电子邮件 */
	private String email; 
    /** 邮编 */
	private String zipcode; 
    /** 创建人 */
	private String createUser; 
    /** 修改人 */
	private String updateUser; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改时间 */
	private Date updateTime; 
    /** 是否有效: 1-有效, 0-无效 */
	private Integer yn; 
    /** 开始时间 */
    private Date startTime; 
    /** 结束时间 */
    private Date endTime; 
    
    /**
     * get 自增Id
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 自增Id
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
     * get 收货人姓名
     * 
     * @return the name
     */
    public String getName(){
        return name;
    }
        
    /**
     * set 收货人姓名
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get 省份名称
     * 
     * @return the provinceName
     */
    public String getProvinceName(){
        return provinceName;
    }
        
    /**
     * set 省份名称
     * 
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    /**
     * get 省份编码
     * 
     * @return the provinceNo
     */
    public String getProvinceNo(){
        return provinceNo;
    }
        
    /**
     * set 省份编码
     * 
     * @param provinceNo the provinceNo to set
     */
    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }
    
    /**
     * get 市名称
     * 
     * @return the cityName
     */
    public String getCityName(){
        return cityName;
    }
        
    /**
     * set 市名称
     * 
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * get 市编号
     * 
     * @return the cityNo
     */
    public String getCityNo(){
        return cityNo;
    }
        
    /**
     * set 市编号
     * 
     * @param cityNo the cityNo to set
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }
    
    /**
     * get 县名称
     * 
     * @return the countyName
     */
    public String getCountyName(){
        return countyName;
    }
        
    /**
     * set 县名称
     * 
     * @param countyName the countyName to set
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    
    /**
     * get 县编码
     * 
     * @return the countyNo
     */
    public String getCountyNo(){
        return countyNo;
    }
        
    /**
     * set 县编码
     * 
     * @param countyNo the countyNo to set
     */
    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }
    
    /**
     * get 详细地址
     * 
     * @return the address
     */
    public String getAddress(){
        return address;
    }
        
    /**
     * set 详细地址
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
     * get 电子邮件
     * 
     * @return the email
     */
    public String getEmail(){
        return email;
    }
        
    /**
     * set 电子邮件
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * get 邮编
     * 
     * @return the zipcode
     */
    public String getZipcode(){
        return zipcode;
    }
        
    /**
     * set 邮编
     * 
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    /**
     * get 开始时间
     * 
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }
    
    /**
     * set 开始时间
     * 
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    /**
     * get 结束时间
     * 
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }
    
    /**
     * set 结束时间
     * 
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
