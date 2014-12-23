package com.awe.pms.sdk.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ProductResponseDto：商品信息返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** 商品编号 */
    private String productNo; 
    /** 商品名称 */
    private String productName; 
    /** 商品英文名称 */
    private String enName; 
    /** 关键字 */
    private String keyword; 
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
    /** 商品SKU属性值 */
    private String skuAttrName; 
    /** 商品评分 */
    private String score; 
    /** 推荐级别 */
    private Integer level; 
    /** 品牌编号 */
    private String brandCode; 
    /** 品牌名称 */
    private String brandName; 
    /** 商品类型（国内、进口） */
    private Integer type; 
    /** 商品类型名称 */
    private String typeName; 
    /** 经营模式（自营。。） */
    private Integer mode; 
    /** 经营模式名称 */
    private String modeName; 
    /** 商家编号 */
    private String businessNo; 
    /** 商家名称 */
    private String businessName; 
    /** 食用方式（枚举） */
    private Long method; 
    /** 商品产地 */
    private String originPlace; 
    /** 商品上架时间 */
    private Date saleTimeStart; 
    /** 适用人群（配置表） */
    private String applicableCrowd; 
    /** 适用年龄（配置表） */
    private String applicableAge; 
    /** 特点 */
    private String features; 
    /** 商品描述 */
    private String describe; 
    /** 介绍 */
    private String introduce; 
    /** 服务（配送信息等） */
    private String service; 
    /** 商品净重 */
    private Double weight; 
    /** 毛重 */
    private Double grossWeight; 
    /** 长 */
    private Double length; 
    /** 宽 */
    private Double width; 
    /** 高 */
    private Double height; 
    /** 直径 */
    private Double diameter; 
    /** 包装类型（桶装等） */
    private Integer packType; 
    /** 包装长 */
    private Double packLength; 
    /** 包装宽 */
    private Double packWidth; 
    /** 包装高 */
    private Double packHeight; 
    /** 是否支持退货 */
    private Integer supportReturn; 
    /** 配送信息 */
    private String distribution; 
    /** 是否免运费 */
    private Integer freightFree; 
    /** 材质 */
    private String material; 
    /** 包装清单 */
    private String packingList; 
    /** 售后保障 */
    private String saleGuarantee; 
    /** 温馨提示 */
    private String kindlyReminder; 
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
     * get 商品编号
     * 
     * @return the productNo
     */
    public String getProductNo(){
        return productNo;
    }
        
    /**
     * set 商品编号
     * 
     * @param productNo the productNo to set
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    
    /**
     * get 商品名称
     * 
     * @return the productName
     */
    public String getProductName(){
        return productName;
    }
        
    /**
     * set 商品名称
     * 
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    /**
     * get 商品英文名称
     * 
     * @return the enName
     */
    public String getEnName(){
        return enName;
    }
        
    /**
     * set 商品英文名称
     * 
     * @param enName the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
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
     * get 商品SKU属性值
     * 
     * @return the skuAttrName
     */
    public String getSkuAttrName(){
        return skuAttrName;
    }
        
    /**
     * set 商品SKU属性值
     * 
     * @param skuAttrName the skuAttrName to set
     */
    public void setSkuAttrName(String skuAttrName) {
        this.skuAttrName = skuAttrName;
    }
    
    /**
     * get 商品评分
     * 
     * @return the score
     */
    public String getScore(){
        return score;
    }
        
    /**
     * set 商品评分
     * 
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }
    
    /**
     * get 推荐级别
     * 
     * @return the level
     */
    public Integer getLevel(){
        return level;
    }
        
    /**
     * set 推荐级别
     * 
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
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
     * get 经营模式（自营。。）
     * 
     * @return the mode
     */
    public Integer getMode(){
        return mode;
    }
        
    /**
     * set 经营模式（自营。。）
     * 
     * @param mode the mode to set
     */
    public void setMode(Integer mode) {
        this.mode = mode;
    }
    
    /**
     * get 经营模式名称
     * 
     * @return the modeName
     */
    public String getModeName(){
        return modeName;
    }
        
    /**
     * set 经营模式名称
     * 
     * @param modeName the modeName to set
     */
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }
    
    /**
     * get 商家编号
     * 
     * @return the businessNo
     */
    public String getBusinessNo(){
        return businessNo;
    }
        
    /**
     * set 商家编号
     * 
     * @param businessNo the businessNo to set
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
    
    /**
     * get 商家名称
     * 
     * @return the businessName
     */
    public String getBusinessName(){
        return businessName;
    }
        
    /**
     * set 商家名称
     * 
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    
    /**
     * get 食用方式（枚举）
     * 
     * @return the method
     */
    public Long getMethod(){
        return method;
    }
        
    /**
     * set 食用方式（枚举）
     * 
     * @param method the method to set
     */
    public void setMethod(Long method) {
        this.method = method;
    }
    
    /**
     * get 商品产地
     * 
     * @return the originPlace
     */
    public String getOriginPlace(){
        return originPlace;
    }
        
    /**
     * set 商品产地
     * 
     * @param originPlace the originPlace to set
     */
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }
    
    /**
     * get 商品上架时间
     * 
     * @return the saleTimeStart
     */
    public Date getSaleTimeStart(){
        return saleTimeStart;
    }
        
    /**
     * set 商品上架时间
     * 
     * @param saleTimeStart the saleTimeStart to set
     */
    public void setSaleTimeStart(Date saleTimeStart) {
        this.saleTimeStart = saleTimeStart;
    }
    
    /**
     * get 适用人群（配置表）
     * 
     * @return the applicableCrowd
     */
    public String getApplicableCrowd(){
        return applicableCrowd;
    }
        
    /**
     * set 适用人群（配置表）
     * 
     * @param applicableCrowd the applicableCrowd to set
     */
    public void setApplicableCrowd(String applicableCrowd) {
        this.applicableCrowd = applicableCrowd;
    }
    
    /**
     * get 适用年龄（配置表）
     * 
     * @return the applicableAge
     */
    public String getApplicableAge(){
        return applicableAge;
    }
        
    /**
     * set 适用年龄（配置表）
     * 
     * @param applicableAge the applicableAge to set
     */
    public void setApplicableAge(String applicableAge) {
        this.applicableAge = applicableAge;
    }
    
    /**
     * get 特点
     * 
     * @return the features
     */
    public String getFeatures(){
        return features;
    }
        
    /**
     * set 特点
     * 
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
    }
    
    /**
     * get 商品描述
     * 
     * @return the describe
     */
    public String getDescribe(){
        return describe;
    }
        
    /**
     * set 商品描述
     * 
     * @param describe the describe to set
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    /**
     * get 介绍
     * 
     * @return the introduce
     */
    public String getIntroduce(){
        return introduce;
    }
        
    /**
     * set 介绍
     * 
     * @param introduce the introduce to set
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    
    /**
     * get 服务（配送信息等）
     * 
     * @return the service
     */
    public String getService(){
        return service;
    }
        
    /**
     * set 服务（配送信息等）
     * 
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }
    
    /**
     * get 商品净重
     * 
     * @return the weight
     */
    public Double getWeight(){
        return weight;
    }
        
    /**
     * set 商品净重
     * 
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    /**
     * get 毛重
     * 
     * @return the grossWeight
     */
    public Double getGrossWeight(){
        return grossWeight;
    }
        
    /**
     * set 毛重
     * 
     * @param grossWeight the grossWeight to set
     */
    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }
    
    /**
     * get 长
     * 
     * @return the length
     */
    public Double getLength(){
        return length;
    }
        
    /**
     * set 长
     * 
     * @param length the length to set
     */
    public void setLength(Double length) {
        this.length = length;
    }
    
    /**
     * get 宽
     * 
     * @return the width
     */
    public Double getWidth(){
        return width;
    }
        
    /**
     * set 宽
     * 
     * @param width the width to set
     */
    public void setWidth(Double width) {
        this.width = width;
    }
    
    /**
     * get 高
     * 
     * @return the height
     */
    public Double getHeight(){
        return height;
    }
        
    /**
     * set 高
     * 
     * @param height the height to set
     */
    public void setHeight(Double height) {
        this.height = height;
    }
    
    /**
     * get 直径
     * 
     * @return the diameter
     */
    public Double getDiameter(){
        return diameter;
    }
        
    /**
     * set 直径
     * 
     * @param diameter the diameter to set
     */
    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }
    
    /**
     * get 包装类型（桶装等）
     * 
     * @return the packType
     */
    public Integer getPackType(){
        return packType;
    }
        
    /**
     * set 包装类型（桶装等）
     * 
     * @param packType the packType to set
     */
    public void setPackType(Integer packType) {
        this.packType = packType;
    }
    
    /**
     * get 包装长
     * 
     * @return the packLength
     */
    public Double getPackLength(){
        return packLength;
    }
        
    /**
     * set 包装长
     * 
     * @param packLength the packLength to set
     */
    public void setPackLength(Double packLength) {
        this.packLength = packLength;
    }
    
    /**
     * get 包装宽
     * 
     * @return the packWidth
     */
    public Double getPackWidth(){
        return packWidth;
    }
        
    /**
     * set 包装宽
     * 
     * @param packWidth the packWidth to set
     */
    public void setPackWidth(Double packWidth) {
        this.packWidth = packWidth;
    }
    
    /**
     * get 包装高
     * 
     * @return the packHeight
     */
    public Double getPackHeight(){
        return packHeight;
    }
        
    /**
     * set 包装高
     * 
     * @param packHeight the packHeight to set
     */
    public void setPackHeight(Double packHeight) {
        this.packHeight = packHeight;
    }
    
    /**
     * get 是否支持退货
     * 
     * @return the supportReturn
     */
    public Integer getSupportReturn(){
        return supportReturn;
    }
        
    /**
     * set 是否支持退货
     * 
     * @param supportReturn the supportReturn to set
     */
    public void setSupportReturn(Integer supportReturn) {
        this.supportReturn = supportReturn;
    }
    
    /**
     * get 配送信息
     * 
     * @return the distribution
     */
    public String getDistribution(){
        return distribution;
    }
        
    /**
     * set 配送信息
     * 
     * @param distribution the distribution to set
     */
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
    
    /**
     * get 是否免运费
     * 
     * @return the freightFree
     */
    public Integer getFreightFree(){
        return freightFree;
    }
        
    /**
     * set 是否免运费
     * 
     * @param freightFree the freightFree to set
     */
    public void setFreightFree(Integer freightFree) {
        this.freightFree = freightFree;
    }
    
    /**
     * get 材质
     * 
     * @return the material
     */
    public String getMaterial(){
        return material;
    }
        
    /**
     * set 材质
     * 
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    /**
     * get 包装清单
     * 
     * @return the packingList
     */
    public String getPackingList(){
        return packingList;
    }
        
    /**
     * set 包装清单
     * 
     * @param packingList the packingList to set
     */
    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }
    
    /**
     * get 售后保障
     * 
     * @return the saleGuarantee
     */
    public String getSaleGuarantee(){
        return saleGuarantee;
    }
        
    /**
     * set 售后保障
     * 
     * @param saleGuarantee the saleGuarantee to set
     */
    public void setSaleGuarantee(String saleGuarantee) {
        this.saleGuarantee = saleGuarantee;
    }
    
    /**
     * get 温馨提示
     * 
     * @return the kindlyReminder
     */
    public String getKindlyReminder(){
        return kindlyReminder;
    }
        
    /**
     * set 温馨提示
     * 
     * @param kindlyReminder the kindlyReminder to set
     */
    public void setKindlyReminder(String kindlyReminder) {
        this.kindlyReminder = kindlyReminder;
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
