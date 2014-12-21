package com.awe.uc.sdk.request;

import com.hbird.common.sdk.api.request.HbirdRequest;
import java.util.Date;

/**
 * OrderAddressRequest：收货地址表请求参数
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class OrderAddressRequest extends HbirdRequest {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 自增 */
    private Long id; 
    /** 用户ID */
    private Long userNo; 
    /** 收货人姓名 */
    private String addName; 
    /** 省份名称 */
    private String addProvinceName; 
    /** 省份编码 */
    private String addProvinceNo; 
    /** 市名称 */
    private String addCityName; 
    /** 市编号 */
    private String addCityNo; 
    /** 区名称 */
    private String addAreaName; 
    /** 区编码 */
    private String addAreaNo; 
    /** 详细地址 */
    private String addAddress; 
    /** 移动电话 */
    private String addMobile; 
    /** 固定电话 */
    private String addTelephone; 
    /** 电子邮件 */
    private String addEmail; 
    /** 邮编 */
    private String addZipcode; 
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
    
    public Long getId(){
        return id;
    }
        
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserNo(){
        return userNo;
    }
        
    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }
    
    public String getAddName(){
        return addName;
    }
        
    public void setAddName(String addName) {
        this.addName = addName;
    }
    
    public String getAddProvinceName(){
        return addProvinceName;
    }
        
    public void setAddProvinceName(String addProvinceName) {
        this.addProvinceName = addProvinceName;
    }
    
    public String getAddProvinceNo(){
        return addProvinceNo;
    }
        
    public void setAddProvinceNo(String addProvinceNo) {
        this.addProvinceNo = addProvinceNo;
    }
    
    public String getAddCityName(){
        return addCityName;
    }
        
    public void setAddCityName(String addCityName) {
        this.addCityName = addCityName;
    }
    
    public String getAddCityNo(){
        return addCityNo;
    }
        
    public void setAddCityNo(String addCityNo) {
        this.addCityNo = addCityNo;
    }
    
    public String getAddAreaName(){
        return addAreaName;
    }
        
    public void setAddAreaName(String addAreaName) {
        this.addAreaName = addAreaName;
    }
    
    public String getAddAreaNo(){
        return addAreaNo;
    }
        
    public void setAddAreaNo(String addAreaNo) {
        this.addAreaNo = addAreaNo;
    }
    
    public String getAddAddress(){
        return addAddress;
    }
        
    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }
    
    public String getAddMobile(){
        return addMobile;
    }
        
    public void setAddMobile(String addMobile) {
        this.addMobile = addMobile;
    }
    
    public String getAddTelephone(){
        return addTelephone;
    }
        
    public void setAddTelephone(String addTelephone) {
        this.addTelephone = addTelephone;
    }
    
    public String getAddEmail(){
        return addEmail;
    }
        
    public void setAddEmail(String addEmail) {
        this.addEmail = addEmail;
    }
    
    public String getAddZipcode(){
        return addZipcode;
    }
        
    public void setAddZipcode(String addZipcode) {
        this.addZipcode = addZipcode;
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
}
