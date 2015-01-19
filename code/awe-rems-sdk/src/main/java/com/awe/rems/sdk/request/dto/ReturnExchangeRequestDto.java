package com.awe.rems.sdk.request.dto;

import java.util.Date;

import com.hbird.common.sdk.api.dto.HbirdDto;

/**
 * ReturnExchangeRequestDto：退换货请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ReturnExchangeRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** id自增 */
    private Long id; 
    /** 售后单号:退货T开头;换货H开头;维修X开头 */
    private String serviceNo; 
    /** 取件单号:对应的快递的取件单号 */
    private String pickupNo; 
    /** 售后单审核状态 */
    private Integer serviceAuditStatus; 
    /** 订单号 */
    private String orderNo; 
    /** 商品分类编号 */
    private Long categoryId; 
    /** 商品编号 */
    private String productNo; 
    /** SKU编号 */
    private String skuNo; 
    /** SKU名称 */
    private String skuName; 
    /** 服务类型:1:退货:2:换货:3维修 */
    private Integer serviceType; 
    /** 申请的商品数量 */
    private Long quantity; 
    /** 凭据类型:1:发票:2:检测报告 */
    private Integer evidenceType; 
    /** 问题描述 */
    private String problemDescription; 
    /** 取件类型:1:上门取件 */
    private Integer pickupType; 
    /** 取件省编码 */
    private String pickupProvinceNo; 
    /** 取件省名称 */
    private String pickupProvinceName; 
    /** 取件市编码 */
    private String pickupCityNo; 
    /** 取件市名字 */
    private String pickupCityName; 
    /** 取件县编码 */
    private String pickupCountyNo; 
    /** 取件县名称 */
    private String pickupCuountyName; 
    /** 取件详细地址 */
    private String pickupDetailedAddress; 
    /** 预约取件时间 */
    private Date reservationPickupTime; 
    /** 收货省编码 */
    private String provinceNo; 
    /** 收货省名称 */
    private String provinceName; 
    /** 收货市编码 */
    private String cityNo; 
    /** 收货市名字 */
    private String cityName; 
    /** 收货县编码 */
    private String countyNo; 
    /** 收货县名称 */
    private String cuountyName; 
    /** 收货详细地址 */
    private String detailedAddress; 
    /** 收货人 */
    private String consignee; 
    /** 收货人手机号 */
    private String mobileNo; 
    /** 固定电话 */
    private String telephoneNo; 
    /** 快递公司名称 */
    private String expressName; 
    /** 快递公司编号 */
    private String expressNo; 
    /** 快递单号 */
    private String waybillNo; 
    /** 创建时间 */
    private Date createTime; 
    /** 更新时间 */
    private Date updateTime; 
    /** 创建人id */
    private Long createUserId; 
    /** 创建人 */
    private String createUser; 
    /** 更新人id */
    private Long updateUserId; 
    /** 更新人 */
    private String updateUser; 
    /** 是否有效:1有效;0:无效 */
    private Integer yn; 
    /** 用户ID */
    private Long userId; 
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
     * get 售后单号:退货T开头;换货H开头;维修X开头
     * 
     * @return the serviceNo
     */
    public String getServiceNo(){
        return serviceNo;
    }
        
    /**
     * set 售后单号:退货T开头;换货H开头;维修X开头
     * 
     * @param serviceNo the serviceNo to set
     */
    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }
    
    /**
     * get 取件单号:对应的快递的取件单号
     * 
     * @return the pickupNo
     */
    public String getPickupNo(){
        return pickupNo;
    }
        
    /**
     * set 取件单号:对应的快递的取件单号
     * 
     * @param pickupNo the pickupNo to set
     */
    public void setPickupNo(String pickupNo) {
        this.pickupNo = pickupNo;
    }
    
    /**
     * get 售后单审核状态
     * 
     * @return the serviceAuditStatus
     */
    public Integer getServiceAuditStatus(){
        return serviceAuditStatus;
    }
        
    /**
     * set 售后单审核状态
     * 
     * @param serviceAuditStatus the serviceAuditStatus to set
     */
    public void setServiceAuditStatus(Integer serviceAuditStatus) {
        this.serviceAuditStatus = serviceAuditStatus;
    }
    
    /**
     * get 订单号
     * 
     * @return the orderNo
     */
    public String getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单号
     * 
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    /**
     * get 商品分类编号
     * 
     * @return the categoryId
     */
    public Long getCategoryId(){
        return categoryId;
    }
        
    /**
     * set 商品分类编号
     * 
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    
    /**
     * get 商品名称
     * 
     * @return the skuName
     */
    public String getSkuName(){
        return skuName;
    }
    
    public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getSkuNo() {
		return skuNo;
	}

	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}

	/**
     * set 商品名称
     * 
     * @param skuName the skuName to set
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    
    /**
     * get 服务类型:1:退货:2:换货:3维修
     * 
     * @return the serviceType
     */
    public Integer getServiceType(){
        return serviceType;
    }
        
    /**
     * set 服务类型:1:退货:2:换货:3维修
     * 
     * @param serviceType the serviceType to set
     */
    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }
    
    /**
     * get 申请的商品数量
     * 
     * @return the quantity
     */
    public Long getQuantity(){
        return quantity;
    }
        
    /**
     * set 申请的商品数量
     * 
     * @param quantity the quantity to set
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    /**
     * get 凭据类型:1:发票:2:检测报告
     * 
     * @return the evidenceType
     */
    public Integer getEvidenceType(){
        return evidenceType;
    }
        
    /**
     * set 凭据类型:1:发票:2:检测报告
     * 
     * @param evidenceType the evidenceType to set
     */
    public void setEvidenceType(Integer evidenceType) {
        this.evidenceType = evidenceType;
    }
    
    /**
     * get 问题描述
     * 
     * @return the problemDescription
     */
    public String getProblemDescription(){
        return problemDescription;
    }
        
    /**
     * set 问题描述
     * 
     * @param problemDescription the problemDescription to set
     */
    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }
    
    /**
     * get 取件类型:1:上门取件
     * 
     * @return the pickupType
     */
    public Integer getPickupType(){
        return pickupType;
    }
        
    /**
     * set 取件类型:1:上门取件
     * 
     * @param pickupType the pickupType to set
     */
    public void setPickupType(Integer pickupType) {
        this.pickupType = pickupType;
    }
    
    /**
     * get 取件省编码
     * 
     * @return the pickupProvinceNo
     */
    public String getPickupProvinceNo(){
        return pickupProvinceNo;
    }
        
    /**
     * set 取件省编码
     * 
     * @param pickupProvinceNo the pickupProvinceNo to set
     */
    public void setPickupProvinceNo(String pickupProvinceNo) {
        this.pickupProvinceNo = pickupProvinceNo;
    }
    
    /**
     * get 取件省名称
     * 
     * @return the pickupProvinceName
     */
    public String getPickupProvinceName(){
        return pickupProvinceName;
    }
        
    /**
     * set 取件省名称
     * 
     * @param pickupProvinceName the pickupProvinceName to set
     */
    public void setPickupProvinceName(String pickupProvinceName) {
        this.pickupProvinceName = pickupProvinceName;
    }
    
    /**
     * get 取件市编码
     * 
     * @return the pickupCityNo
     */
    public String getPickupCityNo(){
        return pickupCityNo;
    }
        
    /**
     * set 取件市编码
     * 
     * @param pickupCityNo the pickupCityNo to set
     */
    public void setPickupCityNo(String pickupCityNo) {
        this.pickupCityNo = pickupCityNo;
    }
    
    /**
     * get 取件市名字
     * 
     * @return the pickupCityName
     */
    public String getPickupCityName(){
        return pickupCityName;
    }
        
    /**
     * set 取件市名字
     * 
     * @param pickupCityName the pickupCityName to set
     */
    public void setPickupCityName(String pickupCityName) {
        this.pickupCityName = pickupCityName;
    }
    
    /**
     * get 取件县编码
     * 
     * @return the pickupCountyNo
     */
    public String getPickupCountyNo(){
        return pickupCountyNo;
    }
        
    /**
     * set 取件县编码
     * 
     * @param pickupCountyNo the pickupCountyNo to set
     */
    public void setPickupCountyNo(String pickupCountyNo) {
        this.pickupCountyNo = pickupCountyNo;
    }
    
    /**
     * get 取件县名称
     * 
     * @return the pickupCuountyName
     */
    public String getPickupCuountyName(){
        return pickupCuountyName;
    }
        
    /**
     * set 取件县名称
     * 
     * @param pickupCuountyName the pickupCuountyName to set
     */
    public void setPickupCuountyName(String pickupCuountyName) {
        this.pickupCuountyName = pickupCuountyName;
    }
    
    /**
     * get 取件详细地址
     * 
     * @return the pickupDetailedAddress
     */
    public String getPickupDetailedAddress(){
        return pickupDetailedAddress;
    }
        
    /**
     * set 取件详细地址
     * 
     * @param pickupDetailedAddress the pickupDetailedAddress to set
     */
    public void setPickupDetailedAddress(String pickupDetailedAddress) {
        this.pickupDetailedAddress = pickupDetailedAddress;
    }
    
    /**
     * get 预约取件时间
     * 
     * @return the reservationPickupTime
     */
    public Date getReservationPickupTime(){
        return reservationPickupTime;
    }
        
    /**
     * set 预约取件时间
     * 
     * @param reservationPickupTime the reservationPickupTime to set
     */
    public void setReservationPickupTime(Date reservationPickupTime) {
        this.reservationPickupTime = reservationPickupTime;
    }
    
    /**
     * get 收货省编码
     * 
     * @return the provinceNo
     */
    public String getProvinceNo(){
        return provinceNo;
    }
        
    /**
     * set 收货省编码
     * 
     * @param provinceNo the provinceNo to set
     */
    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }
    
    /**
     * get 收货省名称
     * 
     * @return the provinceName
     */
    public String getProvinceName(){
        return provinceName;
    }
        
    /**
     * set 收货省名称
     * 
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    /**
     * get 收货市编码
     * 
     * @return the cityNo
     */
    public String getCityNo(){
        return cityNo;
    }
        
    /**
     * set 收货市编码
     * 
     * @param cityNo the cityNo to set
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }
    
    /**
     * get 收货市名字
     * 
     * @return the cityName
     */
    public String getCityName(){
        return cityName;
    }
        
    /**
     * set 收货市名字
     * 
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * get 收货县编码
     * 
     * @return the countyNo
     */
    public String getCountyNo(){
        return countyNo;
    }
        
    /**
     * set 收货县编码
     * 
     * @param countyNo the countyNo to set
     */
    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }
    
    /**
     * get 收货县名称
     * 
     * @return the cuountyName
     */
    public String getCuountyName(){
        return cuountyName;
    }
        
    /**
     * set 收货县名称
     * 
     * @param cuountyName the cuountyName to set
     */
    public void setCuountyName(String cuountyName) {
        this.cuountyName = cuountyName;
    }
    
    /**
     * get 收货详细地址
     * 
     * @return the detailedAddress
     */
    public String getDetailedAddress(){
        return detailedAddress;
    }
        
    /**
     * set 收货详细地址
     * 
     * @param detailedAddress the detailedAddress to set
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
    
    /**
     * get 收货人
     * 
     * @return the consignee
     */
    public String getConsignee(){
        return consignee;
    }
        
    /**
     * set 收货人
     * 
     * @param consignee the consignee to set
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    
    /**
     * get 收货人手机号
     * 
     * @return the mobileNo
     */
    public String getMobileNo(){
        return mobileNo;
    }
        
    /**
     * set 收货人手机号
     * 
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    /**
     * get 固定电话
     * 
     * @return the telephoneNo
     */
    public String getTelephoneNo(){
        return telephoneNo;
    }
        
    /**
     * set 固定电话
     * 
     * @param telephoneNo the telephoneNo to set
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
    
    /**
     * get 快递公司名称
     * 
     * @return the expressName
     */
    public String getExpressName(){
        return expressName;
    }
        
    /**
     * set 快递公司名称
     * 
     * @param expressName the expressName to set
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
    
    /**
     * get 快递公司编号
     * 
     * @return the expressNo
     */
    public String getExpressNo(){
        return expressNo;
    }
        
    /**
     * set 快递公司编号
     * 
     * @param expressNo the expressNo to set
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
    
    /**
     * get 快递单号
     * 
     * @return the waybillNo
     */
    public String getWaybillNo(){
        return waybillNo;
    }
        
    /**
     * set 快递单号
     * 
     * @param waybillNo the waybillNo to set
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
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
     * get 更新时间
     * 
     * @return the updateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }
        
    /**
     * set 更新时间
     * 
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * get 创建人id
     * 
     * @return the createUserId
     */
    public Long getCreateUserId(){
        return createUserId;
    }
        
    /**
     * set 创建人id
     * 
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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
     * get 更新人id
     * 
     * @return the updateUserId
     */
    public Long getUpdateUserId(){
        return updateUserId;
    }
        
    /**
     * set 更新人id
     * 
     * @param updateUserId the updateUserId to set
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
    
    /**
     * get 更新人
     * 
     * @return the updateUser
     */
    public String getUpdateUser(){
        return updateUser;
    }
        
    /**
     * set 更新人
     * 
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    /**
     * get 是否有效:1有效;0:无效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效:1有效;0:无效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
