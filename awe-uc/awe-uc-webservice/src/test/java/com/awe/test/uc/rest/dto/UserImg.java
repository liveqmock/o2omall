package com.awe.test.uc.rest.dto;

import com.hbird.common.sdk.api.HbirdObject;
import java.util.Date;

/**
 * UserImgResponse：用户关联图片返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class UserImg implements HbirdObject {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
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
}
