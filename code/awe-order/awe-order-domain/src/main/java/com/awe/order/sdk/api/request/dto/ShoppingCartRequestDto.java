package com.awe.order.sdk.api.request.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * ShoppingCartRequestDto：购物车请求参数
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class ShoppingCartRequestDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 自增id */
    private Long id; 
    /** 用户编号 */
    private Long userId; 
    /** 商品编号 */
    private String skuNo; 
    /** 商品数量 */
    private Integer skuCount; 
    /** 1:正常状态;2-删除;3-已下单 */
    private Integer status; 
    /** 创建时间 */
    private Date createTime; 
    /** 更新时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 0:无效;1:有效 */
    private Integer yn; 
    /** 销售商 */
    private String seller; 
    /** 销售商编号*/
    private String sellerNo;

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
    
    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
     * get 商品编号
     * 
     * @return the skuNo
     */
    public String getSkuNo(){
        return skuNo;
    }
        
    /**
     * set 商品编号
     * 
     * @param skuNo the skuNo to set
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }
    
    /**
     * get 商品数量
     * 
     * @return the skuCount
     */
    public Integer getSkuCount(){
        return skuCount;
    }
        
    /**
     * set 商品数量
     * 
     * @param skuCount the skuCount to set
     */
    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }
    
    /**
     * get 1:正常状态;2-删除;3-已下单
     * 
     * @return the status
     */
    public Integer getStatus(){
        return status;
    }
        
    /**
     * set 1:正常状态;2-删除;3-已下单
     * 
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * get 0:无效;1:有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 0:无效;1:有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

	 /**
     * get 销售商
     * 
     * @return the seller
     */
	public String getSeller() {
		return seller;
	}

	/**
     * set 销售商
     * 
     * @param seller the seller to set
     */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	/**
     * get 销售商编号
     * 
     * @return the seller
     */
	public String getSellerNo() {
		return sellerNo;
	}

	/**
     * set 销售商
     * 
     * @param sellerNo the sellerNo to set
     */
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
}
