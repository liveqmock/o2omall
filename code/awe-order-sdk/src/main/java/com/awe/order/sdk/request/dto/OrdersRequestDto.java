package com.awe.order.sdk.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * OrdersRequestDto：订单请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:06:38
 * 
 */
public class OrdersRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 自增id */
    private Long id; 
    /** 订单编号 */
    private String orderNo; 
    /** 100:事物订单;200:虚拟订单 */
    private Integer orderType; 
    /** 用户ID */
    private Long userId; 
    /** 下单用户账号 */
    private String userName; 
    /** 下单姓名 */
    private String orderName; 
    /** 收货人姓名 */
    private String consigneeName; 
    /** 收货人手机号 */
    private String consigneePhone; 
    /** 固定电话 */
    private String telephone; 
    /** 邮箱 */
    private String emil; 
    /** 邮编 */
    private String zipCode; 
    /** 支付名称 */
    private String payName; 
    /** 1-只工作日送货(双休日、假日不用送)
2-工作日、双休日与假日均可送货
3-只双休日、假日送货(工作日不用送)
 */
    private Integer orderDate; 
    /** 0-否;1-确定 */
    private Integer isTalSure; 
    /** 1-现金;2-Pos刷卡 */
    private Integer payWay; 
    /** 1-货到付款;2-在线支付;3-公司转账;4-邮件汇款 */
    private Integer payType; 
    /** 0:不要;1:要 */
    private Integer isInvoice; 
    /** 1-普通发票;2-增值税发票 */
    private Integer invoiceType; 
    /** 1-个人;2-单位 */
    private Integer invoiceTitle; 
    /** 1-明细;2-办公用品;3-电脑配件;4-耗材； */
    private Integer invoiceContent; 
    /** 10-用户取消;20-用户删除;30-系统取消;40-待付款;50-已收款;60-已发货;70-已签收;80-订单完成;90-待拆单;100-拆单完成;110-订单审核;120-待退货;130-已退货;140-待换货;150-已换货;160-已退款;
 */
    private Integer orderStatus; 
    /** 总商品金额 */
    private Double commAmount; 
    /** 返现 */
    private Double retCash; 
    /** 运费 */
    private Double expenses; 
    /** 应付总额 */
    private Double amountPay; 
    /** 父订单编号 */
    private String parentOrderNo; 
    /** 省份名称 */
    private String provinceName; 
    /** 省份编号 */
    private String provinceNo; 
    /** 市名称 */
    private String cityName; 
    /** 市编号 */
    private String cityNo; 
    /** 县名称 */
    private String countyName; 
    /** 县编码 */
    private String countyNo; 
    /** 送货地址 */
    private String address; 
    /** 支付时间 */
    private Date payTime; 
    /** 订单备注 */
    private String remark; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createName; 
    /** 积分 */
    private Integer integral; 
    /** 修改人 */
    private String updateName; 
    /** 0:无效;1有效 */
    private Integer yn; 
    
    /**
     * get 自增id
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 自增id
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get 订单编号
     * 
     * @return the orderNo
     */
    public String getOrderNo(){
        return orderNo;
    }
        
    /**
     * set 订单编号
     * 
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    /**
     * get 100:事物订单;200:虚拟订单
     * 
     * @return the orderType
     */
    public Integer getOrderType(){
        return orderType;
    }
        
    /**
     * set 100:事物订单;200:虚拟订单
     * 
     * @param orderType the orderType to set
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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
     * get 下单用户账号
     * 
     * @return the userName
     */
    public String getUserName(){
        return userName;
    }
        
    /**
     * set 下单用户账号
     * 
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * get 下单姓名
     * 
     * @return the orderName
     */
    public String getOrderName(){
        return orderName;
    }
        
    /**
     * set 下单姓名
     * 
     * @param orderName the orderName to set
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    /**
     * get 收货人姓名
     * 
     * @return the consigneeName
     */
    public String getConsigneeName(){
        return consigneeName;
    }
        
    /**
     * set 收货人姓名
     * 
     * @param consigneeName the consigneeName to set
     */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }
    
    /**
     * get 收货人手机号
     * 
     * @return the consigneePhone
     */
    public String getConsigneePhone(){
        return consigneePhone;
    }
        
    /**
     * set 收货人手机号
     * 
     * @param consigneePhone the consigneePhone to set
     */
    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }
    
    /**
     * get 固定电话
     * 
     * @return the telephone
     */
    public String getTelephone(){
        return telephone;
    }
        
    /**
     * set 固定电话
     * 
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    /**
     * get 邮箱
     * 
     * @return the emil
     */
    public String getEmil(){
        return emil;
    }
        
    /**
     * set 邮箱
     * 
     * @param emil the emil to set
     */
    public void setEmil(String emil) {
        this.emil = emil;
    }
    
    /**
     * get 邮编
     * 
     * @return the zipCode
     */
    public String getZipCode(){
        return zipCode;
    }
        
    /**
     * set 邮编
     * 
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    /**
     * get 支付名称
     * 
     * @return the payName
     */
    public String getPayName(){
        return payName;
    }
        
    /**
     * set 支付名称
     * 
     * @param payName the payName to set
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }
    
    /**
     * get 1-只工作日送货(双休日、假日不用送)
2-工作日、双休日与假日均可送货
3-只双休日、假日送货(工作日不用送)

     * 
     * @return the orderDate
     */
    public Integer getOrderDate(){
        return orderDate;
    }
        
    /**
     * set 1-只工作日送货(双休日、假日不用送)
2-工作日、双休日与假日均可送货
3-只双休日、假日送货(工作日不用送)

     * 
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Integer orderDate) {
        this.orderDate = orderDate;
    }
    
    /**
     * get 0-否;1-确定
     * 
     * @return the isTalSure
     */
    public Integer getIsTalSure(){
        return isTalSure;
    }
        
    /**
     * set 0-否;1-确定
     * 
     * @param isTalSure the isTalSure to set
     */
    public void setIsTalSure(Integer isTalSure) {
        this.isTalSure = isTalSure;
    }
    
    /**
     * get 1-现金;2-Pos刷卡
     * 
     * @return the payWay
     */
    public Integer getPayWay(){
        return payWay;
    }
        
    /**
     * set 1-现金;2-Pos刷卡
     * 
     * @param payWay the payWay to set
     */
    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }
    
    /**
     * get 1-货到付款;2-在线支付;3-公司转账;4-邮件汇款
     * 
     * @return the payType
     */
    public Integer getPayType(){
        return payType;
    }
        
    /**
     * set 1-货到付款;2-在线支付;3-公司转账;4-邮件汇款
     * 
     * @param payType the payType to set
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    /**
     * get 0:不要;1:要
     * 
     * @return the isInvoice
     */
    public Integer getIsInvoice(){
        return isInvoice;
    }
        
    /**
     * set 0:不要;1:要
     * 
     * @param isInvoice the isInvoice to set
     */
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }
    
    /**
     * get 1-普通发票;2-增值税发票
     * 
     * @return the invoiceType
     */
    public Integer getInvoiceType(){
        return invoiceType;
    }
        
    /**
     * set 1-普通发票;2-增值税发票
     * 
     * @param invoiceType the invoiceType to set
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }
    
    /**
     * get 1-个人;2-单位
     * 
     * @return the invoiceTitle
     */
    public Integer getInvoiceTitle(){
        return invoiceTitle;
    }
        
    /**
     * set 1-个人;2-单位
     * 
     * @param invoiceTitle the invoiceTitle to set
     */
    public void setInvoiceTitle(Integer invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }
    
    /**
     * get 1-明细;2-办公用品;3-电脑配件;4-耗材；
     * 
     * @return the invoiceContent
     */
    public Integer getInvoiceContent(){
        return invoiceContent;
    }
        
    /**
     * set 1-明细;2-办公用品;3-电脑配件;4-耗材；
     * 
     * @param invoiceContent the invoiceContent to set
     */
    public void setInvoiceContent(Integer invoiceContent) {
        this.invoiceContent = invoiceContent;
    }
    
    /**
     * get 10-用户取消;20-用户删除;30-系统取消;40-待付款;50-已收款;60-已发货;70-已签收;80-订单完成;90-待拆单;100-拆单完成;110-订单审核;120-待退货;130-已退货;140-待换货;150-已换货;160-已退款;

     * 
     * @return the orderStatus
     */
    public Integer getOrderStatus(){
        return orderStatus;
    }
        
    /**
     * set 10-用户取消;20-用户删除;30-系统取消;40-待付款;50-已收款;60-已发货;70-已签收;80-订单完成;90-待拆单;100-拆单完成;110-订单审核;120-待退货;130-已退货;140-待换货;150-已换货;160-已退款;

     * 
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    /**
     * get 总商品金额
     * 
     * @return the commAmount
     */
    public Double getCommAmount(){
        return commAmount;
    }
        
    /**
     * set 总商品金额
     * 
     * @param commAmount the commAmount to set
     */
    public void setCommAmount(Double commAmount) {
        this.commAmount = commAmount;
    }
    
    /**
     * get 返现
     * 
     * @return the retCash
     */
    public Double getRetCash(){
        return retCash;
    }
        
    /**
     * set 返现
     * 
     * @param retCash the retCash to set
     */
    public void setRetCash(Double retCash) {
        this.retCash = retCash;
    }
    
    /**
     * get 运费
     * 
     * @return the expenses
     */
    public Double getExpenses(){
        return expenses;
    }
        
    /**
     * set 运费
     * 
     * @param expenses the expenses to set
     */
    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }
    
    /**
     * get 应付总额
     * 
     * @return the amountPay
     */
    public Double getAmountPay(){
        return amountPay;
    }
        
    /**
     * set 应付总额
     * 
     * @param amountPay the amountPay to set
     */
    public void setAmountPay(Double amountPay) {
        this.amountPay = amountPay;
    }
    
    /**
     * get 父订单编号
     * 
     * @return the parentOrderNo
     */
    public String getParentOrderNo(){
        return parentOrderNo;
    }
        
    /**
     * set 父订单编号
     * 
     * @param parentOrderNo the parentOrderNo to set
     */
    public void setParentOrderNo(String parentOrderNo) {
        this.parentOrderNo = parentOrderNo;
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
     * get 省份编号
     * 
     * @return the provinceNo
     */
    public String getProvinceNo(){
        return provinceNo;
    }
        
    /**
     * set 省份编号
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
     * get 送货地址
     * 
     * @return the address
     */
    public String getAddress(){
        return address;
    }
        
    /**
     * set 送货地址
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * get 支付时间
     * 
     * @return the payTime
     */
    public Date getPayTime(){
        return payTime;
    }
        
    /**
     * set 支付时间
     * 
     * @param payTime the payTime to set
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    
    /**
     * get 订单备注
     * 
     * @return the remark
     */
    public String getRemark(){
        return remark;
    }
        
    /**
     * set 订单备注
     * 
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return the createName
     */
    public String getCreateName(){
        return createName;
    }
        
    /**
     * set 创建人
     * 
     * @param createName the createName to set
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    
    /**
     * get 积分
     * 
     * @return the integral
     */
    public Integer getIntegral(){
        return integral;
    }
        
    /**
     * set 积分
     * 
     * @param integral the integral to set
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    
    /**
     * get 修改人
     * 
     * @return the updateName
     */
    public String getUpdateName(){
        return updateName;
    }
        
    /**
     * set 修改人
     * 
     * @param updateName the updateName to set
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
    
    /**
     * get 0:无效;1有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 0:无效;1有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
