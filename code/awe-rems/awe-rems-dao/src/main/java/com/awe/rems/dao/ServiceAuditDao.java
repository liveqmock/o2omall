package com.awe.rems.dao;

import java.util.List;

import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;
/**
 * ServiceAuditDao接口<br/>
 * 对'退换货审核流表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:15
 * 
 */
public interface ServiceAuditDao {
    
    /**
     * 新增对象
     * 
     * @param serviceAudit 
     * @return
     */
    public boolean insert(ServiceAudit serviceAudit);

    /**
     * 更新对象
     * 
     * @param serviceAudit
     * @return
     */
    public boolean update(ServiceAudit serviceAudit);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryServiceAuditCount(ServiceAuditQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean);

    /**
     * 删除记录
     * 
     * @param serviceAudit
     * @return
     */
    public boolean delete(ServiceAudit serviceAudit);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ServiceAudit getServiceAuditById(Long id);

    /**
     * 判断是否存在
     * 
     * @param serviceAudit
     * @return
     */
    public boolean exist(ServiceAudit serviceAudit);

}
