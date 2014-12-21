package com.awe.uc.domain.query;

import java.util.Date;

import com.hbird.common.utils.page.Query;

/**
 * AreaQuery：三级地址基础信息查询类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:30
 * 
 */
public class AreaQuery extends Query {
    
    /** id */
	private Long id; 
    /** 父编号 */
	private String pCode; 
    /** 编号 */
	private String code; 
    /** 级别 */
	private Integer leval; 
    /** 名称 */
	private String name; 
    /** 创建人 */
	private String createName; 
    /** 创建时间 */
	private Date createTime; 
    /** 修改人 */
	private String updateName; 
    /** 修改时间 */
	private Date updateTime; 
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
	
    public String getPCode(){
		return pCode;
	}
	    
    public void setPCode(String pCode) {
		this.pCode = pCode;
	}
	
    public String getCode(){
		return code;
	}
	    
    public void setCode(String code) {
		this.code = code;
	}
	
    public Integer getLeval(){
		return leval;
	}
	    
    public void setLeval(Integer leval) {
		this.leval = leval;
	}
	
    public String getName(){
		return name;
	}
	    
    public void setName(String name) {
		this.name = name;
	}
	
    public String getCreateName(){
		return createName;
	}
	    
    public void setCreateName(String createName) {
		this.createName = createName;
	}
	
    public Date getCreateTime(){
		return createTime;
	}
	    
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    public String getUpdateName(){
		return updateName;
	}
	    
    public void setUpdateName(String updateName) {
		this.updateName = updateName;
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
