package com.awe.pms.sdk.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ProductBrandResponseDto：商品类别品牌返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-25 9:31:59
 * 
 */
public class ProductBrandResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** 一级分类 */
    private Long categoryOneId; 
    /** 一级分类名称 */
    private String categoryOne; 
    /** 二级分类 */
    private Long categoryTwoId; 
    /** 二级分类名称 */
    private String categoryTwo; 
    /** 三级分类 */
    private Long categoryThreeId; 
    /** 三级分类名称 */
    private String categoryThree; 
    /** 品牌编号 */
    private String brandCode; 
    /** 品牌名称 */
    private String brandName; 
    /** 品牌英文名称 */
    private String enName; 
    /** 品牌简称 */
    private String brandAbbr; 
    /** 关键字 */
    private String keyword; 
    /** 商品类型（国内、进口） */
    private Integer type; 
    /** 商品类型名称 */
    private String typeName; 
    /** 地区-省份-名称 */
    private String provinceName; 
    /** 地区-省份-编号 */
    private String provinceNo; 
    /** 地区-市-名称 */
    private String cityName; 
    /** 地区-市-编号 */
    private String cityNo; 
    /** 优先级 */
    private Integer priority; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 是否有效 */
    private Integer yn; 
    
    /**
     * get 主键
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 主键
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 一级分类
     * 
     * @return the categoryOneId
     */
    public Long getCategoryOneId(){
        return categoryOneId;
    }
        
    /**
     * set 一级分类
     * 
     * @param categoryOneId the categoryOneId to set
     */
    public void setCategoryOneId(Long categoryOneId) {
        this.categoryOneId = categoryOneId;
    }
    
    /**
     * get 一级分类名称
     * 
     * @return the categoryOne
     */
    public String getCategoryOne(){
        return categoryOne;
    }
        
    /**
     * set 一级分类名称
     * 
     * @param categoryOne the categoryOne to set
     */
    public void setCategoryOne(String categoryOne) {
        this.categoryOne = categoryOne;
    }
    
    /**
     * get 二级分类
     * 
     * @return the categoryTwoId
     */
    public Long getCategoryTwoId(){
        return categoryTwoId;
    }
        
    /**
     * set 二级分类
     * 
     * @param categoryTwoId the categoryTwoId to set
     */
    public void setCategoryTwoId(Long categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }
    
    /**
     * get 二级分类名称
     * 
     * @return the categoryTwo
     */
    public String getCategoryTwo(){
        return categoryTwo;
    }
        
    /**
     * set 二级分类名称
     * 
     * @param categoryTwo the categoryTwo to set
     */
    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo;
    }
    
    /**
     * get 三级分类
     * 
     * @return the categoryThreeId
     */
    public Long getCategoryThreeId(){
        return categoryThreeId;
    }
        
    /**
     * set 三级分类
     * 
     * @param categoryThreeId the categoryThreeId to set
     */
    public void setCategoryThreeId(Long categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }
    
    /**
     * get 三级分类名称
     * 
     * @return the categoryThree
     */
    public String getCategoryThree(){
        return categoryThree;
    }
        
    /**
     * set 三级分类名称
     * 
     * @param categoryThree the categoryThree to set
     */
    public void setCategoryThree(String categoryThree) {
        this.categoryThree = categoryThree;
    }
    
    /**
     * get 品牌编号
     * 
     * @return the brandCode
     */
    public String getBrandCode(){
        return brandCode;
    }
        
    /**
     * set 品牌编号
     * 
     * @param brandCode the brandCode to set
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    
    /**
     * get 品牌名称
     * 
     * @return the brandName
     */
    public String getBrandName(){
        return brandName;
    }
        
    /**
     * set 品牌名称
     * 
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    /**
     * get 品牌英文名称
     * 
     * @return the enName
     */
    public String getEnName(){
        return enName;
    }
        
    /**
     * set 品牌英文名称
     * 
     * @param enName the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
    
    /**
     * get 品牌简称
     * 
     * @return the brandAbbr
     */
    public String getBrandAbbr(){
        return brandAbbr;
    }
        
    /**
     * set 品牌简称
     * 
     * @param brandAbbr the brandAbbr to set
     */
    public void setBrandAbbr(String brandAbbr) {
        this.brandAbbr = brandAbbr;
    }
    
    /**
     * get 关键字
     * 
     * @return the keyword
     */
    public String getKeyword(){
        return keyword;
    }
        
    /**
     * set 关键字
     * 
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    /**
     * get 商品类型（国内、进口）
     * 
     * @return the type
     */
    public Integer getType(){
        return type;
    }
        
    /**
     * set 商品类型（国内、进口）
     * 
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * get 商品类型名称
     * 
     * @return the typeName
     */
    public String getTypeName(){
        return typeName;
    }
        
    /**
     * set 商品类型名称
     * 
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
     * get 优先级
     * 
     * @return the priority
     */
    public Integer getPriority(){
        return priority;
    }
        
    /**
     * set 优先级
     * 
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
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
     * get 是否有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
