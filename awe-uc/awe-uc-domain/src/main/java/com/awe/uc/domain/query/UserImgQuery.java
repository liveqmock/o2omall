package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * UserImgQuery：用户关联图片查询类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:30
 * 
 */
public class UserImgQuery extends Query {
    
    /** 自增id */
	private Long id; 
    /** 用户编号 */
	private String userNo; 
    /** 用户创建图片目录名称 */
	private String imgCatalog; 
    /** 目录对应唯一编码 */
	private String imgCatalogNo; 
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
	
    public String getUserNo(){
		return userNo;
	}
	    
    public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
    public String getImgCatalog(){
		return imgCatalog;
	}
	    
    public void setImgCatalog(String imgCatalog) {
		this.imgCatalog = imgCatalog;
	}
	
    public String getImgCatalogNo(){
		return imgCatalogNo;
	}
	    
    public void setImgCatalogNo(String imgCatalogNo) {
		this.imgCatalogNo = imgCatalogNo;
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
