package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;
/**
 * BusinessInfoDao接口<br/>
 * 对'商家信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:28
 * 
 */
public interface BusinessInfoDao {
    
    /**
     * 新增对象
     * 
     * @param businessInfo 
     * @return
     */
    public boolean insert(BusinessInfo businessInfo);

    /**
     * 更新对象
     * 
     * @param businessInfo
     * @return
     */
    public boolean update(BusinessInfo businessInfo);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BusinessInfo> queryBusinessInfoList(BusinessInfoQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryBusinessInfoCount(BusinessInfoQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BusinessInfo> queryBusinessInfoListWithPage(BusinessInfoQuery queryBean);

    /**
     * 删除记录
     * 
     * @param businessInfo
     * @return
     */
    public boolean delete(BusinessInfo businessInfo);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public BusinessInfo getBusinessInfoById(Long id);

    /**
     * 判断是否存在
     * 
     * @param businessInfo
     * @return
     */
    public boolean exist(BusinessInfo businessInfo);

}
